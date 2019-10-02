package com.perdamaianindonesia.accountingpi.penjualan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.R;
import com.perdamaianindonesia.accountingpi.penjualan.Model.DaftarPiutang;

import java.util.List;

public class DaftarPiutangAdapter extends RecyclerView.Adapter<DaftarPiutangAdapter.MyViewHolder> {

    private List<DaftarPiutang> daftarpiutangList;
    Context mCtx;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView lihat, kode, nama,jumlah,status;

        public MyViewHolder(View view) {
            super(view);
            lihat = (TextView) view.findViewById(R.id.lihat);
            nama = (TextView) view.findViewById(R.id.nama);
            kode = (TextView) view.findViewById(R.id.kode);
            jumlah = view.findViewById(R.id.jumlah);
            status =view.findViewById(R.id.status);
        }
    }


    public DaftarPiutangAdapter(Context mCtx,List<DaftarPiutang> daftarpiutangList) {
        this.daftarpiutangList = daftarpiutangList;
        this.mCtx = mCtx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_daftar_piutang, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DaftarPiutang daftarpiutang = daftarpiutangList.get(position);
        holder.nama.setText(daftarpiutang.getNama());
        holder.kode.setText(daftarpiutang.getKode_pelanggan());
        holder.jumlah.setText(daftarpiutang.getJumlah());
        holder.status.setText(daftarpiutang.getStatus());
        holder.lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_daftat_piutang();
            }
        });

        if(daftarpiutang.getStatus()=="LANCAR"){

            holder.status.setTextColor(Color.parseColor("#31e920"));
        }
        else if(daftarpiutang.getStatus()=="MACET"){
            holder.status.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(daftarpiutang.getStatus()=="KURANG"){
            holder.status.setTextColor(Color.parseColor("#FFDC00"));
        }

//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    private void dialog_daftat_piutang() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(mCtx);
        LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_daftar_piutang, null);
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
        return daftarpiutangList.size();
    }
}
