package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SalesManagementOtherActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management_other);

        findViewById(R.id.btn_customer_management).setOnClickListener(this);
        findViewById(R.id.btn_revenue_management).setOnClickListener(this);
        findViewById(R.id.btn_product_management).setOnClickListener(this);

        findViewById(R.id.result2_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        if (getIntent() != null) {
            String id = getIntent().getStringExtra("id");
            String password = getIntent().getStringExtra("password");
            Toast.makeText(this, "ID  : " + id + "\nPW : " + password, Toast.LENGTH_SHORT).show();
        }
    }

    /*
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_customer_management:
                intent.putExtra("text", "고객관리");
                break;
            case R.id.btn_revenue_management:
                intent.putExtra("text", "매출관리");
                break;
            case R.id.btn_product_management:
                intent.putExtra("text", "상품관리");
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }

*/

    // 위의 코드를 다음과 같이 변경
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String text = ((Button) v).getText().toString();
        intent.putExtra("text", text);
        setResult(RESULT_OK, intent);
        finish();
    }

}
