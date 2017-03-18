package com.example.nitin.myapp;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import questionTypes.MultipleChoice;
import questionTypes.Numericals;
import questionTypes.SingleChoice;

class shuffle<T>
{
    T ar[];
    shuffle(T ar[])
    {
        this.ar=ar;
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public T[] shuffle_elements()
    {
        Random rnd = new Random();
        for (int i = this.ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            T a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
}

public class MCQInstant extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    /*
    ************* OTHER FUNCTIONS *************
     */

    // Function to change the type of options corresponding to the type of question
    private void ChangeWebContent()
    {
        switch(this.typeOfQuestion)
        {
            case 0://Single Correct
            {
                htmlTextView.loadDataWithBaseURL("file:///android_res/drawable/", preQues + sampleQuestions.singleChoice[mCurrentIndex].getQuestion() + postQues, "text/html", "UTF-8", null);
            }
            break;
            case 1://Multiple Correct
            {
                htmlTextView.loadDataWithBaseURL("file:///android_res/drawable/", preQues + sampleQuestions.multipleChoice[mCurrentIndex].getQuestion() + postQues, "text/html", "UTF-8", null);
            }
            break;
            case 2://Numerical
            {
                htmlTextView.loadDataWithBaseURL("file:///android_res/drawable/", preQues + sampleQuestions.numericals[mCurrentIndex].getQuestion() + postQues, "text/html", "UTF-8", null);
            }
            break;
        }

        this.ChangeLayoutTo();
    }
    private void ChangeLayoutTo()
    {
        //Hiding all types of options and then selecting the one to be displayed
        SingleCorrectOptions.setVisibility(View.GONE);
        multiple1.setVisibility(View.GONE);
        multiple2.setVisibility(View.GONE);
        multiple3.setVisibility(View.GONE);
        multiple4.setVisibility(View.GONE);
        NumericalsOptions.setVisibility(View.GONE);

        switch(this.typeOfQuestion)
        {
            case 0:
            {
                SingleCorrectOptions.setVisibility(View.VISIBLE);
            }
            break;
            case 1:
            {
                multiple1.setVisibility(View.VISIBLE);
                multiple2.setVisibility(View.VISIBLE);
                multiple3.setVisibility(View.VISIBLE);
                multiple4.setVisibility(View.VISIBLE);
            }
            break;
            case 2:
            {
                NumericalsOptions.setVisibility(View.VISIBLE);
            }
            break;
        }
    }
    private void HideAll()
    {
        this.single1.setChecked(false);
        this.single2.setChecked(false);
        this.single3.setChecked(false);
        this.single4.setChecked(false);

        this.singleHidden.setChecked(true);

        this.multiple1.setChecked(false);
        this.multiple2.setChecked(false);
        this.multiple3.setChecked(false);
        this.multiple4.setChecked(false);

        this.NumericalsOptions.setText("");
    }
    private void SelectUserSelectedOption()
    {
        HideAll();

        switch (this.typeOfQuestion)
        {
            case 0://For Single Choice
            {
                if (this.userSelectedOptions.singleCorrect[mCurrentIndex] != 0) {//Indicating not blank...
                    switch (this.userSelectedOptions.singleCorrect[mCurrentIndex]) {// Which one...
                        case 1: {
                            this.single1.setChecked(true);
                        }
                        break;
                        case 2: {
                            this.single2.setChecked(true);
                        }
                        break;
                        case 3: {
                            this.single3.setChecked(true);
                        }
                        break;
                        case 4: {
                            this.single4.setChecked(true);
                        }
                        break;
                    }
                }
            }
            break;
            case 1:// For Multiple Choice
            {
                if(this.userSelectedOptions.multipleCorrect[mCurrentIndex] != null)
                {
                    Iterator it = userSelectedOptions.multipleCorrect[mCurrentIndex].iterator();
                    while (it.hasNext()) {
                        int x = (int) it.next();
                        switch (x) {
                            case 1: {
                                this.multiple1.setChecked(true);
                            }
                            break;
                            case 2: {
                                this.multiple2.setChecked(true);
                            }
                            break;
                            case 3: {
                                this.multiple3.setChecked(true);
                            }
                            break;
                            case 4: {
                                this.multiple4.setChecked(true);
                            }
                            break;
                        }
                    }
                }
            }
            break;
            case 2:
            {
                if(this.userSelectedOptions.numericals[mCurrentIndex]!=null)
                    NumericalsOptions.setText(userSelectedOptions.numericals[mCurrentIndex]);
            }
        }
    }
    private void addToSingle(int optionNumber)
    {
        single1.setChecked(false);
        single2.setChecked(false);
        single3.setChecked(false);
        single4.setChecked(false);
    }
    // Prompt values (for debugging purposes)
    private void showValue(String label,String value)
    {
        new AlertDialog.Builder(MCQInstant.this)
            .setTitle(label)
            .setMessage(value)
            .setCancelable(false)
            .setPositiveButton("ok", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {}
            }).create().show();
    }
    private void updateScreen()
    {
        //update question number
        switch(typeOfQuestion)
        {
            case 0:
            {

                this.progressLabel.setText("Single Choice   : "+(mCurrentIndex+1)+" / "+(sampleQuestions.singleChoice.length));
            }
            break;
            case 1:
            {
                this.progressLabel.setText("Multiple Choice : "+(mCurrentIndex+1)+" / "+(sampleQuestions.multipleChoice.length));
            }
            break;
            case 2:
            {
                this.progressLabel.setText("Numericals      : "+(mCurrentIndex+1)+" / "+(sampleQuestions.numericals.length));
            }
            break;
        }

        //update progress bar
        this.progressBar.setMax(((typeOfQuestion == 0)?(sampleQuestions.singleChoice.length):(  (typeOfQuestion==1)?(sampleQuestions.multipleChoice.length):(sampleQuestions.numericals.length)  )));
        this.progressBar.setProgress(mCurrentIndex+1);
    }
    private void getChosenOptions()
    {
        switch (this.typeOfQuestion)
        {
            case 0://single options
            {

                if(single1.isChecked())
                {
                    userSelectedOptions.singleCorrect[mCurrentIndex]=1;
                }
                else if(single2.isChecked())
                {
                    userSelectedOptions.singleCorrect[mCurrentIndex]=2;
                }
                else if(single3.isChecked())
                {
                    userSelectedOptions.singleCorrect[mCurrentIndex]=3;
                }
                else if(single4.isChecked())
                {
                    userSelectedOptions.singleCorrect[mCurrentIndex]=4;
                }
            }
            break;
            case 1://multiple options
            {
                if(multiple1.isChecked())
                {
                    addToMultiple(1);
                }
                else
                {
                    removeFromMultiple(1);
                }

                if(multiple2.isChecked())
                {
                    addToMultiple(2);
                }
                else
                {
                    removeFromMultiple(2);
                }

                if(multiple3.isChecked())
                {
                    addToMultiple(3);
                }
                else
                {
                    removeFromMultiple(3);
                }

                if(multiple4.isChecked())
                {
                    addToMultiple(4);
                }
                else
                {
                    removeFromMultiple(4);
                }
            }
            break;
            case 2://numericals
            {
                userSelectedOptions.numericals[mCurrentIndex] = NumericalsOptions.getText().toString();
            }
        }
    }
    private void addToMultiple(int x)
    {
        if(userSelectedOptions.multipleCorrect[mCurrentIndex] ==null)
        {
            userSelectedOptions.multipleCorrect[mCurrentIndex] = new ArrayList<>();
        }

        userSelectedOptions.multipleCorrect[mCurrentIndex].add(new Integer(x));
    }
    private void removeFromMultiple(int x)
    {
        if(userSelectedOptions.multipleCorrect[mCurrentIndex] != null)
        {
            if(userSelectedOptions.multipleCorrect[mCurrentIndex].contains(new Integer(x)))
            {
                userSelectedOptions.multipleCorrect[mCurrentIndex].remove(new Integer(x));
            }
        }
    }
    private void changeQuestionNumberTo(int typeOfQuestion, int mCurrentIndex)
    {
        this.typeOfQuestion = typeOfQuestion;
        this.mCurrentIndex = mCurrentIndex;
        this.getChosenOptions();
        this.mNextButton.setText("NEXT");
        updateScreen();
        ChangeWebContent();//Changing Content
        SelectUserSelectedOption();
        questionNumber.setText((this.mCurrentIndex+1)+".");
        if(typeOfQuestion==2 && mCurrentIndex==4)
        {
            this.mNextButton.setText("SUBMIT");
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String submit_attempt_review = data.getStringExtra("submit_attempt_review");

                switch(submit_attempt_review.trim())
                {
                    case "2"://attempt button clicked
                    {
                        this.changeQuestionNumberTo(unattemptedQuestionType,unattemptedQuestionNumber);
                    }
                    break;
                    case "3"://review button clicked
                    {
                        this.changeQuestionNumberTo(0,0);
                    }
                    break;
                }
                isLastQuestion=0;
            }
        }
    }
    /*
    ***************** DATA MEMBERS ***************
     */
    private CheckBox multiple1;
    private CheckBox multiple2;
    private CheckBox multiple3;
    private CheckBox multiple4;

