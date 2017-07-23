package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SalesManagementActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_LOGIN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SalesManagementActivity.this, SalesManagementOtherActivity.class);
                intent.putExtra("id", findViewById(R.id.et_id).toString());
                intent.putExtra("password", findViewById(R.id.et_password).toString());
                startActivityForResult(intent, REQUEST_CODE_LOGIN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}
