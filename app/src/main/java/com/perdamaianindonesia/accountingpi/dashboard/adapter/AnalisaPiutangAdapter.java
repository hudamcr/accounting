package com.perdamaianindonesia.accountingpi.dashboard.adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.dashboard.model.Piutang;
import com.perdamaianindonesia.accountingpi.R;

import java.util.List;

public class AnalisaPiutangAdapter extends RecyclerView.Adapter<AnalisaPiutangAdapter.MyViewHolder> {

    private List<Piutang> piutangList;
    Context mCtx;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre,lihat;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.nama);
            genre = (TextView) view.findViewById(R.id.satuan);
            year = (TextView) view.findViewById(R.id.nominal);
            lihat = (TextView) view.findViewById(R.id.lihat);

        }
    }


    public AnalisaPiutangAdapter(Context mCtx,List<Piutang> piutangList) {
        this.piutangList = piutangList;
        this.mCtx = mCtx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_piutang, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Piutang piutang = piutangList.get(position);
        holder.title.setText(piutang.getNama());
        holder.genre.setText("Rp. ");
        holder.year.setText(piutang.getNominal());
        holder.lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_piutang();
            }
        });
//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    private void dialog_piutang() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(mCtx);
        LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_analisis_piutang, null);
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
        dialog.getWindow().setLayout(1850,LinearLayout.LayoutParams.WRAP_CONTENT);
        Window window = dialog.getWindow();
        window.setLayout(1850, LinearLayout.LayoutParams.WRAP_CONTENT);

    }

    @Override
    public int getItemCount() {
        return piutangList.size();
    }
}
