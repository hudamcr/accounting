package com.perdamaianindonesia.accountingpi.penjualan

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.perdamaianindonesia.accountingpi.R
import com.perdamaianindonesia.accountingpi.penjualan.Model.MemoReturPenjualan
import com.perdamaianindonesia.accountingpi.penjualan.adapter.MemoReturPenjualanAdapter


class MemoReturPenjualanFragment : Fragment() {
    private var formulir_retur: TextView? = null
    private var memo_retur: TextView? = null
    private val keuanganList = ArrayList<MemoReturPenjualan>()
    private var fab : FloatingActionButton? =null
    private var recyclerView: RecyclerView? = null
    private var mAdapter: MemoReturPenjualanAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_memo_retur_penjualan, container, false)
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = MemoReturPenjualanAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))
        formulir_retur=view.findViewById(R.id.formulir_retur)
        formulir_retur!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = FormulirReturPenjualanFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
            formulir_retur!!.setBackgroundColor(R.drawable.round_merah)
            formulir_retur!!.setTextColor(android.R.color.white)
        })
        memo_retur=view.findViewById(R.id.memo_retur)
        memo_retur!!.setOnClickListener(View.OnClickListener {

        })
        fab=view.findViewById(R.id.fab)
        fab!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = MemoReturPenjualanAddFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        prepareReturPenjualanData()


        return view
    }
    private fun prepareReturPenjualanData() {
        var keuangan = MemoReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","Dayat","Rochmad")
        keuanganList.add(keuangan)

        keuangan = MemoReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","Dayat","Dayat")
        keuanganList.add(keuangan)

        keuangan = MemoReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","Dayat","Dayat")
        keuanganList.add(keuangan)

        keuangan = MemoReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","Dayat","Dayat")
        keuanganList.add(keuangan)

        keuangan = MemoReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","Dayat","Dayat")
        keuanganList.add(keuangan)

        mAdapter!!.notifyDataSetChanged()
    }
}
