package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.perdamaianindonesia.accountingpi.R



class JadwalPengirimanAddFragment : Fragment() {

    private var ttd : TextView? =null
    private var batal: TextView? = null
    private var simpan: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_jadwal_pengiriman_add, container, false)
        (activity as PenjualanActivity).setActionBarTitle("TAMBAH JADWAL PENGIRIMAN")
        batal=view.findViewById(R.id.batal)
        simpan=view.findViewById(R.id.simpan)
        batal!!.setOnClickListener(View.OnClickListener {
            val newFragment = JadwalPengirimanFragment()
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
        ttd=view.findViewById(R.id.ttd)
        ttd!!.setOnClickListener(View.OnClickListener {
            activity?.let{
                val intent = Intent (it, TandaTanganActivity::class.java)
                it.startActivity(intent)
            }
//            val newFragment = TandaTanganFragment()
//            val transaction = activity!!.supportFragmentManager.beginTransaction()
//            // Replace whatever is in the fragment_container view with this fragment,
//            // and add the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.content_frame, newFragment)
//            transaction.addToBackStack(null)
//            // Commit the transaction
//            transaction.commit()
        })
        return view
    }
}
