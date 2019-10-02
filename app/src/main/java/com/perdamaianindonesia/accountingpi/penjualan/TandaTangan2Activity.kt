package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.perdamaianindonesia.accountingpi.R
import kotlinx.android.synthetic.main.activity_tanda_tangan.*

class TandaTangan2Activity : AppCompatActivity() {

    private var batal: TextView? = null
    private var simpan: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanda_tangan2)
        img_ttd.setOnClickListener(View.OnClickListener {

            if(getFragmentManager().getBackStackEntryCount() > 0){
                getFragmentManager().popBackStackImmediate()
            }
            else{
                super.onBackPressed();
            }

        })
        batal=findViewById(R.id.batal)
        simpan=findViewById(R.id.simpan)
        batal!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(applicationContext,"Batal  ", Toast.LENGTH_SHORT).show()
        })
        simpan!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(applicationContext,"Simpan  ", Toast.LENGTH_SHORT).show()
        })
    }
}
