package com.example.helloworldapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button activity1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        activity1Button = (Button) findViewById(R.id.activity1_button1);
        activity1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}