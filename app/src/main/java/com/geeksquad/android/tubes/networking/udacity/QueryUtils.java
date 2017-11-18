package com.geeksquad.android.tubes.networking.udacity;

import android.text.TextUtils;
import android.util.Log;

import com.geeksquad.android.tubes.entity.Detail;
import com.geeksquad.android.tubes.entity.Order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */

final class QueryUtils {


    private static final String LOG_TAG = QueryUtils.class.getName();

    private QueryUtils() {
    }


    static List<Order> fetchData(String link) {

        URL url = parseStringLinkToURL(link);

        String jsonResponse = null;
        try {
            jsonResponse = httpConnectRequestJson(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error when closing input stream", e);
        }

        return extract(Order.DUMMY_RESPONSE);

    }


    private static String httpConnectRequestJson(URL url) throws IOException {

        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /*miliseconds*/);
            urlConnection.setConnectTimeout(150000 /*miliseconds*/);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = streamToSting(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code " + urlConnection.getResponseCode());
            }

        } catch (IOException e) {
            Log.e(LOG_TAG, "Error while retrieving jsonResponse", e);
        } finally {
            //close the url and input stream.. regardless exception thrown or not..
            if (urlConnection != null)
                urlConnection.disconnect();
            if (inputStream != null)
                inputStream.close();
        }

        return jsonResponse;
    }

    private static String streamToSting(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        if (inputStream != null) {
            InputStreamReader inputStreamReader =
                    new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        }
        return stringBuilder.toString();

    }


    private static URL parseStringLinkToURL(String link) {

        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating url", e);
        }
        return url;

    }


    private static List<Order> extract(String jason) {


        if (TextUtils.isEmpty(jason)) {
            return null;
        }

        List<Order> listOrders = new ArrayList<>();

        try {

            JSONArray root = new JSONArray(jason);

            for (int i = 0; i < root.length(); i++) {

                JSONObject orderNow = root.getJSONObject(i);
                int no_meja = orderNow.getInt("no_meja");
                String tanggal = orderNow.getString("tanggal");
                int items = orderNow.getInt("items");
                JSONArray detail = orderNow.getJSONArray("detail");
                List<Detail> details = new ArrayList<>();

                for (int j = 0; j < detail.length(); j++) {
                    JSONObject detailObject = detail.getJSONObject(j);
                    String produk = detailObject.getString("produk");
                    int qty = detailObject.getInt("qty");
                    details.add(new Detail(produk, qty));
                }

                String keterangan = orderNow.getString("keterangan") ;

                listOrders.add(new Order(no_meja,tanggal,keterangan,items,details)) ;
            }


        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return listOrders;
    }

}
