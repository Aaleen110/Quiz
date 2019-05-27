package com.quiz.project.quiz;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aaleen on 02/09/18.
 */

public class Stage1 extends AppCompatActivity {

    private Button mBtnReal, mBtnFake;
    private TextView questionText, mtxtStageTitle, mTxtTimer, mTxtLife, mTxtScore;
    private ImageView hint;
    private int question = 0;
    private int life = 3;
    private long score = 0;
    Boolean sounds;
    CountDownTimer countDownTimer;
    MediaPlayer correctAnswerTone, wrongAnswerTone, timesUpTone, outOfLivesTone, stageCompleteTone;



    private String [] questionsArray = {"http://www3.fb.com/",
                                        "http://ibank.barclays.dstonebank.com/",
                                        "http://amazon.co.uk/",
                                        "http://80:57:192:106/bankofmamerica.com/",
                                        "http://www.ucl.ac.uk/",
                                        "http://www.amazon.com.varzea.us/",
                                        "http://www.ebay.com.verification.co.uk/",
                                        "http://www.latam.citibank.com/uruguay/",};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage1_layout);

        mBtnReal = findViewById(R.id.btnReal);
        mBtnFake =  findViewById(R.id.btnFake);
        hint = findViewById(R.id.imgHint);
        questionText = (TextView) findViewById(R.id.questionText);
        mtxtStageTitle = (TextView) findViewById(R.id.txtStageTitle);
        mTxtTimer =  (TextView) findViewById(R.id.txtTimer);
        mTxtLife = (TextView) findViewById(R.id.txtLife);
        mTxtScore = (TextView) findViewById(R.id.txtScore);

         correctAnswerTone = MediaPlayer.create(this, R.raw.correct_answer);
         wrongAnswerTone = MediaPlayer.create(this, R.raw.wrong_answer);
         timesUpTone = MediaPlayer.create(this, R.raw.times_up);
         outOfLivesTone = MediaPlayer.create(this, R.raw.out_of_lives);
         stageCompleteTone = MediaPlayer.create(this, R.raw.stage_complete);


        SharedPreferences sharedPreferences = getSharedPreferences("Settings",0);
        String difficulty = sharedPreferences.getString("difficulty", "MEDIUM");
        sounds = sharedPreferences.getBoolean("sound_settings", true);


        if(difficulty=="MEDIUM"){

        }else{

        }

        mtxtStageTitle.setText("Stage 1."+(question+1));

        mTxtLife.setText(life+"");

        // n = 0 for 30 seconds and n = 1 for 15 seconds
        startTimer();



        mBtnReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mBtnReal.setBackgroundDrawable(getResources().getDrawable(R.drawable.correct_action));
