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

public class BasketScoreFragment extends Fragment {

    private TextView mScoreTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basket_score, container, false);
        mScoreTextView = (TextView) view.findViewById(R.id.score_text);
        return view;
    }
}
