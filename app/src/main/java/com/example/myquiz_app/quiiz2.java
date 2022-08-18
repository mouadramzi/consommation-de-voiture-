package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quiiz2 extends AppCompatActivity {
    Button next2 ;
    RadioButton dr;
    RadioButton gau ;
    TextView txt2 ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiiz2);



        next2= findViewById(R.id.nxt2);
        dr = findViewById(R.id.droite);
        gau = findViewById(R.id.gauche);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        txt2 = findViewById(R.id.res2);
        txt2.setText(String.valueOf(intValue));
        next2.setOnClickListener(view -> calculi());
     }
        public void calculi(){

            Intent mIntent = getIntent();
            int intValue = mIntent.getIntExtra("score", 0);
            txt2 = findViewById(R.id.res2);
            txt2.setText(String.valueOf(intValue));
            if (dr.isChecked()  || gau.isChecked() ) {
                if (dr.isChecked() )
                {
                    intValue = intValue + 20;
                } else {
                    intValue=intValue+0 ;
                }

                Intent intent = new Intent(getBaseContext(), quiiz3.class);
                intent.putExtra("score", intValue);
                startActivity(intent);
            }
            else {

                //objet de type toast
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        " please choose only one answer", Toast.LENGTH_LONG);
                toast1.show();

            }
        }

    }

