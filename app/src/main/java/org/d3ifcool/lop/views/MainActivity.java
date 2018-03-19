package org.d3ifcool.lop.views;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//         Add Shared Preference here.
//         If data null, show activity.
//         Else intent to Home Activity.
        binding.setbirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(MainActivity.this, R.style.MyDatePickerTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        calendar.set(Calendar.YEAR, i);
                        calendar.set(Calendar.MONTH, i1);
                        calendar.set(Calendar.DAY_OF_MONTH, i2);
                        String date = calendar.get(Calendar.DAY_OF_MONTH) + "/" +
                                calendar.get(Calendar.MONTH) + "/" +
                                calendar.get(Calendar.DAY_OF_MONTH);
                        binding.setbirthdate.setText(date);
                        Date birth = calendar.getTime();
                        binding.setBirthday(birth);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void signIn(View view) {
        if (binding.name.getText().toString().isEmpty() || binding.getBirthday() == null){
            Toast.makeText(this, "Semua data harus terisi", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        Toast.makeText(this, "Berhasil masuk", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }
}
