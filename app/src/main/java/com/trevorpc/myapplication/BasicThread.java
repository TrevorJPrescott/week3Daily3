package com.trevorpc.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class BasicThread extends Thread
{

    Handler threadHandler = new Handler(Looper.getMainLooper());

    HashMap<String,Integer> map = new HashMap<>();
    String name = "Adam the Nomad";
    TextView tvDisplay;
    EditText etInput;


    public BasicThread(TextView tvDisplay,EditText etInput) {
        this.etInput = etInput;
        this.tvDisplay = tvDisplay;
    }

    @Override
    public void run()
    {
        super.run();
        Analysis();




    }




    public void Analysis()
    {
        int leaderNum =1;
        String leader = "Error";

        map.clear();

        name = etInput.getText().toString();
        name = name.toUpperCase();
        name = name.replaceAll(" ","");

        Log.d("TAG", "onCreate: "+name);



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
            //somehow return leader and leaderNum



//        String answer = "The Most Common Letter is..."+leader + " occurring " +leaderNum+ " times.";
//        Toast toast = Toast.makeText(MainActivity, answer, Toast.LENGTH_SHORT);
//
//        toast.show();
    }
}
