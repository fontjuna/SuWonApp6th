package hwa.seung.noh.suwonapp6th;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BasketBallActivity extends AppCompatActivity {

    private int mScoreA = 0;
    private int mScoreB = 0;
    private TextView mTextViewTeamA;
    private TextView mTextViewTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_ball);

        mTextViewTeamA = (TextView) findViewById(R.id.textViewTeamA);
        mTextViewTeamB = (TextView) findViewById(R.id.textViewTeamB);

    if (savedInstanceState != null) {
        mScoreA = savedInstanceState.getInt("A");
        mScoreB = savedInstanceState.getInt("B");
        mTextViewTeamA.setText(mScoreA + "");
        mTextViewTeamB.setText(mScoreB + "");
    }

    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonTeamA1: {
                mScoreA++;
                break;
            }
            case R.id.buttonTeamA2: {
                mScoreA += 2;
                break;
            }
            case R.id.buttonTeamA3: {
                mScoreA += 3;
                break;
            }
            case R.id.buttonTeamB1: {
                mScoreB++;
                break;
            }
            case R.id.buttonTeamB2: {
                mScoreB += 2;
                break;
            }
            case R.id.buttonTeamB3: {
                mScoreB += 3;
                break;
            }
            case R.id.buttonReset: {
                mScoreA = 0;
                mScoreB = 0;
                break;
            }
        }
        mTextViewTeamA.setText(mScoreA + "");
        mTextViewTeamB.setText(mScoreB + "");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // 저장
        outState.putInt("A", mScoreA);
        outState.putInt("B", mScoreB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }


//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        // Always call the superclass so it can restore the view hierarchy
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // 복원
//        mScoreA = savedInstanceState.getInt("A");
//        mScoreB = savedInstanceState.getInt("B");
//        mTextViewTeamA.setText(mScoreA + "");
//        mTextViewTeamB.setText(mScoreB + "");
//    }
}
