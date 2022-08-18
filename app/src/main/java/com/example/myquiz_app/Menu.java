package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Menu extends AppCompatActivity {
Button btn1 , btn2 , btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn1 = findViewById(R.id.btnquiz);
        btn2 = findViewById(R.id.fuelio);
        btn3=findViewById(R.id.btnsms);
        btn1.setOnClickListener(view -> swith1());
btn2.setOnClickListener(view -> swith ());
        btn3.setOnClickListener(view -> swith2 ());
    }
    public void swith1 (){

        Intent intent = new Intent(getBaseContext(), reg.class);
        startActivity(intent);
    }
    public void swith (){

        Intent intent = new Intent(getBaseContext(), consomation.class);
        startActivity(intent);
    }
    public void swith2 (){

        Intent intent = new Intent(getBaseContext(), SMSManager.class);
        startActivity(intent);
    }
}