package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MoveActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_AGE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        // 방법-1 : 버튼이 눌렸는지를 감지하는 방법 1단계
        View.OnClickListener listener = new MyOnClickListener();
        Button btnBasketBall = (Button) findViewById(R.id.btn_basketball);
        btnBasketBall.setOnClickListener(listener);

        // 방법-2 : 방법-1의 변형 (일회용 이므로 인스턴스화 하지 않고 무명클래스로 만든다)
        findViewById(R.id.btn_coffee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 화면 띄우는 코드 intent의 생성 및 시작
                // Intent intent = new Intent(MoveActivity.this, CoffeeActivity.class);
                // startActivity(intent);
                startActivity(new Intent(MoveActivity.this, CoffeeActivity.class));
            }
        });

        // 방법-3 : 화면만 띄우는 것이 아니라 메세지를 주고 받는다
        findViewById(R.id.btn_movedata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "메세지를 보냅니다.";
                Intent intent = new Intent(MoveActivity.this, MoveOtherActivity.class);
                intent.putExtra("message", message);
                intent.putExtra("age", 28);
                // 데이타를 받고 싶을때는 startActivity대신 startActivityForResult를 사용
                // 받는 곳은 별도로 구성(override)
                startActivityForResult(intent, REQUEST_CODE_AGE);
            }
        });
    }

    // startActivityForResult의 결과를 받는 곳
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_AGE &&
                resultCode == RESULT_OK &&
                data != null) {
            int age = data.getIntExtra("age", 0);
            Toast.makeText(this, age + "", Toast.LENGTH_SHORT).show();
        }
    }

    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //Toast.makeText(MoveActivity.this, "잘 되나", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MoveActivity.this, BasketBallActivity.class);
            startActivity(intent);
        }
    }
}
