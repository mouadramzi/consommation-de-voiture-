package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class quiiz1 extends AppCompatActivity {
    Button next ;
    RadioButton oui;
    RadioButton non ;
    int scr= 0;
    String  test= "mouad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiiz1);
        next= findViewById(R.id.nxt);
        oui = findViewById(R.id.oui);
        non = findViewById(R.id.non);

        next.setOnClickListener(view ->{
            if(oui.isChecked()==true || non.isChecked()==true){
                if(oui.isChecked()==true){
                    scr=scr+20 ;

                }
                else {
                    scr=scr+0 ;
                }

                Intent intent = new Intent(getBaseContext(), quiiz2.class);
                intent.putExtra("score", scr);
                startActivity(intent);
            }


            else
            {

                //objet de type toast
                Toast toast = Toast.makeText(getApplicationContext(),
                        " please choose only one answer",Toast.LENGTH_LONG);
                toast.show();
            }
        } );
    }

}