package hwa.seung.noh.suwonapp6th;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = LifeCycleActivity.class.getSimpleName();
    public static final String PREF_NAME = "SharedPreferance";
    private int mNum = 0;
    private Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.d(TAG, "onCreate: ");

        mButton = (Button) findViewById(R.id.inc_button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("number", mNum);
        editor.apply();

        Log.d(TAG, "onPause: 저장");
    }

    @Override
    protected void onResume() {

        super.onResume();
        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        mNum = settings.getInt("number", 0);
        mButton.setText("" + mNum);

        Log.d(TAG, "onResume: 복원");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    // 화면에서 안보이면 실행
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //저장
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //복원
        Log.d(TAG, "onRestoreInstanceState: ");
    }

    public void showDialog(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("TEST");
        dialog.setMessage("testttt");
        dialog.show();
    }

    public void increament(View view) {
        ((Button) view).setText("" + ++mNum);
    }
}
