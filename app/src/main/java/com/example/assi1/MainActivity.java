package com.example.assi1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int question_number = 1;

    String restore_message;
    String tag="log_tag";
    String []ans = new String[6];
    Button sub_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sub_btn = (Button) findViewById(R.id.submit_button);
        if(question_number<6)
        sub_btn.setEnabled(false);
        else
            sub_btn.setEnabled(true);

        Log.i(tag,"State of activity MainActivity.java changed to OnCreate");
//        Log.i(tag,"State of activity MainActivity.java changed from OnCreate to OnStart");
//        Log.i(tag,"State of activity MainActivity.java changed from OnStart to OnResume");
        Toast.makeText(this, "State of activity MainActivity.java changed to OnCreate", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnCreate to OnStart", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnStart to OnResume", Toast.LENGTH_SHORT).show();
        TextView question = (TextView) findViewById(R.id.textView);

        Questions que = new Questions(1);
        String question_to_set = que.get_question();
        question.setText(question_to_set);
        //question.setText("1)Do you have fever?");
        if(savedInstanceState!=null) {
            String message_restored = savedInstanceState.getString("restore_msg");
            question_number = savedInstanceState.getInt("restore_question_num");
            String [] ans1 = new String[6];
            ans1= (String[]) savedInstanceState.getSerializable("my_array");
            ans=ans1;
            for(int i=0 ; i<6 ; i++){
                String ind = Integer.toString(i);
                String tag1 = "ans"+ind;
                Log.d(tag1 , String.valueOf(ans[i]));
            }

            if(question_number<6)
                sub_btn.setEnabled(false);
            else
                sub_btn.setEnabled(true);
            TextView msg = (TextView) findViewById(R.id.textView);
            msg.setText(message_restored);
            restore_message=message_restored;
        }

    }
    public void click_next(View v) {
        question_number = question_number+1;
        if(question_number>=6)
            sub_btn.setEnabled(true);
        else
            sub_btn.setEnabled(false);

        if(question_number>6) {
            Toast.makeText(this, "No more questions available! Please submit!", Toast.LENGTH_SHORT).show();
        }
        TextView question = (TextView) findViewById(R.id.textView);
//        if(question_number==2)
//            question.setText("2)Do you have sore throat?");
//        else if(question_number==3)
//            question.setText("3)Do you have running nose?");
//        else if(question_number==4)
//            question.setText("4)Is there any loss of taste or smell?");
//        else if(question_number==5)
//            question.setText("5)Are you having Aches and Pains?");
//        else{
//            question.setText("6)Is there any difficulty is breathing?");
//
//        }

        Questions que = new Questions(question_number);
        String question_to_set = que.get_question();
        question.setText(question_to_set);

    }
    public void clear_form(View v) {
        Toast.makeText(this, "Form cleared", Toast.LENGTH_SHORT).show();
        question_number=1;
        EditText name = (EditText) findViewById(R.id.editTextPersonName);
        name.setText("");
        ans = new String[6];
        sub_btn.setEnabled(false);

        TextView question = (TextView) findViewById(R.id.textView);
        Questions que = new Questions(1);
        String question_to_set = que.get_question();
        question.setText(question_to_set);
       // question.setText("1)Do you have fever?");
    }

    public void option_selected(View v) {
        String str;
        String key_string,temp;
        int q_number;
        int ans_number;

        if(v.getId()==R.id.yes_button){
            str = "yes selected";
            ans[question_number-1] = "yes";
//            ans_number = question_number;
//            temp = Integer.toString(ans_number);
//            key_string = "ans"+temp;
//            intent.putExtra(key_string,"yes");

        }

        else {
            str = "No selected";
            ans[question_number-1] = "no";
//            ans_number = question_number;
//            temp = Integer.toString(ans_number);
//            key_string = "ans"+temp;
//            intent.putExtra(key_string,"no");
        }

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }
    public void submitted(View v) {
        Toast.makeText(this, "Form is submitted!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this , MainActivity2.class);

        int i;
        for(i=0 ; i<6 ;i++) {
            if(ans[i]==null) {
                ans[i]="NA";
            }
        }
        for(i=0 ; i<6 ; i++) {
            String ans_number = Integer.toString(i+1);
            String key_string="ans"+ans_number;
            intent.putExtra(key_string,ans[i]);
        }

//        Log.i(tag,"State of activity MainActivity.java changed from OnResume to OnPause");
//        Log.i(tag,"State of activity MainActivity.java changed from OnPause to OnStop");
//        Log.i(tag,"State of activity MainActivity.java changed from OnStop to OnDestroy");
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnResume to OnPause", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnPause to OnStop", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnStop to OnDestroy", Toast.LENGTH_SHORT).show();
        TextView name = (TextView) findViewById(R.id.editTextPersonName);
        String name_of_person = name.getText().toString();
        intent.putExtra("user_name",name_of_person);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView question = findViewById(R.id.textView);
        restore_message = question.getText().toString();
        outState.putString("restore_msg" , restore_message);
        outState.putInt("restore_question_num" , question_number);
        outState.putSerializable("my_array" , ans);
//        Log.i(tag,"State of activity MainActivity.java changed from OnResume to OnPause");
//        Log.i(tag,"State of activity MainActivity.java changed from OnPause to OnStop");
//        Log.i(tag,"State of activity MainActivity.java changed from OnStop to OnDestroy");
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnResume to OnPause", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnPause to OnStop", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "State of activity MainActivity.java changed from OnStop to OnDestroy", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag,"State of activity MainActivity.java changed from OnCreate to OnStart");
        Toast.makeText(this, "State of activity MainActivity.java changed from OnCreate to OnStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag,"State of activity MainActivity.java changed from OnStart to OnResume");
        Toast.makeText(this, "State of activity MainActivity.java changed from OnStart to OnResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"State of activity MainActivity.java changed from OnResume to OnPause");
        Toast.makeText(this, "State of activity MainActivity.java changed from OnResume to OnPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"State of activity MainActivity.java changed from OnPause to OnStop");
        Toast.makeText(this, "State of activity MainActivity.java changed from OnPause to OnStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"State of activity MainActivity.java changed from OnStop to OnDestroy");
        Toast.makeText(this, "State of activity MainActivity.java changed from OnStop to OnDestroy", Toast.LENGTH_SHORT).show();

    }
}