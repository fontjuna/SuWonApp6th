package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*

// 세번째방법
public class SalesManagementActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_LOGIN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

}

// 네번째 방법 - 세번째 방법을 아래와 같이 변경
// 무명을래스를 인터페이스를 구현하는 방법으로 변경
public class SalesManagementActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management);

        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login :
        }
    }
}
*/

public class SalesManagementActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_LOGIN = 1000;
    public static final int REQUEST_CODE_SIGN_UP = 2000;

    private EditText etId;
    private EditText etPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management);

        etId = (EditText) findViewById(R.id.et_id);
        etPassWord = (EditText) findViewById(R.id.et_password);
        findViewById(R.id.btn_login).setOnClickListener(this);

        findViewById(R.id.sign_up_text).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.sign_up_text:
                signup();
                break;
        }
        EditText etId = (EditText) findViewById(R.id.et_id);
        EditText etPassWord = (EditText) findViewById(R.id.et_password);
    }

    private void signup() {
        Intent intent = new Intent(SalesManagementActivity.this, SalesManagementOtherActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SIGN_UP);
    }


    private void login() {
        Intent intent = new Intent(SalesManagementActivity.this, SalesManagementOtherActivity.class);
        intent.putExtra("id", etId.getText().toString());
        intent.putExtra("password", etPassWord.getText().toString());
        startActivityForResult(intent, REQUEST_CODE_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_LOGIN &&
                    data != null) {
                Toast.makeText(this, data.getStringExtra("result").toString(), Toast.LENGTH_SHORT).show();
            } else if (requestCode == REQUEST_CODE_SIGN_UP) {
                Toast.makeText(this, "가입 잘 되었음", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
