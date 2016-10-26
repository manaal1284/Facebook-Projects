package com.example.user.facebookservice;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    public static final String LOGIN_URL = "http://services.trainees.baabtra.com/BM-41756Manal/login.php";
    public static final String KEY_USERNAME = "email";
    public static final String KEY_PASSWORD = "password";

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;


    private String email;
    private String Password;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.activity_tab);
        View view=getSupportActionBar().getCustomView();

        editTextUsername = (EditText) findViewById(R.id.editText);
        editTextPassword = (EditText) findViewById(R.id.editText2);
        buttonLogin = (Button) findViewById(R.id.button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

    }

    public void userLogin() {
        email = editTextUsername.getText().toString();
        Password = editTextPassword.getText().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {


                        if (response.contains("200") && response.contains("Success")) {
                            System.out.println(response);
                            openProfile();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();

                        }
                    }
                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, volleyError.toString(), LENGTH_LONG).show();
                    }
                }) {

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, email);
                map.put(KEY_PASSWORD, Password);
                return map;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }


    private void openProfile() {
        Intent intent = new Intent(MainActivity.this, home.class);
        startActivity(intent);
    }
}

