package org.d3ifcool.lop.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ActivityTestBinding;
import org.d3ifcool.lop.models.PersonalityQuestion;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private ActivityTestBinding binding;
    private int pos, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = 0;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        binding.setPosition(pos);
        binding.setQuestionLists(fetchData());
    }

    public void onChecked(View view) {
        Log.d("pilihan", view.getTag() + "");
    }

    /**
     * Fetch data from API server.
     * Get Personality Questions
     * @return ArrayList
     */
    public ArrayList<PersonalityQuestion> fetchData(){
        ArrayList<PersonalityQuestion> questions = new ArrayList<>();
        questions.add(new PersonalityQuestion("Memikirkan sekitar","Memikirkan diri sendiri", 0, 1));
        questions.add(new PersonalityQuestion("Memikirkan diri sendiri", "Memikirkan sekitar", 1, 0));
        questions.add(new PersonalityQuestion("Memikirkan sekitar","Memikirkan diri sendiri", 0, 1));
        questions.add(new PersonalityQuestion("Memikirkan diri sendiri", "Memikirkan sekitar", 1, 0));
        questions.add(new PersonalityQuestion("Memikirkan sekitar","Memikirkan diri sendiri", 0, 1));
        questions.add(new PersonalityQuestion("Memikirkan sekitar","Memikirkan diri sendiri", 1, 0));
        max = questions.size();
        return questions;
    }

    public void nextQuestion(View view) {
        if (pos < max-1) binding.setPosition(++pos);
        else {
            startActivity(new Intent(TestActivity.this, ResultActivity.class));
            finish();
        }
    }
}
