package hwa.seung.noh.suwonapp6th.another;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hwa.seung.noh.suwonapp6th.R;

public class AcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac);
    }

    public void onCreateRedFregmentButtonClicked(View view) {
        AcFragment fragment = new AcFragment().newInstance(Color.RED);
        getSupportFragmentManager().beginTransaction().replace(R.id.ac_container, fragment).commit();
    }

    public void onCreateBlueFregmentButtonClicked(View view) {
        AcFragment fragment = new AcFragment().newInstance(Color.BLUE);
        getSupportFragmentManager().beginTransaction().replace(R.id.ac_container, fragment).commit();
    }

    public void onCreateGreenFregmentButtonClicked(View view) {
        AcFragment fragment = new AcFragment().newInstance(Color.GREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.ac_container, fragment).commit();
    }

    public void onCreateFregmentButtonClicked(View view) {
        AcFragment fragment = new AcFragment().newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.ac_container, fragment).commit();
    }

}
