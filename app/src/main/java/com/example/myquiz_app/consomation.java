package com.example.myquiz_app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.mohammedalaa.seekbar.RangeSeekBarView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Vector;

public class consomation extends AppCompatActivity {
    Button btn ;
    Spinner sp ;
    EditText ed ;
 TextView res , his  ;
 Button cal , reg ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consomation);
        cal = findViewById(R.id.calcul);
        reg = findViewById(R.id.enregister);
        his= findViewById(R.id.hist);
        remplir();
        cal.setOnClickListener(view -> calculi());
        reg.setOnClickListener(view -> enregistrer());
        his.setOnClickListener(view -> swith());
    }
    public void remplir(){
try{
    Vector<String>str=new Vector<String>();
    BufferedReader in = new BufferedReader(new InputStreamReader(getAssets().open("voiture.txt")));

    String line = in.readLine();
    int index = 0;
    while (line != null) {

        str.add(line);
        line = in.readLine();
    }

    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    ArrayAdapter adapter = new ArrayAdapter(this,
            android.R.layout.simple_spinner_item, str);

    spinner.setAdapter(adapter);

}

catch(  FileNotFoundException ex){
    ex.printStackTrace();
    Toast.makeText(getApplicationContext(),
            " file empty",Toast.LENGTH_LONG).show();
} catch (IOException e) {
    e.printStackTrace();
}


    }
    public void calculi(){
        sp = findViewById(R.id.spinner);
ed= findViewById(R.id.editTextNumber);

        RangeSeekBarView rangeSeekbar=findViewById(R.id.range_seekbar);
        int litre= (int) Integer.parseInt(ed.getText().toString());
     int km =    rangeSeekbar.getCurrentValue();
     int c = litre*100/km;
res= findViewById(R.id.results);
res.setText("Votre consomation est "+String.valueOf(c)+"KM/L");

    }

    public void enregistrer(){

        sp = findViewById(R.id.spinner);
        ed= findViewById(R.id.editTextNumber);
        RangeSeekBarView rangeSeekbar=findViewById(R.id.range_seekbar);
        /////////////////////////////////////////////
        int km =    rangeSeekbar.getCurrentValue();
        String nom = sp.getSelectedItem().toString();
        int litre = (int) Integer.parseInt(ed.getText().toString());
        //////////////////////////////////////////////
          DatabaseReference mDatabase;
// ...
        int c = litre*100/km;
        /////////////////
        mDatabase = FirebaseDatabase.getInstance().getReference();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cd = Calendar.getInstance();
        String date = sdf.format(cd.getTime());
        userconsomatin user = new userconsomatin(nom , km ,litre ,  c ,date);
        mDatabase.child("cars").child(nom).setValue(user);
        Toast.makeText(getApplicationContext(),
                " Succes", Toast.LENGTH_LONG);
    }
    public void swith(){
        startActivity(new Intent(consomation.this,historique.class));
    }

}