package org.d3ifcool.lop.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import org.d3ifcool.lop.database.LopContract;
import org.d3ifcool.lop.database.LopDbHelper;
import org.d3ifcool.lop.models.Data;
import org.d3ifcool.lop.models.PersonalityQuestion;
import org.d3ifcool.lop.models.PersonalityType;
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

/**
 * JSON Handler will be use to parse JSON from API.
 */

public class JSONHandler {

    private Context mContext;

    public JSONHandler(Context mContext) {
        this.mContext = mContext;
    }

    public URL createUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) return jsonResponse;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
            if (inputStream != null) inputStream.close();
        }

        return jsonResponse;
    }

    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();

        if (inputStream != null){
            InputStreamReader streamReader = new InputStreamReader(inputStream,
                    Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(streamReader);
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public ArrayList<Data> parseJsonToData(String json, int type) {
        try {
            ArrayList<Data> datas = new ArrayList<>();
            ArrayList<Integer> indexData = new ArrayList<>();
            JSONArray array = new JSONArray(json);
            JSONObject jsonObject = null;
            for (int i = 0; i<array.length(); i++){
                int random = (int)(Math.random() * array.length());
                while (indexData.contains(random)){
                    random = (int)(Math.random() * array.length());
                }
                indexData.add(random);
                jsonObject = array.getJSONObject(random);
                String name = jsonObject.getString((type != 2) ? "name" : "title");
                String desc = jsonObject.getString("desc");
                if (type != 2) insertData(name, desc, 0, 0, -1, type);
                else {
                    int targetCondition = jsonObject.getInt("target");
                    int tipCondition = jsonObject.getInt("tips");
                    insertData(name, desc, targetCondition, tipCondition, -1, type);
                }
            }
            return datas;
        }catch (JSONException ex){
            Log.e("JSON", ex.toString());
        }
        return null;
    }

    public ArrayList<PersonalityQuestion> parseJsonToTestList(String json) {
        try {
            ArrayList<PersonalityQuestion> datas = new ArrayList<>();
            ArrayList<Integer> indexData = new ArrayList<>();
            JSONArray array = new JSONArray(json);
            JSONObject jsonObject = null;
            for (int i = 0; i<array.length(); i++){
                int random = (int)(Math.random() * array.length());
                while (indexData.contains(random)){
                    random = (int)(Math.random() * array.length());
                }
                indexData.add(random);
                jsonObject = array.getJSONObject(random);
                String option1 = jsonObject.getString("option1");
                String option2 = jsonObject.getString("option2");
                String value1 = jsonObject.getString("value1");
                String value2 = jsonObject.getString("value2");
                datas.add(new PersonalityQuestion(option1, option2, value1, value2));
            }
            return datas;
        }catch (JSONException ex){
            Log.e(null, ex.toString());
        }
        return null;
    }

    public PersonalityType parseJsonToPersonality(String json) {
        try {
            JSONArray array = new JSONArray(json);
            JSONObject jsonObject = null;
            jsonObject = array.getJSONObject(0);
            String type = jsonObject.getString("type");
            String name = jsonObject.getString("name");
            String desc = jsonObject.getString("desc");
            JSONArray characters = jsonObject.getJSONArray("character");
            String[] chars = new String[characters.length()];
            for (int i = 0; i < characters.length(); i++) {
                chars[i] = characters.getString(i);
            }
            return new PersonalityType("0", name, type, desc, chars);
        }catch (JSONException ex){
            Log.e(null, ex.toString());
        }
        return null;
    }

    private void insertData(String name, String desc, int targetCondition, int tipsCondition, int status, int type){
        LopDbHelper mDbHelper = new LopDbHelper(mContext);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LopContract.TargetEntry.COLUMN_TITLE, name);
        values.put(LopContract.TargetEntry.COLUMN_DESC, desc);
        values.put(LopContract.TargetEntry.COLUMN_STATUS, status);

        // Insert a new data into the provider.

        switch (type){
            case 0:
                mContext.getContentResolver().insert(LopContract.TipsEntry.CONTENT_URI, values);
                Log.d("Test", "Sukses");
                break;
            case 1:
                mContext.getContentResolver().insert(LopContract.TargetEntry.CONTENT_URI, values);
                break;
            case 2:
                values.put(LopContract.AchievesEntry.COLUMN_TARGET_CONDITION, targetCondition);
                values.put(LopContract.AchievesEntry.COLUMN_TIP_CONDITION, tipsCondition);
                mContext.getContentResolver().insert(LopContract.AchievesEntry.CONTENT_URI, values);
                break;
        }
    }
}
