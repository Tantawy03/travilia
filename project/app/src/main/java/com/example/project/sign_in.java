package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        Button b1 = (Button) findViewById(R.id.signup);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(sign_in.this, sign_up.class);
                startActivity(i);
            }
        });
        Button b2 = findViewById(R.id.signin);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(sign_in.this,MainActivity3.class);
                startActivity(i);
            }
        });

    }
}