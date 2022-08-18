package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quiiz5 extends AppCompatActivity {
    Button next ;
    RadioButton oui;
    RadioButton non ;
    TextView txt5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiiz5);
        next= findViewById(R.id.nxt5);
        oui = findViewById(R.id.oui);
        non = findViewById(R.id.non);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        txt5 = findViewById(R.id.res5);
        txt5.setText(String.valueOf(intValue));
        next.setOnClickListener(view -> calculi());
    }
    public void calculi(){

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        txt5 = findViewById(R.id.res5);
        txt5.setText(String.valueOf(intValue));

        if (oui.isChecked()  || non.isChecked()  ) {
            if (oui.isChecked()  )
            {
                intValue = intValue + 20;
            } else {
                intValue = intValue  ;
            }

            Intent intent = new Intent(getBaseContext(), score.class);
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