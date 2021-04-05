package com.days1.fineapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SMAN extends ListActivity {
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
                String notlp = "Telp: +6276132075";
                a = new Intent (Intent.ACTION_DIAL, Uri.parse(notlp));
            }
            else if (pilihan.equals("SMS Center")){
                String smsText = "M Dafa Malfino/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("SMS: +6276132075"));
                a.putExtra("sms_body",smsText);
            }
            else if (pilihan.equals("Driving Direction")){
                String lokasirs = "google.navigation:q=0.50371807167375, 101.44296606136925";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));
            }
            else if (pilihan.equals("Website")){
                String website = "http://sman5pekanbaru.sch.id/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }
            else if (pilihan.equals("Info di Google")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"SMA Negeri 5 Pekanbaru");
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
