package com.trevorpc.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String,Integer> map = new HashMap<>();
    String name;

    TextView tvDisplay;
    EditText etInput;
    Button btnAnalysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", " Started");
        tvDisplay=findViewById(R.id.tvDisplayAnswer);
        etInput = findViewById(R.id.etInput);
        btnAnalysis = findViewById(R.id.btnAnalysis);

        Log.d("TAG", "After findViewById");


    }


    public void Analysis(View view)
    {
        map.clear();
        name = etInput.getText().toString();

        // move to thread
        BasicThread testThreads = new BasicThread(tvDisplay,etInput);
        testThreads.start();

//
        name = name.toUpperCase();
        name = name.replaceAll(" ","");

        Log.d("TAG", "onCreate: "+name);

        int leaderNum =1;
        String leader = "Error";

        for (int x=0;x<name.length();x++)
        {
            String temp = Character.toString(name.charAt(x));
            if(map.containsKey(temp))
            {
                Integer y =map.get(temp);
                y= y+1;
                map.remove(temp);
                map.put(temp,y);
            }
            else { map.put(temp,1); }

            if(map.get(temp)>leaderNum)
            {
                leaderNum = map.get(temp);
                leader = temp;
            }
        }

        String answer = "The Most Common Letter is..."+leader + " occurring " +leaderNum+ " times.";
        Toast toast = Toast.makeText(getApplicationContext(),
                answer, Toast.LENGTH_SHORT);

        toast.show();
    }
}
