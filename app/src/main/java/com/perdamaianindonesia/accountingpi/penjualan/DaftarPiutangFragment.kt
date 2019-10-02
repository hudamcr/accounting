package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.perdamaianindonesia.accountingpi.R
import com.perdamaianindonesia.accountingpi.penjualan.Model.DaftarPiutang
import com.perdamaianindonesia.accountingpi.penjualan.adapter.DaftarPiutangAdapter
import android.support.v7.widget.DividerItemDecoration
import android.widget.TextView
import android.widget.Toast
import com.perdamaianindonesia.accountingpi.R.id.recyclerView



class DaftarPiutangFragment : Fragment() {
    private val keuanganList = ArrayList<DaftarPiutang>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: DaftarPiutangAdapter? = null
    private var print : TextView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_daftar_piutang, container, false)
        (activity as PenjualanActivity).setActionBarTitle("DAFTAR PIUTANG")
        print=view.findViewById(R.id.print)
        print!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"PRINT", Toast.LENGTH_SHORT).show()
        })
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = DaftarPiutangAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))

        prepareDaftarPiutangData()
        return view
    }

    private fun prepareDaftarPiutangData() {
        var keuangan = DaftarPiutang("KP12050001", "PT GOLDEN RUBBER INDUSTRY","2.500.000","LANCAR")
        keuanganList.add(keuangan)

        keuangan = DaftarPiutang("KP12050002", "PT GOLDEN RUBBER INDUSTRY","2.500.000","LANCAR")
        keuanganList.add(keuangan)

        keuangan = DaftarPiutang("KP12050003", "PT GOLDEN RUBBER INDUSTRY","2.500.000","KURANG")
        keuanganList.add(keuangan)

        keuangan = DaftarPiutang("KP12050004", "PT GOLDEN RUBBER INDUSTRY","2.500.000","LANCAR")
        keuanganList.add(keuangan)

        keuangan = DaftarPiutang("KP12050005", "PT GOLDEN RUBBER INDUSTRY","2.500.000","LANCAR")
        keuanganList.add(keuangan)

        keuangan = DaftarPiutang("KP12050006", "PT GOLDEN RUBBER INDUSTRY","2.500.000","MACET")
        keuanganList.add(keuangan)
        mAdapter!!.notifyDataSetChanged()
    }
}
