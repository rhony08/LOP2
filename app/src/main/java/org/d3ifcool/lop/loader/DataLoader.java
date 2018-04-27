package org.d3ifcool.lop.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.d3ifcool.lop.adapters.JSONHandler;
import org.d3ifcool.lop.models.Data;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by CHEVALIER-11 on 25-Apr-18.
 */

public class DataLoader extends AsyncTaskLoader<List<Data>> {
    private int mType;

    private static final String mUrlTarget = "https://api.mlab.com/api/1/databases/alision/collections/targets?apiKey=l7imVKimQnqNgWqfQ2ST-RpKZqmNBsZg&l=5";
    private static final String mUrlTip = "https://api.mlab.com/api/1/databases/alision/collections/tips?apiKey=l7imVKimQnqNgWqfQ2ST-RpKZqmNBsZg&l=5";

    public DataLoader(Context context) {
        super(context);
//        this.mType = mType;
//        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Data> loadInBackground() {
        fetchData(mUrlTip, 0);
        return fetchData(mUrlTarget, 1);
    }

    private List<Data> fetchData(String stringUrl, int type){
        JSONHandler jsonHandler = new JSONHandler(getContext());
        URL url = jsonHandler.createUrl(stringUrl);
        try {
            String json = jsonHandler.makeHttpRequest(url);
            return jsonHandler.parseJsonToData(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
