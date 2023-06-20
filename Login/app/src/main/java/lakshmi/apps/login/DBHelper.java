package lakshmi.apps.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LOGIN_DB";
    private static final String TABLE_LOGIN = "details";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "username";
    private static final String KEY_PWD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.wtf("################################ DBHelper", "constructor");
        /* null = cursor factory = use default */
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_contacts_table = "CREATE TABLE " + TABLE_LOGIN + " (" + KEY_ID + " " +
                "INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_PWD + " TEXT" + ")";
        sqLiteDatabase.execSQL(create_contacts_table);
        Log.wtf("################################ DBHelper", "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        onCreate(sqLiteDatabase);
    }

    public boolean exists(String username){
        SQLiteDatabase db = this.getReadableDatabase();
         long numrows = DatabaseUtils.longForQuery(db,"select count(*) from " + TABLE_LOGIN + " where username = " + username,null);
        db.close();
        if(numrows==0)
            return false;
        else return true;
    }

    public void insertUser(String username,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,username);
        values.put(KEY_PWD,password);

        db.insert(TABLE_LOGIN,null,values);
        db.close();
    }

    public boolean authenticate(String ID,String pwd)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        long numrows = DatabaseUtils.longForQuery(db,"select count(*) from " + TABLE_LOGIN + " where username = '" + ID + "' AND " + "password = '"+pwd + "'",null);

        db.close();
        if(numrows==0)
            return false;
        else
            return true;
    }
}
