package lakshmi.apps.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);

    }

    public void signup(View view) {
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
    }
}
