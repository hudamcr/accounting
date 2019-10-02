package com.perdamaianindonesia.accountingpi.penjualan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.perdamaianindonesia.accountingpi.R;
import com.perdamaianindonesia.accountingpi.penjualan.Model.SalesOrder;
import com.perdamaianindonesia.accountingpi.penjualan.SalesOrderLihatFragment;

import java.util.List;

public class SalesOrderHistoryAdapter extends RecyclerView.Adapter<SalesOrderHistoryAdapter.MyViewHolder> {

    private List<SalesOrder> salesorderList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView action,no_so,nama,alamat,tanggal,catatan;

        public MyViewHolder(View view) {
            super(view);
            action = view.findViewById(R.id.action);
            no_so = view.findViewById(R.id.no_so);
            nama = view.findViewById(R.id.nama);
            alamat = view.findViewById(R.id.alamat);
            tanggal = view.findViewById(R.id.tanggal);
            catatan = view.findViewById(R.id.catatan);
        }
    }


    public SalesOrderHistoryAdapter(Context context,List<SalesOrder> salesorderList) {
        this.salesorderList = salesorderList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_sales_order_history, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SalesOrder salesorder = salesorderList.get(position);
        holder.nama.setText(salesorder.getNama());
        holder.no_so.setText(salesorder.getNo_sales());
        holder.alamat.setText(salesorder.getAlamat());
        holder.tanggal.setText(salesorder.getTanggal());
        holder.catatan.setText(salesorder.getCatatan());
        holder.action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new SalesOrderLihatFragment();
                FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
//        holder.itemView.setBackgroundColor(Color.parseColor("#F1F1F9"));
//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    @Override
    public int getItemCount() {
        return salesorderList.size();
    }
}
