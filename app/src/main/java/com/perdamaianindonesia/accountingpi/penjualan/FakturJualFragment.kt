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
import com.perdamaianindonesia.accountingpi.penjualan.Model.FakturJual
import com.perdamaianindonesia.accountingpi.penjualan.adapter.FakturJualAdapter

class FakturJualFragment : Fragment() {
    private val keuanganList = ArrayList<FakturJual>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: FakturJualAdapter? = null
    private var history : TextView? =null
    private var fab : FloatingActionButton? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_faktur_jual, container, false)
        (activity as PenjualanActivity).setActionBarTitle("FAKTUR JUAL")
        history=view.findViewById(R.id.history)
        history!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = FakturJualHistoryFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
//            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = FakturJualAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))
        fab=view.findViewById(R.id.fab)
        fab!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = FakturJualAddFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        prepareFakturJualData()
        return view
    }

    private fun prepareFakturJualData() {
        var keuangan = FakturJual("IV199928381", "CV. ORANG TUA GEMILANG","Perum Grand Surya Blok B5 No 11 RT. 005 RW. 003 Duuh Tengah Buduran","","02-07-2019","SJ99928381","30")
        keuanganList.add(keuangan)

            keuangan = FakturJual("IV199928382", "CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian","","02-07-2019","SJ99928382","30")
        keuanganList.add(keuangan)

        keuangan = FakturJual("IV199928383", "CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian","","02-07-2019","SJ99928383","30")
        keuanganList.add(keuangan)

        keuangan = FakturJual("IV199928384", "CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian","","02-07-2019","SJ99928384","30")
        keuanganList.add(keuangan)

        keuangan = FakturJual("IV199928385", "CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian","","02-07-2019","SJ99928385","30")
        keuanganList.add(keuangan)

        mAdapter!!.notifyDataSetChanged()
    }
}
