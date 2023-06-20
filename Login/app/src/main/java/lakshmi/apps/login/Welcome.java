package lakshmi.apps.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Jai on 9/18/2016.
 */
public class Welcome extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        String un = getIntent().getExtras().getString("name");
        ((TextView)findViewById(R.id.welcomeText)).setText("Hi "+ un +" have a good day!");
    }
}
