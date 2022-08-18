package com.example.myquiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSManager extends AppCompatActivity {
    EditText editTextPhoneNumber;
    EditText editTextMessage;
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsmanager);
        editTextPhoneNumber = findViewById(R.id.num);
        editTextMessage = findViewById(R.id.mess);
        btn = findViewById(R.id.sign);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String number=editTextPhoneNumber.getText().toString();
                String msg=editTextMessage.getText().toString();

                SmsManager smsManager=SmsManager.getDefault();

                Toast.makeText(getApplicationContext(), " " +smsManager,Toast.LENGTH_LONG).show();
                //      Log.i("tag", smsManager.toString());
                smsManager.sendTextMessage(number,null,msg,null,null);
                //  Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();

            }
        });
    }

}