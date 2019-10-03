package com.perdamaianindonesia.accountingpi.penjualan

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.perdamaianindonesia.accountingpi.R
import kotlinx.android.synthetic.main.activity_penjualan.*
import kotlinx.android.synthetic.main.app_bar_penjualan.*
import android.R.attr.fragment
import android.support.v4.app.Fragment
import android.R.attr.fragment
import android.R.attr.fragment
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import com.perdamaianindonesia.accountingpi.DashboardActivity
import kotlinx.android.synthetic.main.content_penjualan.*
import android.R.attr.tag




class PenjualanActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjualan)
        setSupportActionBar(toolbar)
        linear_penjualan_1.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, DashboardActivity::class.java)
            startActivity(intent)

        })
        linear_penjualan_2.setOnClickListener(View.OnClickListener {
            linear_penjualan_2.setClickable(false)
        })
        linear_penjualan_3.setOnClickListener(View.OnClickListener {
            linear_penjualan_3.setClickable(false)
        })
        linear_penjualan_4.setOnClickListener(View.OnClickListener {
            linear_penjualan_4.setClickable(false)
        })
        linear_penjualan_5.setOnClickListener(View.OnClickListener {
            linear_penjualan_5.setClickable(false)
        })
        linear_penjualan_6.setOnClickListener(View.OnClickListener {
            linear_penjualan_6.setClickable(false)
        })

        var fragment: Fragment? = null
        toolbar_title.setText("MEMO ORDER")
        fragment = MemoOrderFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.content_frame, fragment)
        ft.commit()

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.setDrawerIndicatorEnabled(false)
        toggle.setToolbarNavigationClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        })
        toggle.setHomeAsUpIndicator(R.mipmap.ic_hamburg);
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    fun setActionBarTitle(title: String) {
        toolbar_title.setText(title)
    }
    override fun onBackPressed() {
        var fragment: Fragment? = null
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            if(getFragmentManager().getBackStackEntryCount() > 0){
                getFragmentManager().popBackStackImmediate()
            }
            else{
                super.onBackPressed();
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.penjualan, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.memo_order -> {
                showMemoOrder()
//                toolbar_title.setText("MEMO ORDER")
//                fragment = MemoOrderFragment()
            }
            R.id.sales_order -> {
                showSalesOrder()
//                toolbar_title.setText("SALES ORDER")
//                fragment = SalesOrderFragment()
            }
            R.id.jadwal_pengiriman -> {
                jadwalPengiriman()
//                toolbar_title.setText("JADWAL PENGIRIMAN")
//                fragment = JadwalPengirimanFragment()
            }
            R.id.surat_jalan -> {
                suratJalan()
//                toolbar_title.setText("SURAT JALAN")
//                fragment = SuratJalanFragment()
            }
            R.id.faktur_jual -> {
                fakturJual()
//                toolbar_title.setText("FAKTUR JUAL")
//                fragment = FakturJualFragment()
            }
            R.id.daftar_piutang -> {
                daftarPiutang()
//                toolbar_title.setText("DAFTAR PIUTANG")
//                fragment = DaftarPiutangFragment()
            }
            R.id.pelunasan -> {
                pelunasan()
//                toolbar_title.setText("PELUNASAN")
//                fragment = PelunasanFragment()
            }
            R.id.retur_penjualan -> {
                returPenjualan()
//                toolbar_title.setText("RETUR PENJUALAN")
//                fragment = FormulirReturPenjualanFragment()
//                startActivity(Intent(this, PenjualanActivity::class.java))

            }
            R.id.kwitansi -> {
                kwitansii()
//                toolbar_title.setText("KWITANSI")
//                fragment = KwitansiFragment()
            }
        }
//        if (fragment != null) {
//            val ft = supportFragmentManager.beginTransaction()
//            ft.replace(R.id.content_frame, fragment)
//            ft.commit()
//        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun kwitansii() {
        val tag = KwitansiFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = KwitansiFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }
    }

    private fun returPenjualan() {
        val tag = FormulirReturPenjualanFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = FormulirReturPenjualanFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }
    }

    private fun pelunasan() {
        val tag = PelunasanFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = PelunasanFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }
    }

    private fun daftarPiutang() {
        val tag = DaftarPiutangFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = DaftarPiutangFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }
    }

    private fun fakturJual() {
        val tag = FakturJualFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = FakturJualFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }
    }

    private fun suratJalan() {
        val tag = SuratJalanFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = SuratJalanFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }
    }

    private fun jadwalPengiriman() {
        val tag = JadwalPengirimanFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = JadwalPengirimanFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }
    }

    private fun showSalesOrder() {
        val tag = SalesOrderFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = SalesOrderFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    private fun showMemoOrder() {
        val tag = MemoOrderFragment::class.java!!.getSimpleName()

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = MemoOrderFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}
