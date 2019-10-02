package com.perdamaianindonesia.accountingpi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perdamaianindonesia.accountingpi.dashboard.adapter.SummaryStokAdapter
import com.perdamaianindonesia.accountingpi.dashboard.model.Stok


class SummaryStokFragment : Fragment() {
    private val stokList = ArrayList<Stok>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: SummaryStokAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_stok, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        mAdapter = SummaryStokAdapter(stokList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)

        prepareStokData()
        return view
    }

    private fun prepareStokData() {
        var stok = Stok("ACTIVE RUBBER ACTIVATOR", "20", "13.125.000")
        stokList.add(stok)

        stok = Stok("Batu Bara", "66840", "4.200.000")
        stokList.add(stok)

        stok = Stok("BIRU", "0", "24.000.000")
        stokList.add(stok)

        stok = Stok("CALSIUM DSGM", "43100", "22.709.500")
        stokList.add(stok)

        stok = Stok("CALSIUM OMYA", "12008", "30.500.000")
        stokList.add(stok)


        mAdapter!!.notifyDataSetChanged()
    }
}

