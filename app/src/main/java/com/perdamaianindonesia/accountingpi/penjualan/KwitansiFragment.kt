package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.perdamaianindonesia.accountingpi.R


class KwitansiFragment : Fragment() {


    private var print : TextView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_kwitansi, container, false)
        (activity as PenjualanActivity).setActionBarTitle("KWITANSI")
        print=view.findViewById(R.id.print)
        print!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"PRINT", Toast.LENGTH_SHORT).show()
        })
        return view
    }

 }