    private int unattemptedQuestionType=0;
    private int unattemptedQuestionNumber=3;

    private RadioButton single1;
    private RadioButton single2;
    private RadioButton single3;
    private RadioButton single4;
    private RadioButton singleHidden;

    private TextView questionNumber;

    private Button mNextButton;

    private WebView htmlTextView;
    private ProgressBar progressBar;
    private int typeOfQuestion=0;
    protected static SampleQuestions sampleQuestions;
    private RadioGroup SingleCorrectOptions;
    private EditText NumericalsOptions;
    protected static UserSelectedOptions userSelectedOptions;
    private TextView counter;
    private TextView progressLabel;
    private int previous_button_clicks = 0;
    private int next_button_clicks = 0;
    private int mCurrentIndex = 0;
    private final String preQues = "<html><head><title>Question Paper</title></head></html><body><style>.option::before{content: \"(\";}.option::after{content:\")\";}.italic{font-family: 'Dancing Script', cursive;}</style><div class='container' style='margin-bottom:7%'><div class='col-md-10 col-md-offset-1' style='text-align:justify;margin-top:4%' >";
    private final String postQues = "</body></html>";
    private int isLastQuestion = 0;
    /*
    *************** ON CREATE METHOD ***************
     */
    //@SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqinstant);

        /*
        ***************  Initializing widgets  ***************
         */
        final String FORMAT = "%02d:%02d:%02d";
        htmlTextView = (WebView) findViewById(R.id.html_text);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressLabel = (TextView) findViewById(R.id.progressLabel);
        mNextButton = (Button) findViewById(R.id.nextButton);
        Button mPrevButton = (Button) findViewById(R.id.prevButton);
        SingleCorrectOptions = (RadioGroup) findViewById(R.id.SingleChoiceOptions);
        NumericalsOptions = (EditText) findViewById(R.id.NumericalOption);

