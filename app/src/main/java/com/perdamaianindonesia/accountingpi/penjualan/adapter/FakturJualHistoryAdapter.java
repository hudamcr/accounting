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
import com.perdamaianindonesia.accountingpi.penjualan.FakturJualHistoryFragment;
import com.perdamaianindonesia.accountingpi.penjualan.FakturJualLihatFragment;
import com.perdamaianindonesia.accountingpi.penjualan.Model.FakturJual;

import java.util.List;

public class FakturJualHistoryAdapter extends RecyclerView.Adapter<FakturJualHistoryAdapter.MyViewHolder> {

    private List<FakturJual> fakturjualList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView action,no_faktur,nama,alamat,no_faktur_pajak,tanggal,no_sj,termin;

        public MyViewHolder(View view) {
            super(view);
            action = view.findViewById(R.id.action);
            no_faktur=view.findViewById(R.id.no_faktur);
            no_sj = view.findViewById(R.id.no_sj);
            nama = view.findViewById(R.id.nama);
            alamat = view.findViewById(R.id.alamat);
            no_faktur_pajak = view.findViewById(R.id.no_faktur_pajak);
            tanggal = view.findViewById(R.id.tanggal);
            termin = view.findViewById(R.id.termin);
        }
    }


    public FakturJualHistoryAdapter(Context context,List<FakturJual> fakturjualList) {
        this.fakturjualList = fakturjualList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_faktur_jual_history, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FakturJual fakturjual = fakturjualList.get(position);
        holder.nama.setText(fakturjual.getNama());
        holder.no_sj.setText(fakturjual.getNo_surat_jalan());
        holder.alamat.setText(fakturjual.getAlamat());
        holder.no_faktur.setText(fakturjual.getNo_faktur());
        holder.no_faktur_pajak.setText(fakturjual.getNo_faktur_pajak());
        holder.tanggal.setText(fakturjual.getTanggal());
        holder.termin.setText(fakturjual.getTermin());
        holder.action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new FakturJualLihatFragment();
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
        return fakturjualList.size();
    }
}

