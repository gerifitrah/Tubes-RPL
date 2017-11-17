package com.geeksquad.android.tubes.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.geeksquad.android.tubes.R;
import com.geeksquad.android.tubes.adapter.OrderRecycleAdapter;
import com.geeksquad.android.tubes.entity.Order;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] no_order,date_order;
    ArrayList<Order> arrayList = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        no_order = getResources().getStringArray(R.array.order_no);
        date_order = getResources().getStringArray(R.array.time_order);
        int i = 0;
        for (String no_ord : no_order){
            Order Order = new Order(no_ord,date_order[i]);
            arrayList.add(Order);
            i++;
        }

        adapter = new OrderRecycleAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
