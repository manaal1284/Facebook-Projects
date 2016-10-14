package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

      EditText et1;
      EditText et2;
      TextView tv;
      Button add;
      Button sub;
      Button mul;
      Button div;
      String a,b;
      Integer c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText2);
        tv=(TextView) findViewById(R.id.textView);

        add=(Button) findViewById(R.id.button);
        sub=(Button) findViewById(R.id.button2);
        mul=(Button) findViewById(R.id.button3);
        div=(Button) findViewById(R.id.button4);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = et1.getText().toString();
                String b = et2.getText().toString();

                int first=Integer.parseInt(a);
                int second=Integer.parseInt(b);

                c = first+second;

                tv.setText(Integer.toString(c));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a= et1.getText().toString();
                String b=et2.getText().toString();

                int first=Integer.parseInt(a);
                int second=Integer.parseInt(b);

                c=first-second;

                tv.setText(Integer.toString(c));


            }
        });


        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a= et1.getText().toString();
                String b= et2.getText().toString();

                int first=Integer.parseInt(a);
                int second=Integer.parseInt(b);

                c=first*second;

                tv.setText(Integer.toString(c));

            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a= et1.getText().toString();
                String b= et2.getText().toString();

                int first=Integer.parseInt(a);
                int second=Integer.parseInt(b);

                c=first/second;

                tv.setText(Integer.toString(c));
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
