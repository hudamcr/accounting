package com.perdamaianindonesia.accountingpi

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.perdamaianindonesia.accountingpi.dashboard.adapter.AnalisaKeuanganAdapter
import com.perdamaianindonesia.accountingpi.dashboard.model.Keuangan


class AnalisaKeuanganFragment : Fragment() {
    private val keuanganList = ArrayList<Keuangan>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: AnalisaKeuanganAdapter? = null
    private var history: LinearLayout? = null
    private var image: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_analisa_keuangan, container, false)

        recyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = AnalisaKeuanganAdapter(keuanganList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(mLayoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(mAdapter)

        prepareKeuanganData()
        history=view.findViewById(R.id.l1);
        history!!.setOnClickListener(View.OnClickListener {
            dialog_keuangan();
        })
        return view
    }

    private fun dialog_keuangan() {
        val builder = AlertDialog.Builder(context!!)
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_analisis_keuangan, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        image = dialogView.findViewById(R.id.imageXX)
        image!!.setOnClickListener(View.OnClickListener {
            dialog.cancel()
        })
        dialog.show()
        dialog.window!!.setLayout(1300, LinearLayout.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val window = dialog.window
        window!!.setLayout(1300, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    private fun prepareKeuanganData() {
        var keuangan = Keuangan("Buku Bank", "0")
        keuanganList.add(keuangan)

        keuangan = Keuangan("Buku Kas", "0")
        keuanganList.add(keuangan)

        keuangan = Keuangan("Buku Giro / Cek", "0")
        keuanganList.add(keuangan)

        keuangan = Keuangan("Total Nilai Stok", "61.632.833.342,9")
        keuanganList.add(keuangan)

        keuangan = Keuangan("Total Piutang", "7.008.860.000")
        keuanganList.add(keuangan)

        keuangan = Keuangan("Total Hutang", "635.500.475,3")
        keuanganList.add(keuangan)

        mAdapter!!.notifyDataSetChanged()
    }
}
