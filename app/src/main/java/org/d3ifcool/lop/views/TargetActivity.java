package org.d3ifcool.lop.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.adapters.ListViewAdapter;
import org.d3ifcool.lop.databinding.ActivityTargetBinding;
import org.d3ifcool.lop.models.Data;

import java.util.ArrayList;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTargetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_target);
        ListViewAdapter adapter = new ListViewAdapter(this,fetchData());
        binding.listItem.setAdapter(adapter);
    }

    /**
     * Fetch data from database where target have seen
     * (user chose to do it).
     * @return List
     */
    public ArrayList<Data> fetchData(){
        ArrayList<Data> questions = new ArrayList<>();
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 1));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 0));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 1));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 1));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 0));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 1));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 1));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 0));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 1));
        questions.add(new Data("Ini Id","Title of Target", "Description of Target", 2));
        return questions;
    }
}
