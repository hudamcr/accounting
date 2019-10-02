package com.perdamaianindonesia.accountingpi.penjualan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.perdamaianindonesia.accountingpi.ExpendableActivity;
import com.perdamaianindonesia.accountingpi.R;
import com.perdamaianindonesia.accountingpi.penjualan.Model.MemoOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemoOrderAdapter extends RecyclerView.Adapter<MemoOrderAdapter.MyViewHolder> {

    private List<MemoOrder> memoorderList;
    private List<String> groupList = null;
    ExpandableListView expandableListView;
    private Map<String, List<String>> childListMap = null;
    Context mCtx;
    static int[] icon = { R.mipmap.ic_arrow_down, R.mipmap.ic_arrow_down};
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tanggal,nama_costumer, kode, nama,qty,detail;

        public MyViewHolder(View view) {
            super(view);
            tanggal = (TextView) view.findViewById(R.id.tanggal);
            nama = (TextView) view.findViewById(R.id.nama);
            nama_costumer=(TextView)view.findViewById(R.id.nama_costumer);
            kode = (TextView) view.findViewById(R.id.kode);
            qty = view.findViewById(R.id.qty);
            detail =view.findViewById(R.id.detail);
        }
    }


    public MemoOrderAdapter(Context mCtx,List<MemoOrder> memoorderList) {
        this.memoorderList = memoorderList;
        this.mCtx =mCtx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_memo_order, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MemoOrder memoorder = memoorderList.get(position);
        holder.tanggal.setText(memoorder.getTanggal());
        holder.nama.setText(memoorder.getNama());
        holder.nama_costumer.setText(memoorder.getNama_costumer());
        holder.kode.setText(memoorder.getKode());
        holder.qty.setText(memoorder.getQty());
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_pertanyaan();
            }
        });
//        if(position % 2 == 0){
//            holder.itemView.setBackgroundColor(Color.parseColor("#FFF5F5F5"));
//        }else{
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
    }

    private void dialog_pertanyaan() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(mCtx);
        LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_memo_order, null);
        builder.setView(dialogView);
        final android.support.v7.app.AlertDialog dialog = builder.create();
        ImageView image = dialogView.findViewById(R.id.imageXX);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        TextView textView=dialogView.findViewById(R.id.print);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx,"Print",Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView=dialogView.findViewById(R.id.simple_expandable_listview);
        setItems();


