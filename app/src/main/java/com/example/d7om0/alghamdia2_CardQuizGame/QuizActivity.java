package com.example.d7om0.alghamdia2_CardQuizGame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d7om0.alghamdia2_login_register.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuizActivity extends AppCompatActivity {
    public int i=0;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    String game="scores: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizscreen);
        final TextView _tv = (TextView) findViewById( R.id.timer );
        new CountDownTimer(1*60000, 1000) {

            public void onTick(long millisUntilFinished) {
                _tv.setText( new SimpleDateFormat("mm:ss:SS").format(new Date( millisUntilFinished)));
            }

            public void onFinish() {
                _tv.setText("Time Finish!");
                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String uname = prefs.getString("name", "No name defined");//"No name defined" is the default value.

                String restoredgame = prefs.getString(uname, null);
                if(restoredgame!=null)
                {  game = prefs.getString(uname, null);}
                String totalscore=game+ Integer.toString(i)+" . \n";
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(uname, totalscore);
                editor.apply();
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(QuizActivity.this);
                }
                builder.setTitle("Result Display")
                        .setMessage("Your total score is "+ i)
                        .setPositiveButton("Click Ok to save score", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {



finish();

                                System.exit(0);                      }


                                // continue with delete

                        })
                        .setIcon(R.drawable.login)
                        .show();
            }
        }.start();
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(QuizActivity.this,"Quiz time finished",Toast.LENGTH_SHORT).show();
            }
        }, 60000);*/
    }
        public void confirm1(View view){
            final EditText text = (EditText)findViewById(R.id.editText6);
            final Button button = (Button) findViewById(R.id.button4
            );
            final String answer1=text.getText().toString();
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(QuizActivity.this);
            }
            builder.setTitle("Confirm")
                    .setMessage("Are you sure you want to Confirm this answer")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            button.setEnabled(false);
                            if(answer1.matches("25")){
                                i=i+1;
                               /* SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putInt("gamescore", i);
                                editor.apply();*/

                                 Toast.makeText(QuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();



                            }
                            else
                            { Toast.makeText(QuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                            }
                            // continue with delete
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {


                        }

                    })
                    .setIcon(R.drawable.login)
                    .show();
        }
    public void confirm2(View view){
        final RadioButton rad = (RadioButton) findViewById(R.id.radioButton);
      //  final String answer1=text.getText().toString();
        final Button button1 = (Button) findViewById(R.id.button5
        );
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(QuizActivity.this);
        }
        builder.setTitle("Confirm")
                .setMessage("Are you sure you want to Confirm this answer")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        button1.setEnabled(false);
                        if(rad.isChecked()==true){
                            i=i+1;
                            Toast.makeText(QuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                          /*  SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt("gamescore", i);
                            editor.apply();*/



                        }
                        else
                        { Toast.makeText(QuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        }
                        // continue with delete
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                    }

                })
                .setIcon(R.drawable.login)
                .show();
    }
    public void confirm3(View view){
        final EditText text = (EditText)findViewById(R.id.editText7);
        final Button button2 = (Button) findViewById(R.id.button6
        );
        final String answer1=text.getText().toString();
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(QuizActivity.this);
        }
        builder.setTitle("Confirm")
                .setMessage("Are you sure you want to Confirm this answer")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        button2.setEnabled(false);
                        if(answer1.matches("int")){
                            i=i+1;
                            Toast.makeText(QuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        /*    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt("gamescore", i);
                            editor.apply();*/


                        }
                        else
                        { Toast.makeText(QuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        }
                        // continue with delete
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                    }

                })
                .setIcon(R.drawable.login)
                .show();
    }
    public void confirm4(View view){
        final CheckBox check = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox check1 = (CheckBox) findViewById(R.id.checkBox4);
        final Button button = (Button) findViewById(R.id.button7
        );
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(QuizActivity.this);
        }
        builder.setTitle("Confirm")
                .setMessage("Are you sure you want to Confirm this answer")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        button.setEnabled(false);
                        if(check.isChecked()==true&&check1.isChecked()==true){
                            i=i+1;
                            Toast.makeText(QuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                           /* SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt("gamescore", i);
                            editor.apply();*/


                        }
                        else
                        { Toast.makeText(QuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        }
                        // continue with delete
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                    }

                })
                .setIcon(R.drawable.login)
                .show();
    }
    public void confirm5(View view){
        final EditText text = (EditText)findViewById(R.id.editText9);
        final String answer1=text.getText().toString();
        final Button button = (Button) findViewById(R.id.button8
        );
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(QuizActivity.this);
        }
        builder.setTitle("Confirm")
                .setMessage("Are you sure you want to Confirm this answer")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        button.setEnabled(false);
                        if(answer1.matches("120")){
                            i=i+1;
                            Toast.makeText(QuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        /*    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt("gamescore", i);
                            editor.apply();*/


                        }
                        else
                        { Toast.makeText(QuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        }
                        // continue with delete
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                    }

                })
                .setIcon(R.drawable.login)
                .show();
    }
public void result(View view){

    SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
    String uname = prefs.getString("name", "No name defined");//"No name defined" is the default value.

    String restoredgame = prefs.getString(uname, null);
    if(restoredgame!=null)
    {  game = prefs.getString(uname, null);}
       String totalscore=game+ Integer.toString(i)+". \n";
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
    editor.putString(uname, totalscore);
    editor.apply();
    AlertDialog.Builder builder;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
    } else {
        builder = new AlertDialog.Builder(QuizActivity.this);
    }
    builder.setTitle("Result Display")
            .setMessage("Your total score is "+ i)
            .setPositiveButton("save score", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {finish();
                    System.exit(0);}})
            .setIcon(R.drawable.login)
            .show();


}

        }

