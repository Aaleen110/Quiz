package com.quiz.project.quiz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by aaleen on 02/09/18.
 */

public class StageSelect extends AppCompatActivity {

    private Button mBtnStage1, mBtnStage2, mBtnStage3;
    private ImageView mSettings;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage_select_layout);

        mBtnStage1 = (Button) findViewById(R.id.btnStage1);
        mBtnStage2 = (Button) findViewById(R.id.btnStage2);
        mBtnStage3 = (Button) findViewById(R.id.btnStage3);
        mSettings = (ImageView) findViewById(R.id.settings);



        init();

        mBtnStage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StageSelect.this, Stage1.class);
                startActivity(intent);
            }
        });


        mBtnStage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StageSelect.this, "Complete stage 1 to unlock this stage", Toast.LENGTH_SHORT).show();
            }
        });

        mBtnStage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StageSelect.this, "Complete stage 2 to unlock this stage", Toast.LENGTH_SHORT).show();

            }
        });

        mSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                final Dialog dialog = new Dialog(StageSelect.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.settings);

                Switch switchMusic = dialog.findViewById(R.id.switchMusic);
                Switch switchSound = dialog.findViewById(R.id.switchSound);
                final ToggleButton btnDifficulty = dialog.findViewById(R.id.btnDifficulty);



               Boolean conditionMusic =  sharedPreferences.getBoolean("music_settings", true);
               Boolean conditionSound = sharedPreferences.getBoolean("sound_settings", true);


               if(conditionMusic){
                   switchMusic.setChecked(true);
               }else {
                   switchMusic.setChecked(false);
               }

                if(conditionSound){
                    switchSound.setChecked(true);
                }else {
                    switchSound.setChecked(false);
                }


                btnDifficulty.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                       String diffi =  btnDifficulty.getText().toString();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("difficulty", diffi);
                        editor.commit();
                    }
                });



                switchMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if(isChecked){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("music_settings", true);
                            editor.commit();
                            Intent svc = new Intent(StageSelect.this, MusicService.class);
                            startService(svc);
                        }
                        else{
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("music_settings", false);
                            editor.commit();
                            Intent svc = new Intent(StageSelect.this, MusicService.class);
                            stopService(svc);
                        }
                    }
                });


                switchSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                        if(check){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("sound_settings", true);
                            editor.commit();
//
                        }
                        else{
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("sound_settings", false);
                            editor.commit();

                        }
                    }
                });


                dialog.show();

            }
        });

    }

    private void init() {
        mBtnStage2.setTextColor(Color.LTGRAY);
        mBtnStage3.setTextColor(Color.LTGRAY);
         sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent svc = new Intent(StageSelect.this, MusicService.class);
        stopService(svc);
    }
}
