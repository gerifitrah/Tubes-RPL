package com.geeksquad.android.tubes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS on 25/10/2017.
 */

public class order_adapter extends RecyclerView.Adapter<order_adapter.orderViewHolder> {
    private ArrayList<order_item> arrayList = new ArrayList<order_item>();


    public order_adapter(ArrayList<order_item> arrayList){
        this.arrayList=arrayList;

    }
    @Override
    public orderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        orderViewHolder orderViewHolder = new orderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(orderViewHolder holder, int position) {
        order_item order_item = arrayList.get(position);
        holder.no_order.setText(order_item.getNo_order());
        holder.date_order.setText(order_item.getDate_order());

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
