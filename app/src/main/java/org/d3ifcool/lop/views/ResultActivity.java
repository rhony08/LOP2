package org.d3ifcool.lop.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ActivityResultBinding;
import org.d3ifcool.lop.models.Character;
import org.d3ifcool.lop.models.PersonalityType;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        binding.setPersonalityType(new PersonalityType("id", "INTP", "Description of this Personality Type",
                new Character("1","Logician", "Innovative inventors with an unquenchable thirst for knowledge."), "image"));
    }

    public void detailPersonality(View view) {
        startActivity(new Intent(ResultActivity.this, DescActivity.class));
        finish();
    }
}
