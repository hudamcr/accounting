package com.perdamaianindonesia.accountingpi.penjualan

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
import com.perdamaianindonesia.accountingpi.penjualan.Model.SuratJalan
import com.perdamaianindonesia.accountingpi.penjualan.adapter.SuratJalanAdapter

class SuratJalanFragment : Fragment() {
    private val keuanganList = ArrayList<SuratJalan>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: SuratJalanAdapter? = null
    private var fab : FloatingActionButton? =null
    private var history : TextView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_surat_jalan, container, false)
        (activity as PenjualanActivity).setActionBarTitle("SURAT JALAN")
        history=view.findViewById(R.id.history)
        history!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = SuratJalanHistoryFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = SuratJalanAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))
        fab=view.findViewById(R.id.fab)
        fab!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = SuratJalanAddFragment()
            (activity as PenjualanActivity).setActionBarTitle("TAMBAH SURAT JALAN")
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        prepareSuratJalanData()
        return view
    }

    private fun prepareSuratJalanData() {
        var keuangan = SuratJalan("SJ199928381", "02-07-2019","CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian")
        keuanganList.add(keuangan)

        keuangan = SuratJalan("SJ199928381", "02-07-2019","CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian")
        keuanganList.add(keuangan)

        keuangan = SuratJalan("SJ199928381", "02-07-2019","CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian")
        keuanganList.add(keuangan)

        keuangan = SuratJalan("SJ199928381", "02-07-2019","CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian")
        keuanganList.add(keuangan)

        keuangan = SuratJalan("SJ199928381", "02-07-2019","CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian")
        keuanganList.add(keuangan)

        mAdapter!!.notifyDataSetChanged()
    }
}
