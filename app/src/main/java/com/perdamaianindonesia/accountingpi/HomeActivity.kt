package com.perdamaianindonesia.accountingpi

import android.app.TabActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.drawable.Drawable
import android.widget.*
import android.widget.TextView
import android.view.LayoutInflater
import com.perdamaianindonesia.accountingpi.penjualan.PenjualanActivity


class HomeActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val tabHost = findViewById<TabHost>(android.R.id.tabhost)
        if (tabHost != null) {
            addTab(tabHost, "Dashboard", "Dashboard",getDrawable(R.mipmap.ic_menu), DashboardActivity::class.java)
            addTab(tabHost, "Penjualan", "Penjualan",getDrawable(R.mipmap.ic_notifikasi), PenjualanActivity::class.java)
            addTab(tabHost, "Pembelian", "Pembelian",getDrawable(R.mipmap.ic_menu), DashboardActivity::class.java)
            addTab(tabHost, "Persediaan", "Persediaan",getDrawable(R.mipmap.ic_menu), DashboardActivity::class.java)
            addTab(tabHost, "Jurnal", "Jurnal",getDrawable(R.mipmap.ic_menu), DashboardActivity::class.java)
            addTab(tabHost, "Keuangan", "Keuangan",getDrawable(R.mipmap.ic_menu), DashboardActivity::class.java)

            tabHost.currentTab = 0
            tabHost.setOnTabChangedListener { tabId -> Toast.makeText(applicationContext, tabId, Toast.LENGTH_SHORT).show() }
        }
    }

    private fun addTab(tabHost: TabHost, name: String, indicator: String, drawable : Drawable, className: Class<*>) {
        val tabSpec = tabHost.newTabSpec(name)
        tabSpec.setIndicator(indicator)
        val intent = Intent(this, className)
        tabSpec.setContent(intent)
        tabHost.addTab(tabSpec)
        val tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, tabWidget, false)
        val title = tabIndicator.findViewById(R.id.title) as TextView
        title.setText(name)
        val icon = tabIndicator.findViewById(R.id.icon) as ImageView
        icon.setImageDrawable(drawable)
        icon.scaleType = ImageView.ScaleType.FIT_CENTER
    }

}

