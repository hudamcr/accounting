package com.perdamaianindonesia.accountingpi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.perdamaianindonesia.accountingpi.penjualan.MyListAdapter;

public class ExpendableActivity extends AppCompatActivity {

    private MyListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Continent> continentList = new ArrayList<Continent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expendable);

        //display the list
        displayList();
        //expand all Groups
        expandAll();

    }
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            myList.expandGroup(i);
        }
    }

    //method to expand all groups
    private void displayList() {

        //display the list
        loadSomeData();

        //get reference to the ExpandableListView
        myList = (ExpandableListView) findViewById(R.id.expandableList);
        //create the adapter by passing your ArrayList data
        listAdapter = new MyListAdapter(getApplicationContext(), continentList);
        //attach the adapter to the list
        myList.setAdapter(listAdapter);

    }

    private void loadSomeData() {

        ArrayList<Country> countryList = new ArrayList<Country>();
        Country country = new Country("BMU","Bermuda",10000000);
        countryList.add(country);
        country = new Country("CAN","Canada",20000000);
        countryList.add(country);
        country = new Country("USA","United States",50000000);
        countryList.add(country);

        Continent continent = new Continent("North America",countryList);
        continentList.add(continent);

        countryList = new ArrayList<Country>();
        country = new Country("CHN","China",10000100);
        countryList.add(country);
        country = new Country("JPN","Japan",20000200);
        countryList.add(country);
        country = new Country("THA","Thailand",50000500);
        countryList.add(country);

        continent = new Continent("Asia",countryList);
        continentList.add(continent);

    }

}