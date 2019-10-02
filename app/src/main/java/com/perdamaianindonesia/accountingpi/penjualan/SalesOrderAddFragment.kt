package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.perdamaianindonesia.accountingpi.R



class SalesOrderAddFragment : Fragment() {

    private var tambah: TextView? = null
    private var batal: TextView? = null
    private var simpan: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_sales_order_add, container, false)
        (activity as PenjualanActivity).setActionBarTitle("TAMBAH SALES ORDER")
        tambah=view.findViewById(R.id.tambah)
        batal=view.findViewById(R.id.batal)
        simpan=view.findViewById(R.id.simpan)
        tambah!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Tambah",Toast.LENGTH_SHORT).show()
        })
        batal!!.setOnClickListener(View.OnClickListener {
            val newFragment = SalesOrderFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })
        simpan!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"Simpan  ",Toast.LENGTH_SHORT).show()
        })


        return view
    }

}
