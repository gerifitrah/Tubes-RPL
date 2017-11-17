package com.geeksquad.android.tubes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geeksquad.android.tubes.R;
import com.geeksquad.android.tubes.entity.Order;

import java.util.ArrayList;

/**
 * Created by ASUS on 25/10/2017.
 */

public class OrderRecycleAdapter extends RecyclerView.Adapter<OrderRecycleAdapter.orderViewHolder> {
    private ArrayList<Order> arrayList = new ArrayList<Order>();


    public OrderRecycleAdapter(ArrayList<Order> arrayList){
        this.arrayList=arrayList;

    }
    @Override
    public orderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_order,parent,false);
        orderViewHolder orderViewHolder = new orderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(orderViewHolder holder, int position) {
        Order Order = arrayList.get(position);
        holder.no_order.setText(Order.getmOrderNumber());
        holder.date_order.setText(Order.getDate_order());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class orderViewHolder extends RecyclerView.ViewHolder{
        TextView no_order,date_order;

        public orderViewHolder(View itemView) {
            super(itemView);
            no_order = (TextView) itemView.findViewById(R.id.no_order);
            date_order = (TextView) itemView.findViewById(R.id.tgl_order);
        }
    }
}
