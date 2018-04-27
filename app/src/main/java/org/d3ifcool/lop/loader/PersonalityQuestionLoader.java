package org.d3ifcool.lop.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.d3ifcool.lop.models.Data;
import org.d3ifcool.lop.adapters.JSONHandler;
import org.d3ifcool.lop.models.PersonalityQuestion;

/**
 * Created by CHEVALIER-11 on 25-Apr-18.
 */

public class PersonalityQuestionLoader extends AsyncTaskLoader<List<PersonalityQuestion>> {


    private String mUrl;

    public PersonalityQuestionLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List loadInBackground() {
        if (mUrl == null) return null;
        return fetchDataQuestions(mUrl);
    }

    private List<PersonalityQuestion> fetchDataQuestions(String stringUrl){
        JSONHandler jsonHandler = new JSONHandler(getContext());
        URL url = jsonHandler.createUrl(stringUrl);
        try {
            String json = jsonHandler.makeHttpRequest(url);
            return jsonHandler.parseJsonToTestList(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
