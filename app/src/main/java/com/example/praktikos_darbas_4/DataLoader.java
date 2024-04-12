package com.example.praktikos_darbas_4;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DataLoader extends AsyncTask<Void, Void, List<CurrencyItem>> {
    private final MainActivity mainActivity;
    private final ListView currencyList;
    private final String API_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    public DataLoader(MainActivity mainActivity, ListView currencyList){
        this.mainActivity = mainActivity;
        this.currencyList = currencyList;
    }

    @Override
    protected List<CurrencyItem> doInBackground(Void... currencyLists) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            return DataParser.parseXml(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(List<CurrencyItem> currencyItems) {
        if (currencyItems != null && !currencyItems.isEmpty()) {
            ArrayAdapter<CurrencyItem> adapter = new ArrayAdapter<>(mainActivity,
                    android.R.layout.simple_list_item_1, currencyItems);
            currencyList.setAdapter(adapter);
        } else {
            throw new RuntimeException();
        }
    }
}
