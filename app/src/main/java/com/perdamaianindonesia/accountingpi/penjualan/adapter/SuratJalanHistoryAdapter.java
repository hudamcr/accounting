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
import com.perdamaianindonesia.accountingpi.penjualan.Model.SuratJalan;
import com.perdamaianindonesia.accountingpi.penjualan.SalesOrderLihatFragment;
import com.perdamaianindonesia.accountingpi.penjualan.SuratJalanAddFragment;
import com.perdamaianindonesia.accountingpi.penjualan.SuratJalanEditFragment;
import com.perdamaianindonesia.accountingpi.penjualan.SuratJalanLihatFragment;

import java.util.List;

public class SuratJalanHistoryAdapter extends RecyclerView.Adapter<SuratJalanHistoryAdapter.MyViewHolder> {

    private List<SuratJalan> suratjalanList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView lihat,no_sj,nama,alamat,tanggal;

        public MyViewHolder(View view) {
            super(view);
            lihat = view.findViewById(R.id.lihat);
            no_sj = view.findViewById(R.id.no_sj);
            nama = view.findViewById(R.id.nama);
            alamat = view.findViewById(R.id.alamat);
            tanggal = view.findViewById(R.id.tanggal);
        }
    }


    public SuratJalanHistoryAdapter(Context context,List<SuratJalan> suratjalanList) {
        this.suratjalanList = suratjalanList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_surat_jalan_history, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SuratJalan suratjalan = suratjalanList.get(position);
        holder.nama.setText(suratjalan.getNama());
        holder.no_sj.setText(suratjalan.getNo_surat_jalan());
        holder.alamat.setText(suratjalan.getAlamat());
        holder.tanggal.setText(suratjalan.getTanggal());
        holder.lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new SuratJalanLihatFragment();
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
        return suratjalanList.size();
    }
}

