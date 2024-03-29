package com.example.d7om0.alghamdia2_CardQuizGame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.d7om0.alghamdia2_login_register.R;

public class MainActivity extends AppCompatActivity {
    String username; public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(MainActivity.this);
        }
        builder.setTitle("Login/Register")
                .setMessage("Are you sure you want to Login/Register")
                .setPositiveButton("Register", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent= new Intent(MainActivity.this,Register.class);
                        startActivityForResult(intent, 1);

                        // continue with delete
                    }
                })
                .setNegativeButton("Login", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                        String restoredText = prefs.getString("name", null);
                        if (restoredText != null) {
                            String uname = prefs.getString("name", "No name defined");//"No name defined" is the default value.
                            String idName = prefs.getString("idName", "No name defined");
                           // Toast.makeText(MainActivity.this, uname +"" +idName, Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(MainActivity.this,SignActivity.class);
                            startActivity(intent);
                            //0 is the default value.
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Register first", Toast.LENGTH_SHORT).show();
                            // do nothing
                            finish();
                        }

                    }

                })
                .setIcon(R.drawable.login)
                .show();
    }

    //move to login screen
   /* public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                 username = data.getStringExtra("name");
                Toast.makeText(MainActivity.this,username, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(MainActivity.this);
                }
                builder.setTitle("Login/Register")
                        .setMessage("Are you sure you want to Login/Register")
                        .setPositiveButton("Register", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent= new Intent(MainActivity.this,Register.class);
                                startActivityForResult(intent, 1);

                                // continue with delete
                            }
                        })
                        .setNegativeButton("Login", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent= new Intent(MainActivity.this,SignActivity.class);
                                intent.putExtra("name",username);
                                startActivity(intent);
                            }

                        })
                        .setIcon(R.drawable.login)
                        .show();

            }
        }
    }*/

}