//                mBtnReal.setTextColor(Color.WHITE);

                switch (question){
                    case 0:
                        wrongAnswer();
                        break;

                    case 1:
                        wrongAnswer();
                        break;

                    case 2:
                        rightAnswer();
                        break;

                    case 3:
                        wrongAnswer();
                        break;

                    case 4:
                        rightAnswer();
                        break;

                    case 5:
                        wrongAnswer();
                        break;

                    case 6:
                        wrongAnswer();
                        break;

                    case 7:
                        rightAnswer();
                        break;

                }

               // questionText.setText(questionsArray[question]);
            }
        });

        mBtnFake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mBtnFake.setBackgroundDrawable(getResources().getDrawable(R.drawable.incorrect_action));
               // mBtnFake.setTextColor(Color.WHITE);
               // question++;

                switch (question){
                    case 0:
                        rightAnswerFake();
                        break;

                    case 1:
                        rightAnswerFake();
                        break;

                    case 2:
                        wrongAnswerFake();
                        break;

                    case 3:
                        rightAnswerFake();
                        break;

                    case 4:
                        wrongAnswerFake();
                        break;

                    case 5:
                        rightAnswerFake();
                        break;

                    case 6:
                        rightAnswerFake();
                        break;

                    case 7:
                        wrongAnswerFake();
                        break;

                }

               // questionText.setText(questionsArray[question]);
            }
        });

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(Stage1.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.hint_dialog_view);

                TextView cancelDialog  = dialog.findViewById(R.id.cancelDialog);

                cancelDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private void wrongAnswer() {

        if(sounds){
        wrongAnswerTone.start();
        }
        life--;
        mTxtLife.setText(life+"");
        mBtnReal.setBackgroundDrawable(getResources().getDrawable(R.drawable.incorrect_action));
        mBtnReal.setTextColor(Color.WHITE);
        question++;
        if (question<7) {
            questionText.setText(questionsArray[question]);
        }else{
            showCongratsDialog();
        }
        resetButton();
        mtxtStageTitle.setText("Stage 1."+(question+1));

        if (life==0){
           showOutOfLivesDialog();
            countDownTimer.cancel();

        }
    }

    private void rightAnswer(){
        if (sounds) {
            correctAnswerTone.start();
        }
        mBtnReal.setBackgroundDrawable(getResources().getDrawable(R.drawable.correct_action));
        mBtnReal.setTextColor(Color.WHITE);
        question++;
        score = score+100;
        mTxtScore.setText(score+"");

        if (question<7) {
            questionText.setText(questionsArray[question]);
        }
        else{

            showCongratsDialog();
        //finish();
        }
        resetButton();

        mtxtStageTitle.setText("Stage 1."+(question+1));
    }

    private void wrongAnswerFake() {
        if (sounds){
        wrongAnswerTone.start();
        }
        life--;
        mTxtLife.setText(life+"");
        mBtnFake.setBackgroundDrawable(getResources().getDrawable(R.drawable.incorrect_action));
        mBtnFake.setTextColor(Color.WHITE);
        question++;

        if (question<7) {
            questionText.setText(questionsArray[question]);
        }else{
            showCongratsDialog();
        }

        resetButton();
        mtxtStageTitle.setText("Stage 1."+(question+1));

        if (life==0){
            showOutOfLivesDialog();
            countDownTimer.cancel();

        }
    }


    private void rightAnswerFake(){
        if(sounds) {
            correctAnswerTone.start();
        }
        mBtnFake.setBackgroundDrawable(getResources().getDrawable(R.drawable.correct_action));
        mBtnFake.setTextColor(Color.WHITE);
        question++;
        score = score+100;
        mTxtScore.setText(score+"");

        if (question<7) {
            questionText.setText(questionsArray[question]);
        }else{
            showCongratsDialog();
        }

        resetButton();
        mtxtStageTitle.setText("Stage 1."+(question+1));
    }

    private void resetButton(){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        mBtnFake.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_button_white));
                        mBtnFake.setTextColor(Color.parseColor("#9B19E7"));

                        mBtnReal.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_button_white));
                        mBtnReal.setTextColor(Color.parseColor("#9B19E7"));
                    }
                },
                500);

    }

    private void showCongratsDialog(){
        if (sounds){
        stageCompleteTone.start();
        }
        countDownTimer.cancel();
        final Dialog dialog = new Dialog(Stage1.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.congrats_dialog);

        TextView btnNext  = dialog.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }


    private void showTimeupDialog(){
        if (sounds) {
            timesUpTone.start();
        }
        final Dialog dialog = new Dialog(Stage1.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.timeup_dialog);

        TextView btnTimeUp  = dialog.findViewById(R.id.btnTimeUpSubmit);

        btnTimeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }

    private void showOutOfLivesDialog(){
        if (sounds){
        outOfLivesTone.start();
        }
        final Dialog dialog = new Dialog(Stage1.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.outoflives_dialog);

        TextView btnOutOfLives  = dialog.findViewById(R.id.btnOutOfLives);

        btnOutOfLives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }

    private void startTimer(){


        //30 seconds timer
       countDownTimer = new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTxtTimer.setText(millisUntilFinished/1000+"");
            }

            public void onFinish() {
                mTxtTimer.setText(0+"");
                showTimeupDialog();
                //life--;
               // mTxtLife.setText(life+"");

            }

        }.start();


    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }
}
