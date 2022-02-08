package com.example.assi1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    int yes_count=0;
    String restore_message;
    String tag="log_tag";
   // public TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       Log.i(tag,"State of activity MainActivity2.java changed to OnCreate");
//        Log.i(tag,"State of activity MainActivity2.java changed from OnCreate to OnStart");
//        Log.i(tag,"State of activity MainActivity2.java changed from OnStart to OnResume");
        Toast.makeText(this, "State of activity MainActivity2.java changed to OnCreate", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity2.java changed from OnCreate to OnStart", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity2.java changed from OnStart to OnResume", Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        int i ;
        for(i=1 ; i<=6 ; i++) {
            String to_get = "ans"+Integer.toString(i);
            String ans_got=intent.getStringExtra(to_get);
            if(ans_got.equals("yes"))
                yes_count=yes_count+1;
            int resID = getResources().getIdentifier("ans"+i+"_view", "id", getPackageName());
            TextView answere = (TextView) findViewById(resID);
            answere.setText(ans_got);

            if(savedInstanceState!=null) {
                String message_restored = savedInstanceState.getString("restore_msg");
                TextView msg = (TextView) findViewById(R.id.message);
                msg.setText(message_restored);
                restore_message=message_restored;
            }
        }

    }

    public void show_result(View v) {
        Toast.makeText(this, "Showing Result!", Toast.LENGTH_SHORT).show();
        TextView msg = (TextView) findViewById(R.id.message);
        Intent intent = getIntent();
        String user = intent.getStringExtra("user_name");
        String message;
        if(yes_count >= 3) {
            message = "Hi "+user+" ! Please get yourself tested for Covid-19";
            restore_message=message;
            msg.setText(message);
        }
        else {
            message = "Congratulations "+user+" ! No need to get tested for Covid-19";
            restore_message=message;
            msg.setText(message);
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        Log.i(tag,"State of activity MainActivity2.java changed from OnResume to OnPause");
//        Log.i(tag,"State of activity MainActivity2.java changed from OnPause to OnStop");
//        Log.i(tag,"State of activity MainActivity2.java changed from OnStop to OnDestroy");
//        Toast.makeText(this, "State of activity MainActivity2.java changed from OnResume to OnPause", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity2.java changed from OnPause to OnStop", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity2.java changed from OnStop to OnDestroy", Toast.LENGTH_SHORT).show();
        outState.putString("restore_msg" , restore_message);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag,"State of activity MainActivity2.java changed from OnCreate to OnStart");
        Toast.makeText(this, "State of activity MainActivity2.java changed from OnCreate to OnStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag,"State of activity MainActivity2.java changed from OnStart to OnResume");
        Toast.makeText(this, "State of activity MainActivity2.java changed from OnStart to OnResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"State of activity MainActivity2.java changed from OnResume to OnPause");
        Toast.makeText(this, "State of activity MainActivity2.java changed from OnResume to OnPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"State of activity MainActivity2.java changed from OnPause to OnStop");
        Toast.makeText(this, "State of activity MainActivity2.java changed from OnPause to OnStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"State of activity MainActivity2.java changed from OnStop to OnDestroy");
        Toast.makeText(this, "State of activity MainActivity2.java changed from OnStop to OnDestroy", Toast.LENGTH_SHORT).show();

    }


}