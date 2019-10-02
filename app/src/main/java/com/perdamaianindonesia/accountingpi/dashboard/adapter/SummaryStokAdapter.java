package com.perdamaianindonesia.accountingpi.dashboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.R;
import com.perdamaianindonesia.accountingpi.dashboard.model.Stok;

import java.util.List;

public class SummaryStokAdapter extends RecyclerView.Adapter<SummaryStokAdapter.MyViewHolder> {

    private List<Stok> stokList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama,stok, nominal, satuan;

        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.nama);
            stok = (TextView) view.findViewById(R.id.stok);
            satuan = (TextView) view.findViewById(R.id.satuan);
            nominal = (TextView) view.findViewById(R.id.nominal);
        }
    }


    public SummaryStokAdapter(List<Stok> stokList) {
        this.stokList = stokList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_stok, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Stok stok = stokList.get(position);
        holder.nama.setText(stok.getNama());
        holder.stok.setText(stok.getStok());
        holder.satuan.setText("Rp. ");
        holder.nominal.setText(stok.getNominal());
//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    @Override
    public int getItemCount() {
        return stokList.size();
    }
}
