package com.perdamaianindonesia.accountingpi.penjualan.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.R;
import com.perdamaianindonesia.accountingpi.penjualan.FakturJualLihatFragment;
import com.perdamaianindonesia.accountingpi.penjualan.Model.ReturPenjualan;
import com.perdamaianindonesia.accountingpi.penjualan.ReturPenjualanAddFragment;
import com.perdamaianindonesia.accountingpi.penjualan.ReturPenjualanEditFragment;
import com.perdamaianindonesia.accountingpi.penjualan.ReturPenjualanLihatFragment;

import java.util.List;

public class ReturPenjualanAdapter extends RecyclerView.Adapter<ReturPenjualanAdapter.MyViewHolder> {

    private List<ReturPenjualan> returpenjualanList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView edit,lihat,tanggal,kode,nama,banyak,satuan;

        public MyViewHolder(View view) {
            super(view);
            edit = view.findViewById(R.id.edit);
            lihat = view.findViewById(R.id.lihat);
            tanggal = view.findViewById(R.id.tanggal);
            kode = view.findViewById(R.id.kode);
            nama = view.findViewById(R.id.nama);
            banyak = view.findViewById(R.id.banyak);
            satuan =view.findViewById(R.id.satuan);
        }
    }


    public ReturPenjualanAdapter(Context context,List<ReturPenjualan> returpenjualanList) {
        this.returpenjualanList = returpenjualanList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_formulir_retur_penjualan, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ReturPenjualan returpenjualan = returpenjualanList.get(position);
        holder.tanggal.setText(returpenjualan.getTanggal());
        holder.kode.setText(returpenjualan.getKode());
        holder.nama.setText(returpenjualan.getNama());
        holder.banyak.setText(returpenjualan.getBanyak());
        holder.satuan.setText(returpenjualan.getSatuan());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returpenjualanList.clear();
                Fragment newFragment = new ReturPenjualanEditFragment();
                FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
        holder.lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returpenjualanList.clear();
                Fragment newFragment = new ReturPenjualanLihatFragment();
                FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    @Override
    public int getItemCount() {
        return returpenjualanList.size();
    }
}
