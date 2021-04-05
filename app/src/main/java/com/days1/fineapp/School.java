package com.days1.fineapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class School extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listRS = new String [] {"SMA 5 Negeri Pekanbaru", "SMP Negeri 4 Pekanbaru", "Sekolah Dasar Negeri 15 Pekanbaru"};
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
            if (pilihan.equals("SMA 5 Negeri Pekanbaru")){
                a = new Intent (this, SMAN.class);
            }
            else if (pilihan.equals("SMP Negeri 4 Pekanbaru")){
                a = new Intent (this, SMPN.class);
            }
            else if (pilihan.equals("Sekolah Dasar Negeri 15 Pekanbaru")){
                a = new Intent (this, SDN.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
