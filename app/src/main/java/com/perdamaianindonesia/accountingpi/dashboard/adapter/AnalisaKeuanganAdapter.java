package com.perdamaianindonesia.accountingpi.dashboard.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.dashboard.model.Keuangan;
import com.perdamaianindonesia.accountingpi.R;

import java.util.List;

public class AnalisaKeuanganAdapter extends RecyclerView.Adapter<AnalisaKeuanganAdapter.MyViewHolder> {

    private List<Keuangan> keuanganList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.nama);
            genre = (TextView) view.findViewById(R.id.satuan);
            year = (TextView) view.findViewById(R.id.nominal);
        }
    }


    public AnalisaKeuanganAdapter(List<Keuangan> keuanganList) {
        this.keuanganList = keuanganList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_analisa_keuangan, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Keuangan keuangan = keuanganList.get(position);
        holder.title.setText(keuangan.getNama());
        holder.genre.setText("Rp. ");
        holder.year.setText(keuangan.getNominal());
        if(position % 2 == 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
        }else{
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return keuanganList.size();
    }
}
