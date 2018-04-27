package org.d3ifcool.lop.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ActivityResultBinding;
import org.d3ifcool.lop.loader.DataLoader;
import org.d3ifcool.lop.models.Character;
import org.d3ifcool.lop.models.Data;
import org.d3ifcool.lop.models.PersonalityType;

import java.util.List;

public class ResultActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<List<Data>>{

//    private boolean onLoad = false;
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        binding.setPersonalityType(new PersonalityType("id", "INTP", "Description of this Personality Type",
                new Character(1,"Logician", "Innovative inventors with an unquenchable thirst for knowledge."), "image"));
//        binding.floatingActionButton.setClickable(onLoad);

        getSupportLoaderManager().initLoader(1, null, this);
    }

    public void detailPersonality(View view) {
        startActivity(new Intent(ResultActivity.this, DescActivity.class));
        finish();
    }

    @Override
    public Loader<List<Data>> onCreateLoader(int id, Bundle args) {
        return new DataLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Data>> loader, List<Data> data) {
//        onLoad = true;
//        binding.floatingActionButton.setClickable(onLoad);
        Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoaderReset(Loader<List<Data>> loader) {
        // do nothing
    }
}
