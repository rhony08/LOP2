package org.d3ifcool.lop.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ActivityDescBinding;
import org.d3ifcool.lop.models.Character;
import org.d3ifcool.lop.models.PersonalityType;

public class DescActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDescBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_desc);
        binding.setPersonalityType(new PersonalityType("id", "INTP", "Description of this Personality Type",
                new Character(1,"Logician", "Innovative inventors with an unquenchable thirst for knowledge."), "image"));
    }

    public void skip(View view) {
        startActivity(new Intent(DescActivity.this, HomeActivity.class));
        finish();
    }
}
