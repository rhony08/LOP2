package org.d3ifcool.lop.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.adapters.ListViewAdapter;
import org.d3ifcool.lop.databinding.ActivityTargetBinding;
import org.d3ifcool.lop.models.Tips;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTargetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_target);
        ListViewAdapter adapter = new ListViewAdapter(this,fetchData());
        binding.listItem.setAdapter(adapter);
    }

    /**
     * Fetch data from database where tips have seen.
     * @return List
     */
    public ArrayList<Tips> fetchData(){
        ArrayList<Tips> questions = new ArrayList<>();
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        questions.add(new Tips("Ini Id","Title of Tips", "Description of Tips"));
        return questions;
    }
}
