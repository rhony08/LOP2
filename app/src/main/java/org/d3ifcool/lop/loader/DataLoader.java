package org.d3ifcool.lop.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.d3ifcool.lop.adapters.JSONHandler;
import org.d3ifcool.lop.models.Data;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * List data loader.
 */

public class DataLoader extends AsyncTaskLoader<List<Data>> {

    private static final String mUrlTarget = "https://api.mlab.com/api/1/databases/alision/collections/targets?apiKey=l7imVKimQnqNgWqfQ2ST-RpKZqmNBsZg";
    private static final String mUrlTip = "https://api.mlab.com/api/1/databases/alision/collections/tips?apiKey=l7imVKimQnqNgWqfQ2ST-RpKZqmNBsZg";
    private static final String mUrlAchieve = "https://api.mlab.com/api/1/databases/alision/collections/achievements?apiKey=l7imVKimQnqNgWqfQ2ST-RpKZqmNBsZg";

    public DataLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Data> loadInBackground() {
        fetchData(mUrlTip, 0);
        fetchData(mUrlAchieve, 2);
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
