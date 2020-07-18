package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public Button btnTrue;
    Button btnWrong;
    TextView txtQuestion;
    TextView txtQuizStats;
    int pgbar;
    ProgressBar quizPB;
    Boolean decider;
    int mValue;
    int a = 1;
    //    private QuizModel[] questions = new QuizModel[]{
//           new QuizModel(R.string.q1 ,true),
//            new QuizModel(R.string.q2 ,false),
//            new QuizModel(R.string.q3 ,true),
//            new QuizModel(R.string.q4 ,false),
//            new QuizModel(R.string.q5 ,true),
//            new QuizModel(R.string.q6 ,false),
//            new QuizModel(R.string.q7 ,true),
//            new QuizModel(R.string.q8 ,false),
//            new QuizModel(R.string.q9 ,true),
//            new QuizModel(R.string.q10 ,false),
//    };
    ArrayList<QuizModel> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    btnTrue = findViewById(R.id.btnTrue);
    btnWrong = findViewById(R.id.btnWrong);
    txtQuestion = findViewById(R.id.txtQuestion);
    txtQuizStats =findViewById(R.id.txtQuizStats);
    quizPB = findViewById(R.id.quizPB);
    questions.add(new QuizModel(R.string.q1 ,true));
        questions.add(new QuizModel(R.string.q2 ,false));
        questions.add(new QuizModel(R.string.q3 ,true));
        questions.add(new QuizModel(R.string.q4 ,false));
        questions.add(new QuizModel(R.string.q5 ,true));
        questions.add(new QuizModel(R.string.q6 ,false));
        questions.add(new QuizModel(R.string.q7 ,true));
        questions.add(new QuizModel(R.string.q8 ,false));
        questions.add(new QuizModel(R.string.q9 ,true));
        questions.add(new QuizModel(R.string.q10 ,false));
        pgbar = 100/questions.size();

    txtQuizStats.setText(R.string.first_score_text);

    //QuizModel q1 = questions.get(0);


        if(savedInstanceState != null){
         //   Toast.makeText(this,"SavedInstance IS Called",Toast.LENGTH_SHORT).show();

            pgbar= savedInstanceState.getInt("pg");
            quizPB.incrementProgressBy(pgbar);

            mValue = savedInstanceState.getInt("que");


            a = savedInstanceState.getInt("stats");
            txtQuizStats.setText((a-1)+"/10");
        }
        txtQuestion.setText(questions.get(mValue).mQuestion);


    }



    public void buttonTrue(View ButtonView){
        quizPB.incrementProgressBy(pgbar);
        mValue = (int) (Math.random()*(questions.size()-1));
        if(questions.size() == 0){
          //  Toast.makeText(this,"Congratulations Your Score is "+(a-1)+"/10",Toast.LENGTH_SHORT).show();


            AlertDialog.Builder alertdg = new AlertDialog.Builder(MainActivity.this);
            alertdg.setCancelable(false);
            alertdg.setTitle("Quiz Completed");
            alertdg.setMessage("Your Result is "+(a-1)+"/10");
            alertdg.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    a = 0;
                    txtQuizStats.setText(a+"/10");
                    questions.add(new QuizModel(R.string.q1 ,true));
                    questions.add(new QuizModel(R.string.q2 ,false));
                    questions.add(new QuizModel(R.string.q3 ,true));
                    questions.add(new QuizModel(R.string.q4 ,false));
                    questions.add(new QuizModel(R.string.q5 ,true));
                    questions.add(new QuizModel(R.string.q6 ,false));
                    questions.add(new QuizModel(R.string.q7 ,true));
                    questions.add(new QuizModel(R.string.q8 ,false));
                    questions.add(new QuizModel(R.string.q9 ,true));
                    questions.add(new QuizModel(R.string.q10 ,false));
                    quizPB.setProgress(0);
                    mValue = 0;
                    QuizModel q1 = questions.get(mValue);
                    txtQuestion.setText(q1.mQuestion);
                }
            });
            alertdg.show();
            return;

        }
        QuizModel q1 = questions.get(mValue);
        txtQuestion.setText(q1.mQuestion);
        decider = true;
        if(a == 9){
            a = 0;
            Toast.makeText(this,"Completed",Toast.LENGTH_SHORT).show();

        }

        if(q1.mAnswer == decider && a<=10){

            txtQuizStats.setText(a+"/10");
            a = a+1;
        }else{
        }
        questions.remove(mValue);



    }


    public void buttonWrong(View ButtonView){
        quizPB.incrementProgressBy(pgbar);

        mValue = (int) (Math.random()*(questions.size()-1));
        if(questions.size() == 0){
           // Toast.makeText(this,"Congratulations Your Score is "+(a-1)+"/10",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder alertdg = new AlertDialog.Builder(MainActivity.this);
            alertdg.setCancelable(false);
            alertdg.setTitle("Quiz Completed");
            alertdg.setMessage("Your Result is "+(a-1)+"/10");
            alertdg.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    a = 0;
                    txtQuizStats.setText(a+"/10");
                    questions.add(new QuizModel(R.string.q1 ,true));
                    questions.add(new QuizModel(R.string.q2 ,false));
                    questions.add(new QuizModel(R.string.q3 ,true));
                    questions.add(new QuizModel(R.string.q4 ,false));
                    questions.add(new QuizModel(R.string.q5 ,true));
                    questions.add(new QuizModel(R.string.q6 ,false));
                    questions.add(new QuizModel(R.string.q7 ,true));
                    questions.add(new QuizModel(R.string.q8 ,false));
                    questions.add(new QuizModel(R.string.q9 ,true));
                    questions.add(new QuizModel(R.string.q10 ,false));
                    quizPB.setProgress(0);
                    mValue = 0;
                    QuizModel q1 = questions.get(mValue);
                    txtQuestion.setText(q1.mQuestion);
                }
            });
            alertdg.show();
            return;

        }
        QuizModel q1 = questions.get(mValue);
        txtQuestion.setText(q1.mQuestion);
        decider = false;
        if(a == 9){
            a = 0;
            Toast.makeText(this,"Completed",Toast.LENGTH_SHORT).show();
        }

        if(q1.mAnswer == decider && a<=10){
            txtQuizStats.setText(a+"/10");
            a = a+1;
        }
        questions.remove(mValue);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pg",pgbar);
        outState.putInt("que",mValue);
        outState.putInt("stats",a);

    }
}
