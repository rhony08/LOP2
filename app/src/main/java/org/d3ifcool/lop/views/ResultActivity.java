package org.d3ifcool.lop.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ActivityResultBinding;
import org.d3ifcool.lop.loader.PersonalityTypeLoader;
import org.d3ifcool.lop.models.PersonalityType;


public class ResultActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<PersonalityType>{

//    private boolean onLoad = false;
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result);

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();


        if (isConnected){
            getSupportLoaderManager().initLoader(1, null,this);
        }else{
            Toast.makeText(this, "Network unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    public void detailPersonality(View view) {
        Intent intent = new Intent(ResultActivity.this, DescActivity.class);
        intent.putExtra("personalityType", binding.getPersonalityType());
        startActivity(new Intent(ResultActivity.this, DescActivity.class));
        finish();
    }

    @Override
    public Loader<PersonalityType> onCreateLoader(int id, Bundle args) {
        SharedPreferences sharedPreferences = getSharedPreferences("lopApp", MODE_PRIVATE);
        String personality = sharedPreferences.getString("personality", null);
        String url = "https://api.mlab.com/api/1/databases/alision/collections/personality_types?apiKey=l7imVKimQnqNgWqfQ2ST-RpKZqmNBsZg&q={%22type%22:%22"+ personality +"%22}";
//        new DataLoader(this);
        return new PersonalityTypeLoader(this, url);
    }

    @Override
    public void onLoadFinished(Loader<PersonalityType> loader, PersonalityType data) {
        binding.setPersonalityType(data);
    }

    @Override
    public void onLoaderReset(Loader<PersonalityType> loader) {
        binding.setPersonalityType(new PersonalityType("id", "INTP", "Description of this Personality Type", "image", new String[0]));
    }
}
