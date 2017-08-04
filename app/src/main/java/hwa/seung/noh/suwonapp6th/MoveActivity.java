package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MoveActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        findViewById(R.id.btn_basketball).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoveActivity.this, BasketBallActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_coffee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoveActivity.this, CoffeeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_movedata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoveActivity.this, MoveOtherActivity.class);
                intent.putExtra("hello", "안녕? 나 왔슈!");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE && data != null) {
                String result = data.getStringExtra("back");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }
        }

    }

}
