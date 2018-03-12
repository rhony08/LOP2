package org.d3ifcool.lop.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.adapters.ListAdapter;
import org.d3ifcool.lop.databinding.ActivityTargetBinding;
import org.d3ifcool.lop.models.Target;

import java.util.ArrayList;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTargetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_target);
        ListAdapter adapter = new ListAdapter(fetchData());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<Target> fetchData(){
        ArrayList<Target> questions = new ArrayList<>();
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        questions.add(new Target("Ini Id","Ini Target", "Selesaikan Target ini"));
        return questions;
    }
}
