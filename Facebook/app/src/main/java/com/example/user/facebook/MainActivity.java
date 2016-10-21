package com.example.user.facebook;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.nsd.NsdManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStructure;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    public static final String KEY_USERNAME ="email";
    public static final String KEY_PASSWORD ="password";

    private EditText etUsername;
    private EditText etPassword;
    private Button bLogin,btreg;
    DatabaseHelper mydb;

    private String email;
    private String password;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.activity_action);
        View view=getSupportActionBar().getCustomView();

        mydb=new DatabaseHelper(this);


        etUsername = (EditText) findViewById(R.id.editText);
        etPassword = (EditText) findViewById(R.id.editText2);
        bLogin = (Button) findViewById(R.id.button);
        btreg = (Button) findViewById(R.id.button2);

         email=etUsername.getText().toString();
         password=etPassword.getText().toString();

        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean inserted = mydb.insertData(email,password);
                if (inserted == true) {
                    Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });





          bLogin.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {


                   String stored=mydb.getEntry(email);
                   System.out.println(stored);
                   if (password.equals(stored))
                   {
                       Intent intent=new Intent(MainActivity.this,profile.class);
                       startActivity(intent);

                   }
                   else
                   {
                       Toast.makeText(getApplicationContext(),"Email or password does not match",Toast.LENGTH_LONG).show();
//
                   }
               }
           });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
