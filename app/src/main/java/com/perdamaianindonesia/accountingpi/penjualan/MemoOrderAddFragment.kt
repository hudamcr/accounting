package com.perdamaianindonesia.accountingpi.penjualan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.perdamaianindonesia.accountingpi.R
import com.perdamaianindonesia.accountingpi.penjualan.MemoOrderFragment
import com.perdamaianindonesia.accountingpi.penjualan.PenjualanActivity
import kotlin.math.tan


class MemoOrderAddFragment : Fragment() {

    private var tambah: TextView? = null
    private var batal: TextView? = null
    private var simpan: TextView? = null
    private var tanya : EditText? = null
    private var tanya2 : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_memo_order_add, container, false)
        (activity as PenjualanActivity).setActionBarTitle("TAMBAH MEMO ORDER")
        tambah=view.findViewById(R.id.tambah)
        batal=view.findViewById(R.id.batal)
        simpan=view.findViewById(R.id.simpan)
        tambah!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Tambah", Toast.LENGTH_SHORT).show()
        })
        tanya=view.findViewById(R.id.tanya)
        tanya!!.setOnClickListener(View.OnClickListener {
            dialog_memo_order_add();
        })
        tanya2=view.findViewById(R.id.tanya2)
        tanya2!!.setOnClickListener(View.OnClickListener {
            dialog_memo_order_add();
        })
        batal!!.setOnClickListener(View.OnClickListener {
            val newFragment = MemoOrderFragment()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
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

    private fun dialog_memo_order_add() {
        val builder = android.support.v7.app.AlertDialog.Builder(context!!)
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_memo_order_add, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        val image = dialogView.findViewById<ImageView>(R.id.imageXX)
        image.setOnClickListener { dialog.cancel() }
        dialog.show()
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(1800, LinearLayout.LayoutParams.WRAP_CONTENT)
        val window = dialog.window
        window!!.setLayout(1800, LinearLayout.LayoutParams.WRAP_CONTENT)
    }
}
