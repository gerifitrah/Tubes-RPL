package com.geeksquad.android.tubes;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class login extends Activity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] no_order,date_order;
    ArrayList<order_item> arrayList = new ArrayList<order_item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        no_order = getResources().getStringArray(R.array.order_no);
        date_order = getResources().getStringArray(R.array.time_order);
        int i = 0;
        for (String no_ord : no_order){
            order_item order_item = new order_item(no_ord,date_order[i]);
            arrayList.add(order_item);
            i++;
        }

        adapter = new order_adapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
