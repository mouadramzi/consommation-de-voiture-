package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quiiz3 extends AppCompatActivity {
    Button next3 ;
    RadioButton ui;
    RadioButton nn ;
    TextView txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiiz3);
        next3= findViewById(R.id.nxt3);
        ui = findViewById(R.id.oui);
        nn = findViewById(R.id.non);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        txt3= findViewById(R.id.res3);
        txt3.setText(String.valueOf(intValue));
        next3.setOnClickListener(view -> calculi());
    }
    public void calculi(){

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        txt3= findViewById(R.id.res3);
        txt3.setText(String.valueOf(intValue));

        if (ui.isChecked() == true || nn.isChecked() == true) {
            if (ui.isChecked() == true)
            {
                intValue = intValue + 20;
            } else {
                intValue = intValue + 0;
            }

            Intent intent = new Intent(getBaseContext(), quiiz4.class);
            intent.putExtra("score", intValue);
            startActivity(intent);
        }
        else {

            //objet de type toast
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    " please choose only one answer", Toast.LENGTH_LONG);
            toast1.show();

        }
    };
}