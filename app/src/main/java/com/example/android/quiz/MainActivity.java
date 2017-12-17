package com.example.android.quiz;


import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int questionNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");

    }

    public void submit(View view) {
                question(view);

    }

    public void question(View view) {
        // if (questionNumber == 10) return;

        TextView question = findViewById(R.id.question);
        RadioButton answer1 = findViewById(R.id.answer1);
        RadioButton answer2 = findViewById(R.id.answer2);
        RadioButton answer3 = findViewById(R.id.answer3);

        switch (questionNumber) {
            case 1:
                question.setText(R.string.text_question1);
                answer1.setText(R.string.answer1_1);
                answer2.setText(R.string.answer1_2);
                answer3.setText(R.string.answer1_3);
                checkAnswer();
                break;

            case 2:
                question.setText(R.string.text_question2);
                answer1.setText(R.string.answer2_1);
                answer2.setText(R.string.answer2_2);
                answer3.setVisibility(View.INVISIBLE);
                //checkAnswer();
                break;
            case 3:
                question.setText(R.string.text_question3);
                answer1.setText(R.string.answer3_1);
                answer2.setText(R.string.answer3_2);
                answer3.setVisibility(View.INVISIBLE);
                //checkAnswer();
                break;
            case 4:
                question.setText(R.string.text_question4);
                answer1.setText(R.string.answer4_1);
                answer2.setText(R.string.answer4_2);
                answer3.setText(R.string.answer4_3);
                //checkAnswer();
                break;
            case 5:
                question.setText(R.string.text_question5);
                answer1.setText(R.string.answer5_1);
                answer2.setText(R.string.answer5_2);
                answer3.setText(R.string.answer5_3);
                //checkAnswer();
                break;
            case 6:
                question.setText(R.string.text_question6);
                answer1.setText(R.string.answer6_1);
                answer2.setText(R.string.answer6_2);
                answer3.setText(R.string.answer6_3);
                //checkAnswer();
                break;
            case 7:
                question.setText(R.string.text_question7);
                answer1.setText(R.string.answer7_1);
                answer2.setText(R.string.answer7_2);
                answer3.setText(R.string.answer7_3);
                //checkAnswer();
                break;
            case 8:
                question.setText(R.string.text_question8);
                answer1.setText(R.string.answer8_1);
                answer2.setText(R.string.answer8_2);
                answer3.setText(R.string.answer8_3);
                //checkAnswer();
                break;
        }
        questionNumber++;
        answer3.setVisibility(View.VISIBLE);
    }

    public void checkAnswer() {

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        switch (questionNumber) {
            case 1:
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButtonIdx = radioGroup.findViewById(radioButtonID);
                int idx = radioGroup.indexOfChild(radioButtonIdx);

                if (idx == 0) {
                    score += 1;
                }

                radioGroup.clearCheck();
                break;
        }
    }

    public static class MyDialogFragment extends DialogFragment {
        //@Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("App Title");
            builder.setMessage("This is an alert with no consequence");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // You don't have to do anything here if you just
                    // want it dismissed when clicked

                   MainActivity met1 = new MainActivity();
                   met1.question(getView());
                                   }
            });

            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
/**
 * inna metoda
 * <p>
 * <p>
 * if (radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId())) == 1)
 * {
 * correctQuestions[0] = 1;
 * }
 * <p>
 * radioGroup.clearCheck();
 * <p>
 * break;
 * <p>
 * }
 */
