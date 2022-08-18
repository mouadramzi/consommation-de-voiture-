package com.example.myquiz_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
///declaration des attributs
    TextView register;
    Button login ;
    EditText etemail ;
    EditText mypass ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/// lier les qttributs avec les layouts
        register= findViewById(R.id.regist);
        login = findViewById(R.id.sign);
        etemail = findViewById(R.id.email);
        mypass = findViewById(R.id.Password);

        login.setOnClickListener(view -> {
            String entered_email = etemail.getText().toString().trim();
            String entered_password  = mypass.getText().toString().trim();

            FirebaseAuth auth = null ;
            auth= FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(entered_email,entered_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(MainActivity.this,quiiz1.class));
                    }
                    else {
                        finish();
                        startActivity(getIntent());

                    }
                }
            });
        });

    }
    public void swith(){
        startActivity(new Intent(MainActivity.this,reg.class));
    }

}