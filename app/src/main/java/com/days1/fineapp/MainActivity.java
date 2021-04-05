package com.days1.fineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_menu);
    }
    public void clickRS (View view ) {
        Intent i = new Intent(this, RS.class);
    }
    public void clickPolis (View view ) {
        Intent i = new Intent(this, Polisi.class);
    }
    public void clickSuper (View view ) {
        Intent i = new Intent(this, Supermarket.class);
    }
    public void clickSchool (View view ) {
        Intent i = new Intent(this, School.class);
    }
}