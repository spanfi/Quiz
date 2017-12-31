package com.example.android.quiz;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        welcome();
    }

    public void welcome() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.welcomeTitle);
        builder.setMessage(R.string.welcomeMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int id) {
                // You don't have to do anything here if you just
                // want it dismissed when clicked

                question(null);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void question(View view) {

        ImageView image = findViewById(R.id.image);
        TextView question = findViewById(R.id.question);
        RadioButton answer1 = findViewById(R.id.answer1);
        RadioButton answer2 = findViewById(R.id.answer2);
        RadioButton answer3 = findViewById(R.id.answer3);


        switch (questionNumber) {
            case 1:
                image.setImageResource(R.drawable.poland);
                String q1 = getString(R.string.text_question1);
                question.setText(questionNumber + ". " + q1);
                answer1.setText(R.string.answer1_1);
                answer2.setText(R.string.answer1_2);
                answer3.setText(R.string.answer1_3);
                break;

            case 2:
                image.setImageResource(R.drawable.sea);
                String q2 = getString(R.string.text_question2);
                question.setText(questionNumber + ". " + q2);
                answer1.setText(R.string.answer2_1);
                answer2.setText(R.string.answer2_2);
                answer3.setVisibility(View.INVISIBLE);
                break;
            case 3:
                image.setImageResource(R.drawable.lake);
                String q3 = getString(R.string.text_question3);
                question.setText(questionNumber + ". " + q3);
                answer1.setText(R.string.answer3_1);
                answer2.setText(R.string.answer3_2);
                answer3.setText(R.string.answer3_3);
                break;
            case 4:
                image.setImageResource(R.drawable.mountains);
                String q4 = getString(R.string.text_question4);
                question.setText(questionNumber + ". " + q4);
                answer1.setText(R.string.answer4_1);
                answer2.setText(R.string.answer4_2);
                answer3.setVisibility(View.INVISIBLE);
                break;
            case 5:
                image.setImageResource(R.drawable.lewandowski);
                String q5 = getString(R.string.text_question5);
                question.setText(questionNumber + ". " + q5);
                answer1.setText(R.string.answer5_1);
                answer2.setText(R.string.answer5_2);
                answer3.setText(R.string.answer5_3);
                break;
            case 6:
                image.setImageResource(R.drawable.chopin);
                String q6 = getString(R.string.text_question6);
                question.setText(questionNumber + ". " + q6);
                answer1.setText(R.string.answer6_1);
                answer2.setText(R.string.answer6_2);
                answer3.setText(R.string.answer6_3);
                break;
            case 7:
                image.setImageResource(R.drawable.sklodowska);
                String q7 = getString(R.string.text_question7);
                question.setText(questionNumber + ". " + q7);
                answer1.setText(R.string.answer7_1);
                answer2.setText(R.string.answer7_2);
                answer3.setText(R.string.answer7_3);
                break;
            case 8:
                image.setImageResource(R.drawable.wojtyla);
                String q8 = getString(R.string.text_question8);
                question.setText(questionNumber + ". " + q8);
                answer1.setText(R.string.answer8_1);
                answer2.setText(R.string.answer8_2);
                answer3.setText(R.string.answer8_3);
                break;
            case 9:
                image.setImageResource(R.drawable.copernicus);
                String q9 = getString(R.string.text_question9);
                question.setText(questionNumber + ". " + q9);
                answer1.setText(R.string.answer9_1);
                answer2.setText(R.string.answer9_2);
                answer3.setText(R.string.answer9_3);
                break;

            default:
                dialogEnd();
                break;
        }
        submit(view);
    }

    public void submit(View view) {


        Button submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int radioButtonID = radioGroup.getCheckedRadioButtonId();

                if (radioButtonID == -1) {

                    // radioGroup.clearCheck();
                    dialogError();
                } else {
                    checkAnswer();
                }
            }
        });

    }


    public void checkAnswer() {

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        int des;
        int correct;
        boolean answer;


        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButtonIdx = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButtonIdx);
        RadioButton btn = (RadioButton) radioGroup.getChildAt(idx);
        String selection = (String) btn.getText();


        switch (questionNumber) {

            case 1:
                des = (R.string.description1);
                correct = (R.string.answer1_3);
                if (idx == 2) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 2:
                des = (R.string.description2);
                correct = (R.string.answer2_1);
                if (idx == 0) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 3:
                des = (R.string.description3);
                correct = (R.string.answer3_2);
                if (idx == 1) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 4:
                des = (R.string.description4);
                correct = (R.string.answer4_1);
                if (idx == 0) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 5:
                des = (R.string.description5);
                correct = (R.string.answer5_2);
                if (idx == 1) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 6:
                des = (R.string.description6);
                correct = (R.string.answer6_3);
                if (idx == 2) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 7:
                des = (R.string.description7);
                correct = (R.string.answer7_2);
                if (idx == 1) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 8:
                des = (R.string.description8);
                correct = (R.string.answer8_3);
                if (idx == 2) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;

            case 9:
                des = (R.string.description9);
                correct = (R.string.answer9_1);
                if (idx == 0) {
                    score += 1;
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            default:
                des = (R.string.description9);
                correct = (R.string.answer9_1);
                answer = true;
        }
        dialogAnswer(des, answer, correct);
        radioGroup.clearCheck();
        questionNumber++;
    }

    public void dialogError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.error);
        builder.setIcon(R.drawable.error);
        builder.setMessage(R.string.errorMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int id) {

                question(null);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void dialogAnswer(int description, boolean answer, int correct) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (answer == true) {
            builder.setTitle(R.string.good);
            builder.setIcon(R.drawable.good);
        } else {
            builder.setTitle(R.string.bad);
            builder.setIcon(R.drawable.bad);
        }
        builder.setMessage(description);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int id) {
                // You don't have to do anything here if you just
                // want it dismissed when clicked

                RadioButton answer3 = findViewById(R.id.answer3);
                answer3.setVisibility(View.VISIBLE);
                question(null);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void dialogEnd() {
        // Use the Builder class for convenient dialog construction
        int scoreRange=0;
        if (score > 0 && score <= 4) {
            scoreRange = 1;
        }
        if (score > 4 && score <= 7) {
            scoreRange = 2;
        }
        if (score > 7) {
            scoreRange = 3;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.end);

        switch (scoreRange) {

            case 1:
                String range1 = getString(R.string.text_range1);
                builder.setMessage("Your score is: " + score + "/9" + range1);
                break;

            case 2:
                String range2 = getString(R.string.text_range2);
                builder.setMessage("Your score is: " + score + "/9" + range2);
                break;

            case 3:
                String range3 = getString(R.string.text_range3);
                builder.setMessage("Your score is: " + score + "/9" + range3);
                break;

        }

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int id) {
                // You don't have to do anything here if you just
                // want it dismissed when clicked

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

