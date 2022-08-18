package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quiiz4 extends AppCompatActivity {
    Button next4 ;
    RadioButton arr;
    RadioButton cir ;
    TextView txt4 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiiz4);
        next4= findViewById(R.id.nxt4);
        arr = findViewById(R.id.arr);
        cir = findViewById(R.id.cir);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        txt4 = findViewById(R.id.res4);
        txt4.setText(String.valueOf(intValue));
        next4.setOnClickListener(view -> calculi());
    }
    public void calculi(){

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        txt4 = findViewById(R.id.res4);
        txt4.setText(String.valueOf(intValue));

        if (cir.isChecked() == true || arr.isChecked() == true) {
            if (arr.isChecked() == true)
            {
                intValue = intValue + 20;
            } else {
                intValue = intValue + 0;
            }

            Intent intent = new Intent(getBaseContext(), quiiz5.class);
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