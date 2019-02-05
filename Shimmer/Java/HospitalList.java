package com.mab.notificationtest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HospitalList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Hospital> mDataSet = new ArrayList<Hospital>();
    private CustomAdapter mAdapter;
    String name[] = {"Fortis Hiranandani Hospital","Palm Baech Hospital","Vinamra Swaraj Hospital","Mahavir Hospital"};
    String Distance[] = {"1.4 km","1.8 km","2.2 km","4.5 km"};
    String Rating[] = {"4.0","3.9","4.5","4.8"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.hasFixedSize();
        mAdapter = new CustomAdapter(mDataSet,this, HospitalList.this);
        mRecyclerView.setAdapter(mAdapter);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
                mAdapter.showshimmer = false;
                mAdapter.notifyDataSetChanged();
            }
        },5000);
    }
    private void loadData(){
        for(int i = 0 ; i < name.length; i++){
            Hospital t = new Hospital(name[i],Rating[i],Distance[i]);
            mDataSet.add(t);
        }
        mAdapter.refresh(mDataSet);
        mRecyclerView.setAdapter(mAdapter);
    }
}
