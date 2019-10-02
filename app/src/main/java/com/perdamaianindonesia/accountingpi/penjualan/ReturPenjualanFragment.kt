package com.perdamaianindonesia.accountingpi.penjualan

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.perdamaianindonesia.accountingpi.R





class ReturPenjualanFragment : Fragment() {
    private var formulir_retur: TextView? = null
    private var memo_retur: TextView? = null
    private var lihat1: TextView? = null
    private var lihat2: TextView? = null
    private var lihat3: TextView? = null
    private var edit1: TextView? = null
    private var edit2: TextView? = null
    private var edit3: TextView? = null
    private var fab : FloatingActionButton? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_retur_penjualan, container, false)

        (activity as PenjualanActivity).setActionBarTitle("RETUR PENJUALAN")
        formulir_retur=view.findViewById(R.id.formulir_retur)
        formulir_retur!!.setOnClickListener(View.OnClickListener {

        })
        edit1=view.findViewById(R.id.edit1)
        edit1!!.setOnClickListener(View.OnClickListener {
            val newFragment = ReturPenjualanEditFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })
        edit2=view.findViewById(R.id.edit2)
        edit2!!.setOnClickListener(View.OnClickListener {
            val newFragment = ReturPenjualanEditFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })
        edit3=view.findViewById(R.id.edit3)
        edit3!!.setOnClickListener(View.OnClickListener {
            val newFragment = ReturPenjualanEditFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })


        lihat1=view.findViewById(R.id.lhat1)
        lihat1!!.setOnClickListener(View.OnClickListener {
            val newFragment = ReturPenjualanLihatFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })
        lihat2=view.findViewById(R.id.lihat2)
        lihat2!!.setOnClickListener(View.OnClickListener {
            val newFragment = ReturPenjualanLihatFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })
        lihat3=view.findViewById(R.id.lihat3)
        lihat3!!.setOnClickListener(View.OnClickListener {
            val newFragment = ReturPenjualanLihatFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })


        (activity as PenjualanActivity).setActionBarTitle("RETUR PENJUALAN")
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
        fab=view.findViewById(R.id.fab)
        fab!!.setOnClickListener(View.OnClickListener {
            val newFragment = ReturPenjualanAddFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })


        return view
    }
}



