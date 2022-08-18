package com.example.myquiz_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class reg extends AppCompatActivity {

    Button reg ;
    EditText email ;
    EditText pass ;
    EditText name ;
    EditText confpass ;
    TextView sign  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        reg= findViewById(R.id.register);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.Password);
        name = findViewById(R.id.name);
        confpass = findViewById(R.id.conPassword);
sign = findViewById(R.id.signin1);
        String conpass2=confpass.getText().toString();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_registration();

                startActivity(new Intent(reg.this,MainActivity.class))
                ;
            }
        });
        sign.setOnClickListener(view -> swith());
    }
    public void swith(){
        startActivity(new Intent(reg.this,MainActivity.class));
    }
        private void user_registration() {
            Intent switchActivityIntent = new Intent(this, reg.class);
            startActivity(switchActivityIntent);
            //getting email and password from edit texts and save them in a string variables
            String entered_email = email.getText().toString().trim();
            String entered_password  = pass.getText().toString().trim();

            //if entered_email and entered_password are empty then prompt user to enter email and pass by showing toast message
            if(TextUtils.isEmpty(entered_email)){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(entered_password)){
                Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
                return;
            }

            //if the email and password are not empty
            //displaying a progress dialog
FirebaseAuth auth = null ;
            auth= FirebaseAuth.getInstance();
            //creating a new user
            auth.createUserWithEmailAndPassword(entered_email,entered_password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"SUCCESSUL",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(reg.this,MainActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"not successful",Toast.LENGTH_LONG).show();
                    }
                }
            });
        };
        }

