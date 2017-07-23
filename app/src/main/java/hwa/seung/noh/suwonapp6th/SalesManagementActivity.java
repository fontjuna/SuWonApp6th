package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SalesManagementActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_LOGIN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etId = (EditText) findViewById(R.id.et_id);
                EditText etPassWord = (EditText) findViewById(R.id.et_password);
                Intent intent = new Intent(SalesManagementActivity.this, SalesManagementOtherActivity.class);
                intent.putExtra("id", etId.getText().toString());
                intent.putExtra("password", etPassWord.getText().toString());
                startActivityForResult(intent, REQUEST_CODE_LOGIN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK && data != null) {
            Toast.makeText(this, data.getStringExtra("result").toString(), Toast.LENGTH_SHORT).show();
        }
    }


}
