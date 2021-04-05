package com.days1.fineapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class RS extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listRS = new String [] {"Rumah Sakit Umum (RSU) Sarah Medan", "RS Advent Medan", "Rumah Sakit Umum Mitra Sejati", "Rumah Sakit Umum Martha Friska Multatuli"};
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
            if (pilihan.equals("Rumah Sakit Umum (RSU) Sarah Medan")){
                a = new Intent (this, RSSarah.class);
            }
            else if (pilihan.equals("RS Advent Medan")){
                a = new Intent (this, RSAdvent.class);
            }
            else if (pilihan.equals("Rumah Sakit Umum Mitra Sejati")){
                a = new Intent (this, RSMitra.class);
            }
            else if (pilihan.equals("Rumah Sakit Umum Martha Friska Multatuli")){
                a = new Intent (this, RSMartha.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
