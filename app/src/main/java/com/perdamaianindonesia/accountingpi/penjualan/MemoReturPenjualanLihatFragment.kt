package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import com.perdamaianindonesia.accountingpi.R



class MemoReturPenjualanLihatFragment : Fragment() {
    private var print: TextView? = null
    private var hapus: TextView? = null
    private var ttd: ImageView? = null
    private var ttd2: ImageView? = null
    private var retur:ImageView? =null
    private var vertifikasi:ImageView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_memo_retur_penjualan_lihat, container, false)
        (activity as PenjualanActivity).setActionBarTitle("LIHAT MEMO RETUR")
        print=view.findViewById(R.id.print)
        hapus=view.findViewById(R.id.hapus)
        retur=view.findViewById(R.id.img_retur)
        vertifikasi=view.findViewById(R.id.img_vertikasi)
        retur!!.setOnClickListener(View.OnClickListener {
            dialog_retur()
        })
        vertifikasi=view.findViewById(R.id.img_vertikasi)
        vertifikasi!!.setOnClickListener(View.OnClickListener {
            dialog_vertifikasi()
        })
        print!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Print  ", Toast.LENGTH_SHORT).show()
        })
        hapus!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"Hapus  ", Toast.LENGTH_SHORT).show()
        })
        ttd=view.findViewById(R.id.ttd)
        ttd2=view.findViewById(R.id.ttd2)
        ttd!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, TandaTangan2Activity::class.java)
            startActivity(intent)
        })
        ttd2!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, TandaTangan2Activity::class.java)
            startActivity(intent)
        })


        return view
    }
    private fun dialog_vertifikasi() {
        val mBuilder = AlertDialog.Builder(context!!)
        val mView = layoutInflater.inflate(R.layout.dialog_foto_retur, null)
        val photoView =mView.findViewById<ImageView>(R.id.imageView)
        photoView.setImageResource(R.drawable.foto_vertifikasi)
        mBuilder.setView(mView)
        val mDialog = mBuilder.create()

        val image = mView.findViewById<ImageView>(R.id.imageXX)
        image.setOnClickListener(View.OnClickListener { mDialog.cancel() })
        mDialog.show()
        mDialog.getWindow()!!.setBackgroundDrawableResource(android.R.color.transparent)
        mDialog.getWindow()!!.setLayout(1600, LinearLayout.LayoutParams.WRAP_CONTENT)
        val window = mDialog.getWindow()
        window!!.setLayout(1600, LinearLayout.LayoutParams.WRAP_CONTENT)
        mDialog.show()
    }

    private fun dialog_retur() {
        val mBuilder = AlertDialog.Builder(context!!)
        val mView = layoutInflater.inflate(R.layout.dialog_foto_retur, null)
        val photoView =mView.findViewById<ImageView>(R.id.imageView)
        photoView.setImageResource(R.drawable.foto_retur)
        mBuilder.setView(mView)
        val mDialog = mBuilder.create()

        val image = mView.findViewById<ImageView>(R.id.imageXX)
        image.setOnClickListener(View.OnClickListener { mDialog.cancel() })
        mDialog.show()
        mDialog.getWindow()!!.setBackgroundDrawableResource(android.R.color.transparent)
        mDialog.getWindow()!!.setLayout(1600, LinearLayout.LayoutParams.WRAP_CONTENT)
        val window = mDialog.getWindow()
        window!!.setLayout(1800, LinearLayout.LayoutParams.WRAP_CONTENT)
        mDialog.show()
    }
}
