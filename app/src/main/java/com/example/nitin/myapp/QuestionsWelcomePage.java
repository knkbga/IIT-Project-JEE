package com.example.nitin.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.CheckBoxPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;

public class QuestionsWelcomePage extends AppCompatActivity {

    private Button startTest;
    private final String WebPageInstrCode ="<html><head> <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'> <link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'> </head><body style='height:300px;'> <style>.inst{padding-bottom: 2.3%;font-size:1.1em}</style> <div align='center' style='font-family: \"Open Sans\", sans-serif;height:16%;background-color:#0093ff;padding-top:3.2%;color:white;text-align: justify;text-align:center;margin-bottom:4%;font-size:1.2em'> Instructions </div><div class='container-fluid'> <div align= \"center\"> <div style='text-align:center;padding:3% 2%;font-family: \"Open Sans\";font-size:0.96em;color:rgba(0,0,0,0.5)'> Before you start here are 4 things to remember </div></div></div><div style='margin-left:-6%' class='container-fluid'> <div class='row' style='font-size:0.9em;padding-left:8%;text-align:justify;margin-top: 3%;'> <div class='inst col-xs-12 col-md-12 col-lg-12 col-sm-12'> <div class='col-xs-1 col-lg-1 col-md-1 col-sm-1'>1.</div><div class='col-xs-10 col-lg-10 col-md-10 col-sm-10'>You will get <b>only one attempt</b>. Please ensure that you have reliable internet and power for the whole duration of the test.</div></div><div class='inst col-xs-12 col-md-12 col-lg-12 col-sm-12'> <div class='col-xs-1 col-lg-1 col-md-1 col-sm-1'>2.</div><div class='col-xs-10 col-lg-10 col-md-10 col-sm-10'>You <b>cannot pause</b> the test.</div></div><div class='inst col-xs-12 col-md-12 col-lg-12 col-sm-12'> <div class='col-xs-1 col-lg-1 col-md-1 col-sm-1'>3.</div><div class='col-xs-10 col-lg-10 col-md-10 col-sm-10'><b>Evaluate all options carefully.</b> There may be more than one correct option</div></div><div class='inst col-xs-12 col-md-12 col-lg-12 col-sm-12'> <div class='col-xs-1 col-lg-1 col-md-1 col-sm-1'>4.</div><div class='col-xs-10 col-lg-10 col-md-10 col-sm-10'>This test has <b>negative marking.</b> You get <b>+4</b> marks for a correct answer and <b>-1</b> mark for a wrong answer.</div></div></div></div></body></html>";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_welcome_page);
/*
        WebView instr = (WebView)findViewById(R.id.webViewInstructions);
        instr.loadDataWithBaseURL("file:///android_res/drawable/",WebPageInstrCode, "text/html", "UTF-8", null);
        instr.setVerticalScrollBarEnabled(true);*/

        startTest = (Button) findViewById(R.id.startTestButton);

        startTest.setOnClickListener(new View.OnClickListener() {

            Intent myIntent = new Intent(QuestionsWelcomePage.this, MCQInstant.class);
            CheckBox check = (CheckBox) findViewById(R.id.checkBoxTerms);
            public void onClick(View v)
            {
                if(check.isChecked())
                {
                    startActivity(myIntent);
                }
                else
                {
                    new AlertDialog.Builder(QuestionsWelcomePage.this)
                        .setTitle("You Cannot Proceed")
                        .setMessage("First Confirm to the terms.")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {}
                        }).create().show();
                }
            }
        });
    }
}
