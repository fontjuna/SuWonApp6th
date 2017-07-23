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

        // 넘어온 데이타 받기
        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("message");
            // 프리미티브 타입은 초기 값이 필요하므로 인자가 하나 더있다.
            int age = intent.getIntExtra("age", 0);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    public void btnFinishClicked(View view) {
        // 나이를 돌려준다
        Intent intent = new Intent();
        intent.putExtra("age",100);
        setResult(RESULT_OK, intent);

        // Activity 종료
        finish();
    }
}
