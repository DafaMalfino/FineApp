package com.days1.fineapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Polisi extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listRS = new String [] {"Polsek Medan Kota", "Polsek Medan Baru", "Polsek Medan Area", "Polsek Medan Helvetia"};
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
            if (pilihan.equals("Polsek Medan Kota")){
                a = new Intent (this, Polmedankota.class);
            }
            else if (pilihan.equals("Polsek Medan Baru")){
                a = new Intent (this, Polmedanbaru.class);
            }
            else if (pilihan.equals("Polsek Medan Area")){
                a = new Intent (this, Polmedanarea.class);
            }
            else if (pilihan.equals("Polsek Medan Helvetia")){
                a = new Intent (this, Polhelvetia.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
