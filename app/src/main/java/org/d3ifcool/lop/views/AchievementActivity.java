package org.d3ifcool.lop.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.adapters.ListAdapter;
import org.d3ifcool.lop.adapters.ListViewAdapter;
import org.d3ifcool.lop.databinding.ActivityTargetBinding;
import org.d3ifcool.lop.models.Achievement;

import java.util.ArrayList;

public class AchievementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTargetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_target);
        ListViewAdapter adapter = new ListViewAdapter(this,fetchData());
        binding.listItem.setAdapter(adapter);
    }

    /**
     * Fetch data from database where achievement have unlocked
     * (user clear that).
     * @return List
     */
    public ArrayList<Achievement> fetchData(){
        ArrayList<Achievement> questions = new ArrayList<>();
        questions.add(new Achievement(0,"Title of Achievement", "Description of Achievement", 1, "bronze"));
        questions.add(new Achievement(1,"Title of Achievement", "Description of Achievement", 1, "gold"));
        questions.add(new Achievement(2,"Title of Achievement", "Description of Achievement", 1, "bronze"));
        questions.add(new Achievement(3,"Title of Achievement", "Description of Achievement", 1, "silver"));
        questions.add(new Achievement(4,"Title of Achievement", "Description of Achievement", 1, "silver"));
        questions.add(new Achievement(5,"Title of Achievement", "Description of Achievement", 1, "bronze"));
        return questions;
    }
}
