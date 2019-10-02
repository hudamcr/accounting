package com.perdamaianindonesia.accountingpi;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.perdamaianindonesia.accountingpi.penjualan.PenjualanActivity;

public class MainActivity extends AppCompatActivity {
//    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coba);
//        tabHost = findViewById(android.R.id.tabhost);
//        tabHost.setup();
//
//        //Tab 1
//        TabHost tabHost = getTabHost();
//        TabHost.TabSpec spec;
//        Intent intent = new Intent(this, DashboardActivity.class);
//        spec = tabHost.newTabSpec("Dashboard").setIndicator("Dashboard", getResources().getDrawable(R.drawable.tab_selector_dashboard)).setContent(intent);
//        tabHost.addTab(spec);
//
//        TabHost.TabSpec spec2;
//        Intent intent2 = new Intent(this, PenjualanActivity.class);
//        spec2 = tabHost.newTabSpec("Penjualan").setIndicator("Penjualan", getResources().getDrawable(R.drawable.tab_selector_dashboard)).setContent(intent2);
//        tabHost.addTab(spec2);
//
//        tabHost.setCurrentTab(0);

    }
}
