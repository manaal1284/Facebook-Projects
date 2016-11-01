package com.example.user.practicaltest;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String KEYWORD_USERNAME = "email";
    public static String KEYWORD_PASSWORD = "password";

    private EditText et1;
    private EditText et2;
    private Button b1;
    private Button b2;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        mydb = new DatabaseHelper(this);
    }

    public void setSignup(View view) {
        startActivity(new Intent(this, signup.class));
    }

    public void setlogin(View view) {
        String stored = mydb.getEntry(mail);
        System.out.println(stored);
        if (password.equals(stored)) {

            startActivity(new Intent(MainActivity.this, home.class));
        } else {
            Toast.makeText(getApplicationContext(), "Email or password does not match", Toast.LENGTH_LONG).show();

            startActivity(new Intent(this, signup.class));
        }
    }
}
