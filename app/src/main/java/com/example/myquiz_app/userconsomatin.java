package com.example.myquiz_app;

import com.google.type.DateTime;

import java.time.LocalDate;

public class userconsomatin {

    public String nom;
    public int  kilometre;
    public int litre;
    public String dateob ;
    public int litreconsomme  ;
    public userconsomatin(String n , int k , int l , int li  , String d ) {
        this.nom=n  ;
        this.kilometre=k ;
        this.litre= l ;
        this.litreconsomme=li ;
        this.dateob=d ;
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return nom +" : " +"Le "+dateob +newLine +" Distance de "+kilometre+"km"+ newLine +litre+ "  litre s"+newLine+ " Litre consomme "+ litreconsomme

                ;
    }

    public userconsomatin() { }


}
