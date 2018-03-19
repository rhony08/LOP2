package org.d3ifcool.lop.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
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
    /**
     * position = position of current question.
     * max =  maximum of questions
     */
    private int position, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = 0;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        binding.setPosition(position);
        binding.setQuestionLists(fetchData());
    }

    /**
     * Save option where user chosen.
     * It use to request result from chose data.
     */
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
        binding.setMax(max);
        return questions;
    }

    /**
     * Set question to next
     * or go to next Activity if that is the last question.
     */
    public void nextQuestion(View view) {
        if (position < max-1) binding.setPosition(++position);
        else {
            startActivity(new Intent(TestActivity.this, ResultActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Application")
                .setMessage("Are you sure you want to close this activity?" +
                        "Test progress won't save.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
