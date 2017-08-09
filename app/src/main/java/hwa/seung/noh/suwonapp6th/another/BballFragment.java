package hwa.seung.noh.suwonapp6th.another;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hwa.seung.noh.suwonapp6th.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BballFragment extends Fragment implements View.OnClickListener {

    public interface OnWarningListner {
        void onWarning(String teamName);
    }

    private TextView mScoreTextView;
    private TextView mTeamNameTextView;
    private int mScore = 0;

    private OnWarningListner mListner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListner = (OnWarningListner) context;
    }

    public BballFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bball, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mScoreTextView = (TextView) view.findViewById(R.id.bb_score_text);
        mTeamNameTextView = (TextView) view.findViewById(R.id.bb_team_name_text);

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt("score", 0);
            mScoreTextView.setText(mScore + "");
        }
        view.findViewById(R.id.bb_add_1_button).setOnClickListener(this);
        view.findViewById(R.id.bb_add_2_button).setOnClickListener(this);
        view.findViewById(R.id.bb_add_3_button).setOnClickListener(this);

    }

    public void reset() {
        mScore = 0;
        mScoreTextView.setText(0 + "");
    }

    public void setTeamName(String name) {
        mTeamNameTextView.setText(name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bb_add_1_button:
                mScore++;
                break;
            case R.id.bb_add_2_button:
                mScore += 2;
                break;
            case R.id.bb_add_3_button:
                mScore += 3;
                break;
        }
        if (mScore > 20) {
            mListner.onWarning(mTeamNameTextView.getText().toString());
        }
        mScoreTextView.setText(mScore + "");
    }

    public void warning() {
        getView().setBackgroundColor(Color.RED);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("score", mScore);
        super.onSaveInstanceState(outState);
    }
}
