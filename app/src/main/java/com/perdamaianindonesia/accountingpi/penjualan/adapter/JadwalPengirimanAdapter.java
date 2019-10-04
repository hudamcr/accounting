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
import com.perdamaianindonesia.accountingpi.penjualan.JadwalPengirimanLihatFragment;
import com.perdamaianindonesia.accountingpi.penjualan.Model.JadwalPengiriman;

import java.util.List;

public class JadwalPengirimanAdapter extends RecyclerView.Adapter<JadwalPengirimanAdapter.MyViewHolder> {

    private List<JadwalPengiriman> jadwalpengirimanList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView detail,no_sj,nama,driver,waktu,keterangan;
        public MyViewHolder(View view) {
            super(view);
            detail = view.findViewById(R.id.detail);
            no_sj = view.findViewById(R.id.no_sj);
            nama = view.findViewById(R.id.nama);
            driver = view.findViewById(R.id.driver);
            waktu = view.findViewById(R.id.waktu);
            keterangan = view.findViewById(R.id.keterangan);
        }
    }


    public JadwalPengirimanAdapter(Context context,List<JadwalPengiriman> jadwalpengirimanList) {
        this.jadwalpengirimanList = jadwalpengirimanList;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_jadwal_pengiriman, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        JadwalPengiriman jadwalpengiriman = jadwalpengirimanList.get(position);
        holder.nama.setText(jadwalpengiriman.getNama());
        holder.no_sj.setText(jadwalpengiriman.getNo_surat_jalan());
        holder.driver.setText(jadwalpengiriman.getDriver());
        holder.waktu.setText(jadwalpengiriman.getWaktu());
        holder.keterangan.setText(jadwalpengiriman.getKeterangan());
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new JadwalPengirimanLihatFragment();
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
        return jadwalpengirimanList.size();
    }
}

