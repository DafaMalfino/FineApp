package com.days1.fineapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SupTiara extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listRS = new String [] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info di Google", "exit"};
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
            if (pilihan.equals("Call Center")){
                String notlp = "Telp: +62614516000";
                a = new Intent (Intent.ACTION_DIAL, Uri.parse(notlp));
            }
            else if (pilihan.equals("SMS Center")){
                String smsText = "M Dafa Malfino/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("SMS: +62614516000"));
                a.putExtra("sms_body",smsText);
            }
            else if (pilihan.equals("Driving Direction")){
                String lokasirs = "google.navigation:q=3.581233215412909, 98.6761049";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));
            }
            else if (pilihan.equals("Website")){
                String website = "https://www.brastagi.net/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }
            else if (pilihan.equals("Info di Google")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Brastagi Supermarket Tiara");
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

