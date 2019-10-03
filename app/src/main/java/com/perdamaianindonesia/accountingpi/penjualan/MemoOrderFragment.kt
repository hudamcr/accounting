package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.perdamaianindonesia.accountingpi.R
import com.perdamaianindonesia.accountingpi.penjualan.Model.MemoOrder
import com.perdamaianindonesia.accountingpi.penjualan.adapter.MemoOrderAdapter
import android.support.v7.widget.DividerItemDecoration
import android.view.KeyEvent
import com.perdamaianindonesia.accountingpi.R.id.recyclerView



class MemoOrderFragment : Fragment() {
    private val keuanganList = ArrayList<MemoOrder>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: MemoOrderAdapter? = null
    private var fab: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_memo_order, container, false)
        (activity as PenjualanActivity).setActionBarTitle("MEMO ORDER")
        recyclerView = view.findViewById(R.id.recyclerView)
        fab=view.findViewById(R.id.fab);
        fab!!.setOnClickListener(View.OnClickListener {
            val newFragment = MemoOrderAddFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })
        mAdapter = MemoOrderAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))

        prepareMemoOrderData()
        return view
    }

    private fun prepareMemoOrderData() {
        var keuangan = MemoOrder("19/09/2019","Rochmat Hidayat", "KB0001\n\nKB0004","1. Karet Gelang 999 10 Kg\n\n2. Karet Gelang 999 10 Kg","12\n\n3")
        keuanganList.add(keuangan)

        keuangan = MemoOrder("19/09/2019","Rochmat", "KB0002","1. Karet Gelang 999 Los","12")
        keuanganList.add(keuangan)

        keuangan = MemoOrder("19/09/2019"," Hidayat", "KB0003\n\nKB002\n\nKB0006","1. Karet Gelang 999 Pth 1/2 Kg\n\n2. Karet Gelang 999 Los\n\n3. Karet Gelang Brontoseno","12\n\n12\n\n12")
        keuanganList.add(keuangan)

        keuangan = MemoOrder("19/09/2019"," Dayat", "KB0004","1. Karet Gelang Bebek Putih - Kuning","12")
        keuanganList.add(keuangan)

        keuangan = MemoOrder("19/09/2019","Rachmat Hidayat", "KB0005","1. Karet Gelang Putih Los (60 Kg)","12")
        keuanganList.add(keuangan)

        keuangan = MemoOrder("19/09/2019", "Rochmat Dayat","KB0006","1. Karet Gelang Brontoseno","12")
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
