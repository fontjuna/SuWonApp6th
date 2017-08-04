package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MoveOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_other);

        Intent intent = getIntent();
        String message = intent.getStringExtra("hello");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onFinishButtonClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("back", "다시 가라해서 되돌아 왔슈!");
        setResult(RESULT_OK, intent);
        finish();
    }
}
