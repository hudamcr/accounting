package com.perdamaianindonesia.accountingpi.penjualan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.R;
import com.perdamaianindonesia.accountingpi.penjualan.Model.Pelunasan;

import java.util.List;

public class PelunasanAdapter extends RecyclerView.Adapter<PelunasanAdapter.MyViewHolder> {

    private List<Pelunasan> pelunasanList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView no_invoice,kode,nama,jumlah,tanggal_jatuh_tempo,pelunasan;

        public MyViewHolder(View view) {
            super(view);
            no_invoice = view.findViewById(R.id.no_invoice);
            kode = view.findViewById(R.id.kode);
            nama = view.findViewById(R.id.nama);
            jumlah = view.findViewById(R.id.jumlah);
            tanggal_jatuh_tempo = view.findViewById(R.id.tanggal_jatuh_tempo);
            pelunasan = view.findViewById(R.id.pelunasan);
        }
    }


    public PelunasanAdapter(Context context,List<Pelunasan> pelunasanList) {
        this.pelunasanList = pelunasanList;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_pelunasan, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pelunasan pelunasan = pelunasanList.get(position);
        holder.no_invoice.setText(pelunasan.getNo_invoice());
        holder.kode.setText(pelunasan.getKode());
        holder.nama.setText(pelunasan.getNama());
        holder.jumlah.setText(pelunasan.getJumlah());
        holder.tanggal_jatuh_tempo.setText(pelunasan.getTanggal_jatuh_tempo());
        holder.pelunasan.setText(pelunasan.getPelunasan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_pelunasan();
            }
        });
//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    private void dialog_pelunasan() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_pelunasan, null);
        builder.setView(dialogView);
        final android.support.v7.app.AlertDialog dialog = builder.create();
        ImageView image = dialogView.findViewById(R.id.imageXX);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(1800,LinearLayout.LayoutParams.WRAP_CONTENT);
        Window window = dialog.getWindow();
        window.setLayout(1800, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public int getItemCount() {
        return pelunasanList.size();
    }
}