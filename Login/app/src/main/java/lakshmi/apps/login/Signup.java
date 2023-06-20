package lakshmi.apps.login;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jai on 9/18/2016.
 */
public class Signup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
    }
    public void register(View view)
    {
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        DBHelper db = new DBHelper(this);
        db.insertUser(username,password);
        Toast.makeText(this,"Registered Sucessfully! ",Toast.LENGTH_SHORT).show();
        finish();
    }
}