//        lama
        this.addUserInfo("Karet Gelang 999 10 Kg\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 18/09/2019",  "Pengiriman minimal berapa ke Tegal?\t\t\t\t\t\t\t\t\t\t\t\t18/09/2019", "50 Kg\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t18/09/2019");
        this.addUserInfo("Karet Gelang Bebek Putih - Kuning\t\t\t\t\t\t\t\t\t\t\t18/09/2019",  "Pengiriman minimal berapa ke Tegal?\t\t\t\t\t\t\t\t\t\t\t18/09/2019", "100 Kg\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t18/09/2019");
        ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getGroupCount() {
                return groupList.size();
            }

            @Override
            public int getChildrenCount(int groupIndex) {
                String group = groupList.get(groupIndex);
                List<String> childInfoList = childListMap.get(group);
                return childInfoList.size();
            }

            @Override
            public Object getGroup(int groupIndex) {
                return groupList.get(groupIndex);
            }

            @Override
            public Object getChild(int groupIndex, int childIndex) {
                String group = groupList.get(groupIndex);
                List<String> childInfoList = childListMap.get(group);
                return childInfoList.get(childIndex);
            }

            @Override
            public long getGroupId(int groupIndex) {
                return groupIndex;
            }

            @Override
            public long getChildId(int groupIndex, int childIndex) {
                return childIndex;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            // This method will return a View object displayed in group list item.
            @Override
            public View getGroupView(int groupIndex, boolean isExpanded, View view, ViewGroup viewGroup) {
                // Create the group view object.
                LinearLayout groupLayoutView = new LinearLayout(mCtx);
                groupLayoutView.setOrientation(LinearLayout.HORIZONTAL);
                groupLayoutView.setBackgroundColor(Color.RED);

                // Create and add an imageview in returned group view.
                ImageView groupImageView = new ImageView(mCtx);
                groupImageView.setBackgroundColor(Color.RED);
                if(isExpanded) {
                    groupImageView.setImageResource(R.mipmap.ic_right);
                    groupImageView.setRotation(90);
                    groupImageView.setBackgroundColor(Color.RED);
                }else
                {
                    groupImageView.setImageResource(R.mipmap.ic_right);
                    groupImageView.setBackgroundColor(Color.RED);
                }
                groupLayoutView.addView(groupImageView);

                // Create and add a textview in returned group view.
                String groupText = groupList.get(groupIndex);
                TextView groupTextView = new TextView(mCtx);
                groupTextView.setText(groupText);
                groupTextView.setTextSize(25);
                groupTextView.setTextColor(Color.WHITE);
                groupLayoutView.addView(groupTextView);

                return groupLayoutView;
            }

            // This method will return a View object displayed in child list item.
            @SuppressLint("ResourceAsColor")
            @Override
            public View getChildView(int groupIndex, int childIndex, boolean isLastChild, View view, ViewGroup viewGroup) {
                // First get child text/
                Object childObj = this.getChild(groupIndex, childIndex);
                String childText = (String)childObj;

                // Create a TextView to display child text.
                TextView childTextView = new TextView(mCtx);
                if(childIndex==0){
                    childTextView.setText(childText);
                    childTextView.setTextSize(20);
                    childTextView.setPadding(30,30,30,30);
                    childTextView.setBackgroundColor(Color.parseColor("#F1F1F9"));
                    childTextView.setTextColor(Color.parseColor("#474747"));
                    // Set child textview offset left. Then it will align to the right of the group image.
                    childTextView.setPadding(0,0,0,0);


                }
                if(childIndex==1){
                    childTextView.setText(childText);
                    childTextView.setTextSize(20);
                    childTextView.setBackgroundColor(Color.LTGRAY);
                    childTextView.setTextColor(Color.parseColor("#474747"));
                    childTextView.setPadding(30,30,30,30);
                    // Set child textview offset left. Then it will align to the right of the group image.
                    childTextView.setPadding(0,0,0,0);


                }

                return childTextView;
                // Get group image width.

            }

            @Override
            public boolean isChildSelectable(int groupIndex, int childIndex) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupIndex) {

            }

            @Override
            public void onGroupCollapsed(int groupIndex) {


            }

            @Override
            public long getCombinedChildId(long groupIndex, long childIndex) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupIndex) {
                return 0;
            }
        };

        final ExpandableListView exp_1=dialogView.findViewById(R.id.exp_1);
        exp_1.setAdapter(expandableListAdapter);
        exp_1.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupIndex) {
                // Get total group size.
                int groupListSize = groupList.size();

                // Close other expanded group.
                for(int i=0;i < groupListSize; i++) {
                    if(i!=groupIndex) {
                        exp_1.collapseGroup(i);
                    }
                }
            }
        });


        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(1500,LinearLayout.LayoutParams.WRAP_CONTENT);
        Window window = dialog.getWindow();
        window.setLayout(1200, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
    private void addUserInfo(String nama, String chat1, String chat2)
    {
        if(this.groupList == null)
        {
            this.groupList = new ArrayList<String>();
        }

        if(this.childListMap == null)
        {
            this.childListMap = new HashMap<String, List<String>>();
        }

        if(!this.groupList.contains(nama)) {
            this.groupList.add(nama);
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add( chat1);
        childList.add(chat2);
        // Add child data list in the map, key is group name.
        this.childListMap.put(nama, childList);
    }


    void setItems() {

        // Array list for header
        ArrayList<String> header = new ArrayList<String>();

        // Array list for child items
        List<String> child1 = new ArrayList<String>();
        List<String> child2 = new ArrayList<String>();

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding headers to list

        header.add("Karet gelang 19 Kg");
        header.add("Karet gelang 10 Kg");
        child1.add("Pengiriman Berapa Ke Tegal?");
        child1.add("Minimal 1 Pak");
        child2.add("Pengiriman Berapa Ke Tegal?");
        child2.add("Minimal 1 Ton");
        // Adding child data
//        for (int i = 1; i < 5; i++) {
//            child1.add("Group 1  - " + " : Child" + i);
//            child11.add("Group 1  - ");
//
//        }
//        // Adding child data
//        for (int i = 1; i < 5; i++) {
//            child2.add("Group 2  - " + " : Child" + i);
//
//        }

        // Adding header and childs to hash map
        hashMap.put(header.get(0), child1);
        hashMap.put(header.get(1), child2);

        com.perdamaianindonesia.accountingpi.ExpandableListAdapter adapter = new com.perdamaianindonesia.accountingpi.ExpandableListAdapter(mCtx, header, hashMap);

        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
    }


    @Override
    public int getItemCount() {
        return memoorderList.size();
    }
}

