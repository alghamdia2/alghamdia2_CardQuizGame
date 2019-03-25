package com.example.d7om0.alghamdia2_CardQuizGame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.d7om0.alghamdia2_login_register.R;

public class SignActivity extends AppCompatActivity {
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_screen);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("name", null);
        if (restoredText != null) {
            String uname = prefs.getString("name", "No name defined");//"No name defined" is the default value.
            String restoredgame = prefs.getString(uname, null);
            if(restoredgame!=null)
            { String game = prefs.getString(uname, null);
                final TextView text = (TextView) findViewById(R.id.textView8);
// Now set this value to EditText
                text.setText ( "your previous game scores are \n "+game);}

          //  Bundle i = getIntent().getExtras();
       // String text = i.getString ( "name" );
        final TextView text1 = (TextView) findViewById(R.id.textView7);
// Now set this value to EditText
       text1.setText ( uname);}

    }
    public void gamerules(View view){
        Intent intent=new Intent(SignActivity.this,RulesActivity.class);
        startActivity(intent);
        finish();
    }
}
