package com.perdamaianindonesia.accountingpi

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perdamaianindonesia.accountingpi.dashboard.adapter.AnalisaPiutangAdapter
import com.perdamaianindonesia.accountingpi.dashboard.model.Piutang


class AnalisisPiutangFragment : Fragment() {
    private val piutangList = ArrayList<Piutang>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: AnalisaPiutangAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_piutang, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        mAdapter = AnalisaPiutangAdapter(context,piutangList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)

        preparePiutangData()
        return view
    }

    private fun preparePiutangData() {
        var piutang = Piutang("1", "CV. INDOPRIMERA", "0")
        piutangList.add(piutang)

        piutang = Piutang("2", "CV. JAYA PERKASA", "0")
        piutangList.add(piutang)

        piutang = Piutang("3", "CV. YAKEKE DAMAI SEJAHTERA", "0")
        piutangList.add(piutang)

        piutang = Piutang("4", "CV. DHAYA ANUGERAH UTAMA", "61.632.833.342,9")
        piutangList.add(piutang)

        piutang = Piutang("5", "CV. PANGESTU GUNA GLOVES", "7.008.860.000")
        piutangList.add(piutang)


        mAdapter!!.notifyDataSetChanged()
    }
}

