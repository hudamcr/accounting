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



class JadwalPengirimanLihatFragment : Fragment() {

    private var ttd : TextView? =null
    private var print: TextView? = null
    private var hapus: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_jadwal_pengiriman_lihat, container, false)
        (activity as PenjualanActivity).setActionBarTitle("LIHAT JADWAL PENGIRIMAN")
        print=view.findViewById(R.id.print)
        hapus=view.findViewById(R.id.hapus)
        print!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"PRINT", Toast.LENGTH_SHORT).show()
        })
        hapus!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"Hapus", Toast.LENGTH_SHORT).show()
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
//            // and lihat the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.content_frame, newFragment)
//            transaction.lihatToBackStack(null)
//            // Commit the transaction
//            transaction.commit()
        })
        return view
    }
}
