package com.example.user.practicaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    private EditText eta;
    private EditText etb;
    private EditText etc;
    private EditText etd;
    private EditText ete;
    private EditText etf;
    private Button bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        eta = (EditText) findViewById(R.id.editText3);
        etb = (EditText) findViewById(R.id.editText4);
        etc = (EditText) findViewById(R.id.editText5);
        etd = (EditText) findViewById(R.id.editText6);
        ete = (EditText) findViewById(R.id.editText7);
        etf = (EditText) findViewById(R.id.editText8);
        bs = (Button) findViewById(R.id.button3);
    }

    public void setsignup (View view)
    {
        startActivity(new Intent(this,home.class));
    }
}
