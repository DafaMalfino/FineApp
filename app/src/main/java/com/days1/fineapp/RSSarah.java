package com.days1.fineapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSSarah extends ListActivity {
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
                String notlp = "Telp: +62614528044";
                a = new Intent (Intent.ACTION_DIAL, Uri.parse(notlp));
            }
            else if (pilihan.equals("SMS Center")){
                String smsText = "M Dafa Malfino/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("SMS: +62614528044"));
                a.putExtra("sms_body",smsText);
            }
            else if (pilihan.equals("Driving Direction")){
                String lokasirs = "google.navigation:q=3.587909040585018, 98.66322446136927";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));
            }
            else if (pilihan.equals("Website")){
                String website = "http://sarahhospital.com/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }
            else if (pilihan.equals("Info di Google")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Umum (RSU) Sarah Medan");
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

