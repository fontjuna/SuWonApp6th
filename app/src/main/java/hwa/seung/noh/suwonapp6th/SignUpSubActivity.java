package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SignUpSubActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_sub);

        Intent intent = getIntent();

        String message = "아이디 : ";
        message += intent.getStringExtra("id").toString();
        message += "\n비밀번호 : ";
        message += intent.getStringExtra("password").toString();
        message += "\n이메일 : ";
        message += intent.getStringExtra("email").toString();
        message += "\n성별 : ";
        message += intent.getStringExtra("sex").toString();

        ((TextView) findViewById(R.id.print_text)).setText(message);

        findViewById(R.id.confirm_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = getIntent();
//        intent.putExtra("ok","");
//        setResult(RESULT_OK, intent);
        setResult(RESULT_OK);
        finish();
    }
}
