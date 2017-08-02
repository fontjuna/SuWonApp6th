package hwa.seung.noh.suwonapp6th.fragment.basketball;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hwa.seung.noh.suwonapp6th.R;

/**
 * Created by fontjuna on 2017-08-02.
 */

public class BasketScoreFragment extends Fragment implements View.OnClickListener {

    private TextView mTeamNameTextView;
    private TextView mScoreTextView;
    private int mScore;

    //뷰를 만드는 곳
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basket_score, container, false);
    }

    //뷰가 다 만들어 진곳

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScoreTextView = (TextView) view.findViewById(R.id.score_text);
        mTeamNameTextView = (TextView) view.findViewById(R.id.team_name_text);
        view.findViewById(R.id.button_1).setOnClickListener(this);
        view.findViewById(R.id.button_2).setOnClickListener(this);
        view.findViewById(R.id.button_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                mScore++;
                break;
            case R.id.button_2:
                mScore += 2;
                break;
            case R.id.button_3:
                mScore += 3;
                break;
        }
        mScoreTextView.setText("" + mScore);
    }

    public void reset() {
        mScore = 0;
        mScoreTextView.setText("" + 0);
    }

    public void setTeamName(String name){
        mTeamNameTextView.setText(name);
    }
}
