package com.codewithmomin.knowyourluck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;

    EditText eText;
    Button myBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.textview1);
        eText=findViewById(R.id.editText1);
        myBtn1=findViewById(R.id.Btn1);
        myBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // taking the user input in variable userName
                String userName=eText.getText().toString();

                // passing the user input to second Activity

                Intent i=new Intent(getApplicationContext(),SecondActivity.class);
                i.putExtra("name",userName);
                startActivity(i);

            }
        });
    }
}