package org.d3ifcool.lop.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.d3ifcool.lop.adapters.JSONHandler;
import org.d3ifcool.lop.models.PersonalityType;

import java.io.IOException;
import java.net.URL;

/**
 * Created by CHEVALIER-11 on 30-Apr-18.
 */

public class PersonalityTypeLoader extends AsyncTaskLoader<PersonalityType> {

    private String mUrl;

    public PersonalityTypeLoader(Context context, String mUrl) {
        super(context);
        this.mUrl = mUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public PersonalityType loadInBackground() {
        if (mUrl == null) return null;
        return fetchData(mUrl);
    }

    private PersonalityType fetchData(String stringUrl){
        JSONHandler jsonHandler = new JSONHandler(getContext());
        URL url = jsonHandler.createUrl(stringUrl);
        try {
            String json = jsonHandler.makeHttpRequest(url);
            return jsonHandler.parseJsonToPersonality(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
