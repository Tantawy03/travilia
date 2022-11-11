package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends AppCompatActivity {
    EditText email, password;
    Button btnlogin,b1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        b1 = findViewById(R.id.signup);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(sign_in.this, sign_up.class);
                startActivity(i);
            }
        });
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.signin);
        DB = new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email1 = email.getText().toString();
                String pass = password.getText().toString();

                if(email1.equals("")||pass.equals(""))
                    Toast.makeText(sign_in.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkemailpassword(email1, pass);
                    if(checkuserpass==true){
                        Toast.makeText(sign_in.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(sign_in.this, MainActivity3.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(sign_in.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}