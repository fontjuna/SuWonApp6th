package hwa.seung.noh.suwonapp6th.another;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import hwa.seung.noh.suwonapp6th.R;

public class BballActivity extends AppCompatActivity implements View.OnClickListener, BballFragment.OnWarningListner {

    BballFragment mFragmentTeamA;
    BballFragment mFragmentTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bball);

        mFragmentTeamA = (BballFragment) getSupportFragmentManager().findFragmentById(R.id.bb_team_a);
        mFragmentTeamB = (BballFragment) getSupportFragmentManager().findFragmentById(R.id.bb_team_b);

        mFragmentTeamB.setTeamName("Team B");

        findViewById(R.id.bb_reset_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mFragmentTeamA.reset();
        mFragmentTeamB.reset();
    }

    @Override
    public void onWarning(String teamName) {
        if (teamName.equals("Team A")) {
            mFragmentTeamB.warning();
        } else {
            mFragmentTeamA.warning();
        }
    }
}
