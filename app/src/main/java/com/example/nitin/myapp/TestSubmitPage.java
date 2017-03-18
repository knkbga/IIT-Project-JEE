package com.example.nitin.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSubmitPage extends AppCompatActivity {

    private MCQInstant mcqInstant;

    private Button attempt;
    private Button submit;
    private Button review;

    private String x = "submit_attempt_review";

    private int CalculateMarks(UserSelectedOptions userSelectedOptions, SampleQuestions sampleQuestions)
    {
        int totalMarks=0;

        //For Single Correct Questions
        for(int i=0;i<userSelectedOptions.singleCorrect.length;i++)
        {
            int x = userSelectedOptions.singleCorrect[i];
            if(x != 0)
            {
                if(sampleQuestions.singleChoice[i].options[x-1].is_answer == true)
                {
                    totalMarks += 5;
                }
                else
                {
                    totalMarks -= 1;
                }
            }
        }

        //For Multiple Correct Questions
        for(int i=0;i<userSelectedOptions.multipleCorrect.length;i++)
        {
            ArrayList<Integer> x = userSelectedOptions.multipleCorrect[i];
            ArrayList<Integer> y = new ArrayList<>();
            if(x!=null)
            {
                for (int j = 0; j < 4; j++) {
                    if (sampleQuestions.multipleChoice[i].options[j].is_answer == true) {
                        y.add((j + 1));
                    }
                }

                if (this.listEqualsNoOrder(x, y)) {
                    totalMarks += 5;
                    totalMarks -= 1;
                }
            }
        }

        //For Numericals
        for(int i=0;i<userSelectedOptions.numericals.length;i++)
        {
            if( userSelectedOptions.numericals[i] == sampleQuestions.numericals[i].option.value )
            {
                totalMarks += 5;
                totalMarks -= 1;
            }
        }

        return totalMarks;
    }

    private static <T> boolean listEqualsNoOrder(List<T> l1, List<T> l2) {
        final Set<T> s1 = new HashSet<>(l1);
        final Set<T> s2 = new HashSet<>(l2);

        return s1.equals(s2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_submit_page);

        submit = (Button) findViewById(R.id.SubmitButton);
        attempt = (Button) findViewById(R.id.AttemptButton);
        review = (Button) findViewById(R.id.ReviewButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View l1 = (View) findViewById(R.id.RelativeLayoutSubmitPopUp);
                View l2 = (View) findViewById(R.id.RelativeLayoutSubmitLoading);
                View l3 = (View) findViewById(R.id.RelativeLayoutDisplayMarks);
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.GONE);

                mcqInstant = new MCQInstant();

                UserSelectedOptions userSelectedOptions = mcqInstant.userSelectedOptions;
                SampleQuestions sampleQuestions = mcqInstant.sampleQuestions;

                int maxMarks = (sampleQuestions.singleChoice.length * 5)+(sampleQuestions.multipleChoice.length * 5)+(sampleQuestions.numericals.length * 5);

                int marksGained = CalculateMarks(userSelectedOptions,sampleQuestions);
                TextView t = (TextView) findViewById(R.id.MarksObtained);

                t.setText("You obtained " + marksGained + " out of " + maxMarks);

                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.VISIBLE);

            }
        });

        attempt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra(x,2+"");
                setResult(RESULT_OK,i);
                finish();
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra(x,3+"");
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
