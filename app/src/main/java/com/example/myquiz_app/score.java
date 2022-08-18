package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class score extends AppCompatActivity {
    Button out ;
    Button tryy ;
TextView txt6 ;
Button signout ;
Button tryagain ;
      FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent mIntent = getIntent();
       int intValue7 = mIntent.getIntExtra("score", 0);
        txt6= findViewById(R.id.res6);
      txt6.setText(String.valueOf(intValue7));
signout= findViewById(R.id.out);
    tryagain= findViewById(R.id.tryy);
        out= findViewById(R.id.out);
        tryy= findViewById(R.id.tryy);
        CircularProgressIndicator circularProgress = findViewById(R.id.circular_progress);

// you can set max and current progress values individually

        circularProgress.setProgress(intValue7, 100);
        signout.setOnClickListener(view -> signout1());
        tryagain.setOnClickListener(view -> try1());
    }
    public void signout1(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(score.this,MainActivity.class));
    }
    public void try1(){
        startActivity(new Intent(score.this,quiiz1.class));
    }


}