package hwa.seung.noh.suwonapp6th.fragment.basketball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hwa.seung.noh.suwonapp6th.R;

public class BasketBallActivity extends AppCompatActivity {

    private BasketScoreFragment mATeamFragment;
    private BasketScoreFragment mBTeamFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_ball2);

        mATeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_a);
        mBTeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_b);

        mBTeamFragment.setTeamName("Team B");
    }

    public void onResetButtonClicked(View view) {
        mATeamFragment.reset();
        mBTeamFragment.reset();
    }
//    @Override
//    public void onWarning(String teamName) {
//        if (teamName.equals("Team A")) {
//            mBTeamFragment.warning();
//        } else {
//            mATeamFragment.warning();
//        }
//    }
}
