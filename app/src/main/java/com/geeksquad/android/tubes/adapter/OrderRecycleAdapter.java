package com.geeksquad.android.tubes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geeksquad.android.tubes.R;
import com.geeksquad.android.tubes.entity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 25/10/2017.
 */

public class OrderRecycleAdapter extends RecyclerView.Adapter<OrderRecycleAdapter.orderViewHolder> {

    private Context mContext;
    private List<Order> mOrders ;

    public OrderRecycleAdapter(Context mContext, List<Order> mOrders) {
        this.mContext = mContext;
        this.mOrders = mOrders;
    }

    @Override
    public orderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_order, parent, false);
        orderViewHolder orderViewHolder = new orderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(orderViewHolder holder, int position) {
        Order Order = mOrders.get(position);
        holder.noTable.setText("Meja " + Order.getNo_meja());
        holder.dateOrder.setText(Order.getTanggal());
        holder.items.setText(Order.getItems() + " items");

    }

    @Override
    public int getItemCount() {
        return mOrders.size();
    }

    public static class orderViewHolder extends RecyclerView.ViewHolder {
        TextView noTable, dateOrder, items;

        public orderViewHolder(View itemView) {
            super(itemView);
            noTable = itemView.findViewById(R.id.no_table);
            dateOrder = itemView.findViewById(R.id.date_order);
            items = itemView.findViewById(R.id.items);

        }
    }

    public void setFilter(List<Order> selectedFilms) {

        mOrders = new ArrayList<Order>();
        mOrders.addAll(selectedFilms);
        notifyDataSetChanged();
    }
}
