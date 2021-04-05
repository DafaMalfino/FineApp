package com.days1.fineapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Supermarket extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listRS = new String [] {"Brastagi Supermarket Tiara", "Brastagi Supermarket Rantauprapat",
                "Maju Bersama Supermarket - Medan Mall", "Brastagi Supermarket Manhattan"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listRS));
    }

    protected void onListItemClick (ListView i, View v, int position, long id){
        super.onListItemClick(i, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan){
        try {
            Intent a = null;
            if (pilihan.equals("Brastagi Supermarket Tiara")){
                a = new Intent (this, SupTiara.class);
            }
            else if (pilihan.equals("Brastagi Supermarket Rantauprapat")){
                a = new Intent (this, SupRantau.class);
            }
            else if (pilihan.equals("Maju Bersama Supermarket - Medan Mall")){
                a = new Intent (this, Supmaju.class);
            }
            else if (pilihan.equals("Brastagi Supermarket Manhattan")){
                a = new Intent (this, SupMan.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}