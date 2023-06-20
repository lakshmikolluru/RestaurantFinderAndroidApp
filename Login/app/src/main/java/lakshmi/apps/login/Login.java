package lakshmi.apps.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jai on 9/18/2016.
 */
public class Login extends Activity {

    public Login() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }

    public void submit(View view) {
        String id = ((EditText)findViewById(R.id.username)).getText().toString();
        String pwd = ((EditText)findViewById(R.id.password)).getText().toString();

        if(id.equals("")) {
            Toast.makeText(this, " Enter the username and password ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Welcome.class);

        }
        else if(pwd.equals(""))
            Toast.makeText(this," Enter the password ",Toast.LENGTH_SHORT).show();
        DBHelper db = new DBHelper(this);
        if(db.authenticate(id,pwd))
        {
            Toast.makeText(this," Successfully login ",Toast.LENGTH_SHORT).show();
            Log.wtf("################################ DBHelper","");
        }
        else
            Toast.makeText(this," Either Username or Password is incorrect ",Toast.LENGTH_SHORT).show();

    }
}
