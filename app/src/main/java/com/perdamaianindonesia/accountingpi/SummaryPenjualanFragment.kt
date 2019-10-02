package com.perdamaianindonesia.accountingpi

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.perdamaianindonesia.accountingpi.dashboard.adapter.DialogSummaryPenjualanAdapter
import com.perdamaianindonesia.accountingpi.dashboard.model.DialogSummaryPenjualan
import kotlinx.android.synthetic.main.dialog_summary_penjualan.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SummaryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SummaryFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var card_tahun: CardView? = null
    private var card_bulan: CardView? = null
    private var card_hari: CardView? = null
    private var image: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_summary_penjualan, container, false)
        card_tahun=view.findViewById(R.id.card_tahun)
        card_tahun!!.setOnClickListener(View.OnClickListener {
            Dialog_Tahun()
        })
        card_bulan=view.findViewById(R.id.card_bulan)
        card_bulan!!.setOnClickListener(View.OnClickListener {
            Dialog_Bulan()
        })
        card_hari=view.findViewById(R.id.card_hari)
        card_hari!!.setOnClickListener(View.OnClickListener {
            Dialog_Hari()
        })
        return view
    }

    private fun Dialog_Tahun() {
        val builder = AlertDialog.Builder(context!!)
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_summary_penjualan, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        image = dialogView.findViewById(R.id.imageXX)
        image!!.setOnClickListener(View.OnClickListener {
            dialog.cancel()
        })
        dialog.show()
        dialog.window!!.setLayout(1500, LinearLayout.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val window = dialog.window
        window!!.setLayout(1500, LinearLayout.LayoutParams.WRAP_CONTENT)

    }

    private fun Dialog_Bulan() {
        val builder = AlertDialog.Builder(context!!)
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_summary_penjualan2, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        image = dialogView.findViewById(R.id.imageXX)
        image!!.setOnClickListener(View.OnClickListener {
            dialog.cancel()
        })
        dialog.show()
        dialog.window!!.setLayout(1500, LinearLayout.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val window = dialog.window
        window!!.setLayout(1500, LinearLayout.LayoutParams.WRAP_CONTENT)

    }

    private fun Dialog_Hari() {
        val builder = AlertDialog.Builder(context!!)
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_summary_penjualan1, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        image = dialogView.findViewById(R.id.imageXX)
        image!!.setOnClickListener(View.OnClickListener {
            dialog.cancel()
        })
        dialog.show()
        dialog.window!!.setLayout(1500, LinearLayout.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val window = dialog.window
        window!!.setLayout(1500, LinearLayout.LayoutParams.WRAP_CONTENT)

    }

}
