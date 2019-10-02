package com.perdamaianindonesia.accountingpi.penjualan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.perdamaianindonesia.accountingpi.R



class ReturPenjualanEditFragment : Fragment() {


    private var tambah: TextView? = null
    private var batal: TextView? = null
    private var simpan: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_retur_penjualan_edit, container, false)
        (activity as PenjualanActivity).setActionBarTitle("EDIT FORMULIR RETUR PENJUALAN")
        tambah=view.findViewById(R.id.tambah)
        batal=view.findViewById(R.id.batal)
        simpan=view.findViewById(R.id.simpan)
        tambah!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Tambah", Toast.LENGTH_SHORT).show()
        })
        batal!!.setOnClickListener(View.OnClickListener {
            val newFragment = FormulirReturPenjualanFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and edit the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        })
        simpan!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"Simpan  ", Toast.LENGTH_SHORT).show()
        })


        return view
    }
}
