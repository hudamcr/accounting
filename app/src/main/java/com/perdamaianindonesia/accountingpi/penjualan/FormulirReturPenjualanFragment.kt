package com.perdamaianindonesia.accountingpi.penjualan

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.perdamaianindonesia.accountingpi.R
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.widget.TextView
import com.perdamaianindonesia.accountingpi.penjualan.Model.ReturPenjualan
import com.perdamaianindonesia.accountingpi.penjualan.adapter.ReturPenjualanAdapter

class FormulirReturPenjualanFragment : Fragment() {
    private var formulir_retur: TextView? = null
    private var memo_retur: TextView? = null
    private val keuanganList = ArrayList<ReturPenjualan>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: ReturPenjualanAdapter? = null
    private var fab : FloatingActionButton? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_formulir_retur_penjualan, container, false)
        (activity as PenjualanActivity).setActionBarTitle("RETUR PENJUALAN")
        formulir_retur=view.findViewById(R.id.formulir_retur)
        formulir_retur!!.setOnClickListener(View.OnClickListener {

        })
        memo_retur=view.findViewById(R.id.memo_retur)
        memo_retur!!.setOnClickListener(View.OnClickListener {

            val newFragment = MemoReturPenjualanFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
            memo_retur!!.setBackgroundColor(R.drawable.round_merah)
            memo_retur!!.setTextColor(android.R.color.white)
        })
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = ReturPenjualanAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))
        fab=view.findViewById(R.id.fab)
        fab!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear();
            val newFragment = ReturPenjualanAddFragment()
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
        var keuangan = ReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","10","Kg")
        keuanganList.add(keuangan)

        keuangan = ReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","10","Kg")
        keuanganList.add(keuangan)

        keuangan = ReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","10","Kg")
        keuanganList.add(keuangan)

        keuangan = ReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","10","Kg")
        keuanganList.add(keuangan)

        keuangan = ReturPenjualan("19-02-2019", "KB1970001","AGUS SETIAWAN","10","Kg")
        keuanganList.add(keuangan)

        mAdapter!!.notifyDataSetChanged()
    }
    override fun onResume() {
        super.onResume()

        view!!.isFocusableInTouchMode = true
        view!!.requestFocus()
        view!!.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {


                if (event.getAction() === KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    getActivity()!!.finish();
//                    val newFragment = MemoOrderFragment()
//                    val transaction = activity!!.supportFragmentManager.beginTransaction()
//                    // Replace whatever is in the fragment_container view with this fragment,
//                    // and add the transaction to the back stack so the user can navigate back
//                    transaction.replace(R.id.content_frame, newFragment)
//                    // Commit the transaction
//                    transaction.commit()
                    return true
                }
                return false
            }
        })
    }
}
