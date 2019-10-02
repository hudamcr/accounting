package com.perdamaianindonesia.accountingpi.dashboard.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.SummaryPenjualanFragmentKt;
import com.perdamaianindonesia.accountingpi.dashboard.model.DialogSummaryPenjualan;
import com.perdamaianindonesia.accountingpi.R;

import java.util.List;

public class DialogSummaryPenjualanAdapter extends RecyclerView.Adapter<DialogSummaryPenjualanAdapter.MyViewHolder> {

    private List<DialogSummaryPenjualan> keuanganList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama,berat,qty,total;

        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.nama);
            berat = (TextView) view.findViewById(R.id.berat);
            qty = (TextView) view.findViewById(R.id.qty);
            total = (TextView) view.findViewById(R.id.total);
        }
    }


    public DialogSummaryPenjualanAdapter(List<DialogSummaryPenjualan> keuanganList) {
        this.keuanganList = keuanganList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_dialog_summary_penjualan, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DialogSummaryPenjualan keuangan = keuanganList.get(position);
        holder.nama.setText("nama");
        holder.berat.setText("5000 Kg");
        holder.qty.setText("12");
        holder.total.setText("8000343");
//        holder.nama.setText(keuangan.getNama());
//        holder.berat.setText(keuangan.getBerat());
//        holder.qty.setText(keuangan.getQty());
//        holder.total.setText(keuangan.getTotal());
//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    @Override
    public int getItemCount() {
        return keuanganList.size();
    }
}

