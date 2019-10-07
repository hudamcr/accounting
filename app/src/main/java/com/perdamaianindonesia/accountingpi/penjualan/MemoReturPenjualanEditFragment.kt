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
import com.github.chrisbanes.photoview.PhotoView
import com.perdamaianindonesia.accountingpi.MainActivity





class MemoReturPenjualanEditFragment : Fragment() {
    private var batal: TextView? = null
    private var simpan: TextView? = null
    private var ttd: ImageView? = null
    private var ttd2: ImageView? = null
    private var retur:ImageView? =null
    private var vertifikasi:ImageView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_memo_retur_penjualan_edit, container, false)
        (activity as PenjualanActivity).setActionBarTitle("EDIT MEMO RETUR")
        batal=view.findViewById(R.id.batal)
        simpan=view.findViewById(R.id.simpan)
        retur=view.findViewById(R.id.img_retur)
        vertifikasi=view.findViewById(R.id.img_vertikasi)
        retur!!.setOnClickListener(View.OnClickListener {
           dialog_retur()
        })
        vertifikasi=view.findViewById(R.id.img_vertikasi)
        vertifikasi!!.setOnClickListener(View.OnClickListener {
            dialog_vertifikasi()
        })
        batal!!.setOnClickListener(View.OnClickListener {
            val newFragment = MemoReturPenjualanFragment()
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
