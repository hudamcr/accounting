package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.perdamaianindonesia.accountingpi.R
import com.perdamaianindonesia.accountingpi.penjualan.Model.JadwalPengiriman
import com.perdamaianindonesia.accountingpi.penjualan.adapter.JadwalPengirimanAdapter

class JadwalPengirimanFragment : Fragment() {
    private val keuanganList = ArrayList<JadwalPengiriman>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: JadwalPengirimanAdapter? = null
    private var fab : FloatingActionButton? =null
    private var petugas:TextView?=null
    private var nama:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_jadwal_pengiriman, container, false)

        (activity as PenjualanActivity).setActionBarTitle("JADWAL PENGIRIMAN")
        petugas=view.findViewById(R.id.petugas)
        nama=view.findViewById(R.id.nama)
        petugas!!.setOnClickListener(View.OnClickListener {
            Dialog_petugas()
        })
        nama!!.setOnClickListener(View.OnClickListener {
            Dialog_petugas()
        })
        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = JadwalPengirimanAdapter(context,keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.getContext(), DividerItemDecoration.VERTICAL))
        fab=view.findViewById(R.id.fab)
        fab!!.setOnClickListener(View.OnClickListener {
            keuanganList.clear();
            val newFragment = JadwalPengirimanAddFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.content_frame, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()

        })
        prepareJadwalPengirimanData()
        return view
    }

    private fun Dialog_petugas() {
        val builder = android.support.v7.app.AlertDialog.Builder(context!!)
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_jadwal_pengiriman, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        val image = dialogView.findViewById<ImageView>(R.id.imageXX)
        image.setOnClickListener { dialog.cancel() }
        dialog.show()
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(700, LinearLayout.LayoutParams.WRAP_CONTENT)
        val window = dialog.window
        window!!.setLayout(700, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    private fun prepareJadwalPengirimanData() {
        var keuangan = JadwalPengiriman("11:20:00", "PT. GOLDEN RUBBER INDUSTRY","SO199928381","Jamal","Kirim segera, ya!")
        keuanganList.add(keuangan)

        keuangan = JadwalPengiriman("11:20:00", "PT. GOLDEN RUBBER INDUSTRY","SO199928382","Jamal","Kirim segera, ya!")
        keuanganList.add(keuangan)

        keuangan = JadwalPengiriman("11:20:00", "PT. GOLDEN RUBBER INDUSTRY","SO199928383","Jamal","Kirim segera, ya!")
        keuanganList.add(keuangan)

        keuangan = JadwalPengiriman("11:20:00", "PT. GOLDEN RUBBER INDUSTRY","SO199928384","Jamal","Kirim segera, ya!")
        keuanganList.add(keuangan)

        keuangan = JadwalPengiriman("11:20:00", "PT. GOLDEN RUBBER INDUSTRY","SO199928385","Jamal","Kirim segera, ya!")
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
