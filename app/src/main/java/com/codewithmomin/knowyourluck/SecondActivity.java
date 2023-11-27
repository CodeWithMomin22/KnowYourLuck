package com.codewithmomin.knowyourluck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    Button shareBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text1=findViewById(R.id.textview2);
        text2=findViewById(R.id.textview3);
        shareBtn=findViewById(R.id.Btn2);
        //receiving data from Main activity
        Intent i=getIntent();
        String userName=i.getStringExtra("name");
        //generating Random Numbers
        int random_num=generateRandomNumber();
        //storing random number into textview
        text2.setText(""+random_num);


        //we are sharing the data to other applications
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,random_num);
            }
        });

    }
    //random number function
    public int generateRandomNumber()
    {
        Random random=new Random();
        int upper_limit=100;
        int randomNumberGenrated=random.nextInt(upper_limit);
        return randomNumberGenrated;
    }

    // this is the function to share the data among other applications
    public void shareData(String username,int randomNum){
        Intent i=new Intent(Intent.ACTION_SEND);

        i.setType("text/plain");
        // additional information purposes
        i.putExtra(Intent.EXTRA_SUBJECT,username+" "+"Got Lucky Today!");
        i.putExtra(Intent.EXTRA_TEXT,"His Lucky Number is :"+randomNum);

        startActivity(Intent.createChooser(i,"choose a platefrom"));
    }
}