        multiple1 = (CheckBox) findViewById(R.id.MultipleChoiceOption1);
        multiple2 = (CheckBox) findViewById(R.id.MultipleChoiceOption2);
        multiple3 = (CheckBox) findViewById(R.id.MultipleChoiceOption3);
        multiple4 = (CheckBox) findViewById(R.id.MultipleChoiceOption4);

        single1 = (RadioButton) findViewById(R.id.SingleChoiceOption1);
        single2 = (RadioButton) findViewById(R.id.SingleChoiceOption2);
        single3 = (RadioButton) findViewById(R.id.SingleChoiceOption3);
        single4 = (RadioButton) findViewById(R.id.SingleChoiceOption4);

        singleHidden = (RadioButton) findViewById(R.id.SingleChoiceOptionHidden);

        questionNumber = (TextView) findViewById(R.id.QuestionNumber);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 showValue("Value of Type of Question: ",typeOfQuestion+"");
             }
         });

        // Questions

        sampleQuestions = new SampleQuestions();
        userSelectedOptions = new UserSelectedOptions(sampleQuestions.singleChoice.length,sampleQuestions.multipleChoice.length,sampleQuestions.numericals.length);
        this.progressBar.setMax(sampleQuestions.singleChoice.length+ sampleQuestions.multipleChoice.length+sampleQuestions.numericals.length);

        //shuffle question
        shuffle<SingleChoice> ForSingle = new shuffle<SingleChoice>(sampleQuestions.singleChoice);
        sampleQuestions.singleChoice=ForSingle.shuffle_elements();

        shuffle<MultipleChoice> ForMultiple = new shuffle<MultipleChoice>(sampleQuestions.multipleChoice);
        sampleQuestions.multipleChoice = ForMultiple.shuffle_elements();

        shuffle<Numericals> ForNumerical = new shuffle<Numericals>(sampleQuestions.numericals);
        sampleQuestions.numericals = ForNumerical.shuffle_elements();

        // Setting progress bar corresponding to the Single correct Options

        this.progressLabel.setText("Single Choice   : "+(mCurrentIndex+1)+" / "+(sampleQuestions.singleChoice.length));
        this.progressBar.setMax(sampleQuestions.singleChoice.length);
        this.progressBar.setProgress(1);

        // Counter

        counter = (TextView)findViewById(R.id.counter);
        TextView timeLeftLabel = (TextView) findViewById(R.id.timeLeftLabel);
        timeLeftLabel.setText("Time Left");

        final long tenMinutes = 10*60*60*1000;
        CountDownTimer seconds = new CountDownTimer(3*tenMinutes,1000) {
            public void onTick(long millisUntilFinished) {
                counter.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                if(((30*tenMinutes-millisUntilFinished/1000)<=tenMinutes/10))
                {
                    counter.setTextColor(Color.YELLOW);
                }
                else if((30*tenMinutes-millisUntilFinished/1000)<=10*tenMinutes)
                {
                    counter.setTextColor(Color.RED);
                }
                else
                {
                    counter.setTextColor(Color.rgb(0,100000,0));
                }
            }

            public void onFinish() {
                counter.setText("Time is Finished");
            }
        };
        seconds.start();

        htmlTextView.loadDataWithBaseURL("file:///android_res/drawable/", preQues + sampleQuestions.singleChoice[0].getQuestion()+ postQues, "text/html", "UTF-8", null);
        htmlTextView.getSettings().setBuiltInZoomControls(true);
        htmlTextView.getSettings().setDisplayZoomControls(false);
        htmlTextView.setVerticalScrollBarEnabled(true);
        htmlTextView.setHorizontalScrollBarEnabled(true);


        Button clearAll = (Button) findViewById(R.id.Clear);

        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HideAll();
            }
        });

        /*
        Button Click Listener event on next click
         */

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChosenOptions();
                next_button_clicks++;
                mNextButton.setText("NEXT");
                switch(typeOfQuestion)//choose correct values for mCurrentIndex && typeOfQuestion
                {
                    case 0:
                    {
                        if(mCurrentIndex == (sampleQuestions.singleChoice.length-1)) {
                            typeOfQuestion=1;
                            mCurrentIndex=0;
                        }
                        else {
                            mCurrentIndex++;
                        }
                    }
                    break;
                    case 1:
                    {
                        if(mCurrentIndex == (sampleQuestions.multipleChoice.length-1)) {
                            typeOfQuestion=2;
                            mCurrentIndex=0;
                        }
                        else {
                            mCurrentIndex++;
                        }
                    }
                    break;
                    case 2:
                    {
                        if(mCurrentIndex == (sampleQuestions.numericals.length-1)) {
                            //Do Nothing
                            if(isLastQuestion==1)
                            {
                                Intent myIntent = new Intent(MCQInstant.this, TestSubmitPage.class);
                                startActivityForResult(myIntent,1);
                            }
                        }
                        else if(mCurrentIndex == (sampleQuestions.numericals.length-2))
                        {
                            isLastQuestion=1;
                            mCurrentIndex++;
                        }
                        else {
                            mCurrentIndex++;
                        }
                    }
                }
                updateScreen();
                ChangeWebContent();//Changing Content
                SelectUserSelectedOption();
                questionNumber.setText((mCurrentIndex+1)+".");
                if(isLastQuestion==1)
                {
                    mNextButton.setText("SUBMIT");
                }
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChosenOptions();
                previous_button_clicks++;
                mNextButton.setText("NEXT");
                switch(typeOfQuestion)//choose correct values for mCurrentIndex && typeOfQuestion
                {
                    case 0:
                    {
                        if(mCurrentIndex == 0)
                        {
                            //Do Nothing
                        }
                        else
                        {
                            mCurrentIndex--;
                        }
                    }
                    break;
                    case 1:
                    {
                        if(mCurrentIndex == 0)
                        {
                            typeOfQuestion=0;
                            mCurrentIndex=sampleQuestions.singleChoice.length-1;
                        }
                        else
                        {
                            mCurrentIndex--;
                        }
                    }
                    break;
                    case 2:
                    {
                        if(mCurrentIndex == 0)
                        {
                            typeOfQuestion=1;
                            mCurrentIndex=sampleQuestions.multipleChoice.length-1;
                        }
                        else
                        {
                            mCurrentIndex--;
                        }
                    }
                }
                //TODO:: Check for this functionality (check for correctness of [mCurrentIndex-1]  )
                updateScreen();//Changing type of question and progress bar.
                ChangeWebContent();//Changing Content
                SelectUserSelectedOption();
                questionNumber.setText(mCurrentIndex+1+".");
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MCQInstant Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.nitin.myapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MCQInstant Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.nitin.myapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }


/*    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MCQInstant Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.nitin.myapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MCQInstant Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.nitin.myapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }*/
}