package com.perdamaianindonesia.accountingpi;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//For expandable list view use BaseExpandableListAdapter
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> header; // header titles
    // Child data in format of header title, child title
    private HashMap<String, List<String>> child;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this.header = listDataHeader;
        this.child = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {

        // This will return the child
        return this.child.get(this.header.get(groupPosition)).get(
                childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        // Getting child text
        final String childText = (String) getChild(groupPosition, childPosition);
        // Inflating child layout and setting textview
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child, parent, false);
        }

        TextView child_text = (TextView) convertView.findViewById(R.id.child);
        TextView tanggal = (TextView) convertView.findViewById(R.id.tanggal);
        ImageView img_child=convertView.findViewById(R.id.img_child);
        if(childPosition==0){
            child_text.setText(childText);
            child_text.setTypeface(child_text.getTypeface(), Typeface.BOLD);
            child_text.setBackgroundColor(Color.parseColor("#F1F1F9"));
            tanggal.setBackgroundColor(Color.parseColor("#F1F1F9"));
            img_child.setBackgroundColor(Color.parseColor("#F1F1F9"));
        }
        if(childPosition==1){
            child_text.setText(childText);
            child_text.setTypeface(null, Typeface.NORMAL);
            child_text.setBackgroundColor(Color.parseColor("#F5f5f5"));
            tanggal.setBackgroundColor(Color.parseColor("#F5f5f5"));
            img_child.setBackgroundColor(Color.parseColor("#F5f5f5"));
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        // return children count
        return this.child.get(this.header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        // Get header position
        return this.header.get(groupPosition);
    }

    @Override
    public int getGroupCount() {

        // Get header size
        return this.header.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        // Getting header title
        String headerTitle = (String) getGroup(groupPosition);

        // Inflating header layout and setting text
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.header, parent, false);
        }

        TextView header_text = (TextView) convertView.findViewById(R.id.header);

        header_text.setText(headerTitle);
        ImageView img_header=convertView.findViewById(R.id.img_header);

        // If group is expanded then change the text into bold and change the
        // icon
        header_text.setBackgroundColor(Color.RED);
        img_header.setBackgroundColor(Color.RED);
        if (isExpanded) {
            header_text.setBackgroundColor(Color.RED);
            header_text.setTypeface(header_text.getTypeface(), Typeface.BOLD);
            img_header.setImageResource(R.mipmap.ic_right);
            img_header.setRotation(90);
            img_header.setBackgroundColor(Color.RED);
//            header_text.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_right, 0,0
//                    , 0);
        } else {
            header_text.setBackgroundColor(Color.RED);
            header_text.setTypeface(header_text.getTypeface(), Typeface.BOLD);
            img_header.setImageResource(R.mipmap.ic_right);
            img_header.setRotation(0);
            img_header.setBackgroundColor(Color.RED);
//            header_text.setCompoundDrawablesWithIntrinsicBounds(0, 0,
//                    R.mipmap.ic_right, 0);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}