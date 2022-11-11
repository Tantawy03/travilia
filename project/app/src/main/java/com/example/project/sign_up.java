package com.example.project;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {

    EditText password, email,firstname,birthdate,lastname,passport,conirmpass,phone,nationality;
    Button create;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        email =  findViewById(R.id.email);
        password =  findViewById(R.id.password);
        firstname =  findViewById(R.id.first_name);
        lastname =  findViewById(R.id.last_name);
        passport =  findViewById(R.id.passport_number);
        conirmpass =  findViewById(R.id.confirm_password);
        phone =  findViewById(R.id.phone);
        nationality =  findViewById(R.id.nationality);
        birthdate =  findViewById(R.id.birth_date);
        create =  findViewById(R.id.next);
        DB = new DBHelper(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String pass = password.getText().toString();
                String Firstname= firstname.getText().toString();
                String Lastname= lastname.getText().toString();
                String Passport= passport.getText().toString();
                String Conirmpass= conirmpass.getText().toString();
                String Phone= phone.getText().toString();
                String Nationality= nationality.getText().toString();
                String Birthdate= birthdate.getText().toString();
                if(Email.equals("")||pass.equals("")||Firstname.equals("")||Lastname.equals("")||Passport.equals("")||Conirmpass.equals("")||Phone.equals("")||Nationality.equals("")||Birthdate.equals("")){
                    Toast.makeText(sign_up.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(Conirmpass)){
                    Boolean checkuser = DB.checkemail(Email);
                        Toast.makeText(sign_up.this, "ckech email ", Toast.LENGTH_SHORT).show();

                        if(checkuser== false){
                        Toast.makeText(sign_up.this, "hello world", Toast.LENGTH_SHORT).show();

                        Boolean insert = DB.insertData(Email, pass,Firstname,Lastname,Passport,Nationality,Birthdate,Phone,Conirmpass);
                        if(insert == true){
                            Toast.makeText(sign_up.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(sign_up.this, MainActivity3.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(sign_up.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(sign_up.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }

                }else{
                        Toast.makeText(sign_up.this, "password doesnt match", Toast.LENGTH_SHORT).show();
                    }
                    }
                }
        });
    }
}