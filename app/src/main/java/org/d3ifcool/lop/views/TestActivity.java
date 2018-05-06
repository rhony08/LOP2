package org.d3ifcool.lop.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ActivityTestBinding;
import org.d3ifcool.lop.loader.PersonalityQuestionLoader;
import org.d3ifcool.lop.models.PersonalityQuestion;

import java.util.List;

public class TestActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<PersonalityQuestion>>{

    private ActivityTestBinding binding;
    private final int introvert = 0;
    private final int sensing = 1;
    private final int thinking = 2;
    private final int judging = 3;
    private int[] chosed;
    /**
     * position = position of current question.
     * max =  maximum of questions
     */
    private int position, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = -1;
        chosed = new int[4];

        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        binding.setPosition(position);

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

    /**
     * Save option where user chosen.
     * It use to request result from chose data.
     */
    public void onChecked(View view) {
        Log.d("pilihan", view.getTag() + "");
        String tag = view.getTag().toString();
        switch (tag){
            case "i":{
                chosed[introvert]++;
                break;
            }
            case "e":{
                chosed[introvert]--;
                break;
            }
            case "s":{
                chosed[sensing]++;
                break;
            }
            case "n":{
                chosed[sensing]--;
                break;
            }
            case "t":{
                chosed[thinking]++;
                break;
            }
            case "f":{
                chosed[thinking]--;
                break;
            }
            case "j":{
                chosed[judging]++;
                break;
            }
            case "p":{
                chosed[judging]--;
                break;
            }
        }
    }

    /**
     * Set question to next
     * or go to next Activity if that is the last question.
     */
    public void nextQuestion(View view) {
        if (position < max-1) {
            if (binding.radio.getCheckedRadioButtonId() == -1){
                Toast.makeText(this, "Pilihan tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else{
                binding.setPosition(++position);
                binding.firstOption.setChecked(false);
                binding.secondOption.setChecked(false);
            }
        }
        else {
            StringBuilder personalityType = new StringBuilder();
            personalityType.append((chosed[introvert] >=0 )? "I" : "E");
            personalityType.append((chosed[sensing] >=0 )? "S" : "N");
            personalityType.append((chosed[thinking] >=0 )? "T" : "F");
            personalityType.append((chosed[judging] >=0 )? "J" : "P");

            SharedPreferences sharedPreferences = getSharedPreferences("lopApp", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("personality", personalityType.toString());
            editor.apply();
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

    @Override
    public Loader<List<PersonalityQuestion>> onCreateLoader(int id, Bundle args) {
        return new PersonalityQuestionLoader(this, "https://api.mlab.com/api/1/databases/alision/collections/personality_quizzes?apiKey=l7imVKimQnqNgWqfQ2ST-RpKZqmNBsZg&l=10");
    }

    @Override
    public void onLoadFinished(Loader<List<PersonalityQuestion>> loader, List<PersonalityQuestion> data) {
        binding.setQuestionLists(data);
        max = data.size();
        binding.setMax(max);
        position = 0;
        binding.setPosition(position);
    }

    @Override
    public void onLoaderReset(Loader<List<PersonalityQuestion>> loader) {
        binding.setQuestionLists(null);
        max = 0;
        binding.setMax(max);
        position = -1;
        binding.setPosition(position);
    }
}
