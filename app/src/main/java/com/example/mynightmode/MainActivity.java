package com.example.mynightmode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    SwitchCompat switchCompat;
    SharedPreferences sharedPreferences=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= findViewById(R.id.img);
        switchCompat= findViewById(R.id.swich);

        sharedPreferences = getSharedPreferences("night",0);
        Boolean boolenvalue= sharedPreferences.getBoolean("night mode",true);
        if (boolenvalue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchCompat.setChecked(true);
            imageView.setImageResource(R.drawable.day);
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    switchCompat.setChecked(true);
                    imageView.setImageResource(R.drawable.day);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("night mode",true);
                    editor.commit();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    switchCompat.setChecked(false);
                    imageView.setImageResource(R.drawable.night);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("night mode",false);
                    editor.commit();

                }
            }
        });
    }
}