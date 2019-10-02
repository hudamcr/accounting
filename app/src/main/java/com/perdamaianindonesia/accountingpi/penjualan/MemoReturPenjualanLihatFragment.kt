package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.perdamaianindonesia.accountingpi.R



class MemoReturPenjualanLihatFragment : Fragment() {
    private var print: TextView? = null
    private var hapus: TextView? = null
    private var ttd: TextView? = null
    private var ttd2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_memo_retur_penjualan_lihat, container, false)
        (activity as PenjualanActivity).setActionBarTitle("LIHAT MEMO RETUR")
        print=view.findViewById(R.id.print)
        hapus=view.findViewById(R.id.hapus)
        print!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Print  ", Toast.LENGTH_SHORT).show()
        })
        hapus!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"Hapus  ", Toast.LENGTH_SHORT).show()
        })
        ttd=view.findViewById(R.id.ttd)
        ttd2=view.findViewById(R.id.ttd2)
        ttd!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, TandaTangan2Activity::class.java)
            startActivity(intent)
        })
        ttd2!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, TandaTangan2Activity::class.java)
            startActivity(intent)
        })


        return view
    }
}
