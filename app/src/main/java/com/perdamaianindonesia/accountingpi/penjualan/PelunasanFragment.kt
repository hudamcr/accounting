package com.perdamaianindonesia.accountingpi.penjualan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perdamaianindonesia.accountingpi.R
import com.perdamaianindonesia.accountingpi.penjualan.Model.Pelunasan
import com.perdamaianindonesia.accountingpi.penjualan.adapter.PelunasanAdapter

class PelunasanFragment : Fragment() {
    private val keuanganList = ArrayList<Pelunasan>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: PelunasanAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pelunasan, container, false)

        (activity as PenjualanActivity).setActionBarTitle("PELUNASAN")
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = PelunasanAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))

        preparePelunasanData()
        return view
    }

    private fun preparePelunasanData() {
        var keuangan = Pelunasan("02-07-2019", "KB0001","AGUS SETIAWAN","32.9400.000","02-09-2019","Transfer")
        keuanganList.add(keuangan)

        keuangan = Pelunasan("02-07-2019", "KB0002","CV. BUMI UTAMA KARYA","2.400.000","02-09-2019","Transfer")
        keuanganList.add(keuangan)

        keuangan = Pelunasan("02-07-2019", "KB0003","CV. BUMI UTAMA KARYA","2.400.000","02-09-2019","Transfer")
        keuanganList.add(keuangan)

        keuangan = Pelunasan("02-07-2019", "KB0004","CV. BUMI UTAMA KARYA","2.400.000","02-09-2019","Transfer")
        keuanganList.add(keuangan)

        keuangan = Pelunasan("02-07-2019", "KB0005","CV. BUMI UTAMA KARYA","2.400.000","02-09-2019","Transfer")
        keuanganList.add(keuangan)

        mAdapter!!.notifyDataSetChanged()
    }
}

