package com.perdamaianindonesia.accountingpi.penjualan

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.*
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.perdamaianindonesia.accountingpi.R
import com.perdamaianindonesia.accountingpi.penjualan.Model.SalesOrder
import com.perdamaianindonesia.accountingpi.penjualan.adapter.SalesOrderAdapter
import kotlinx.android.synthetic.main.app_bar_penjualan.*
import kotlinx.android.synthetic.main.fragment_sales_order.*

class SalesOrderFragment : Fragment() {
    private val keuanganList = ArrayList<SalesOrder>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: SalesOrderAdapter? = null
    private var history : TextView? =null
    private var fab : FloatingActionButton? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_sales_order, container, false)
        (activity as PenjualanActivity).setActionBarTitle("SALES ORDER")
        history=view.findViewById(R.id.history)
        history!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = SalesOrderHistoryFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        fab=view.findViewById(R.id.fab)
        fab!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear()
            val newFragment = SalesOrderAddFragment()
            (activity as PenjualanActivity).setActionBarTitle("TAMBAH SALES ORDER")
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = SalesOrderAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))

        prepareSalesOrderData()
        return view
    }

    private fun prepareSalesOrderData() {
        var keuangan = SalesOrder("SO199928381", "CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian","02-07-2019","02-07-2019")
        keuanganList.add(keuangan)

        keuangan = SalesOrder("SO199928382", "CV. CITRA MANDIRI PERKASA","Jl.Raya By Pass Krian","02-07-2019","02-07-2019")
        keuanganList.add(keuangan)

        keuangan = SalesOrder("SO199928383", "CV. NIXON PUTRA MANDIRI","Jl.Raya By Pass Krian","02-07-2019","02-07-2019")
        keuanganList.add(keuangan)

        keuangan = SalesOrder("SO199928384", "CV. BUMI UTAMA KARYA","Jl.Raya By Pass Krian","02-07-2019","02-07-2019")
        keuanganList.add(keuangan)

        keuangan = SalesOrder("SO199928385", "CV. GEMA PUTRA PERKASA","Jl.Raya By Pass Krian","02-07-2019","02-07-2019")
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
