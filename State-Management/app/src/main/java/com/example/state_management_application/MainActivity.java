package com.example.state_management_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView counterText;
    private Button incrementCount;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        Log.i("Log_name","on create method");

        counterText = (TextView) findViewById(R.id.counter);
        incrementCount = (Button) findViewById(R.id.increment);
        incrementCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                counterText.setText("Counter : " + counter);

                Log.i("Log_name","counter "+ counter);
            }
        });

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt("count");
            counterText.setText("Counter : " + counter);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("count",counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("count");
        counterText.setText("Counter : " + counter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log_name","on start method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log_name","on resume method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Log_name","on Pause method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log_name","on stop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Log_name","on destroy method");
    }
}