package com.geeksquad.android.tubes.networking.udacity;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.geeksquad.android.tubes.activity.MainActivity;
import com.geeksquad.android.tubes.entity.Order;

import java.util.List;

import retrofit2.Call;


/**
 * Created by GOODWARE1 on 8/30/2017.
 */

public class OrderLoader extends AsyncTaskLoader<List<Order>> {


    private String mUrl;
    Call<List<Order>> mCall;

    public OrderLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        if (MainActivity.mOrders == null)
            forceLoad();
    }

    @Override
    public List<Order> loadInBackground() {
        return QueryUtils.fetchData(mUrl) ;
    }

}