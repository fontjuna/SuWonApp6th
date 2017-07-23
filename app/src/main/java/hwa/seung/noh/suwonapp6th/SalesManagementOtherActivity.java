package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SalesManagementOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management_other);

        String message = "ID : ";
        Intent intent = getIntent();
        message += intent.getStringExtra("id") + "\nPW : ";
        message += intent.getStringExtra("password");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    public void onClick_menu_button(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_customer_management: {
                intent.putExtra("result", "고객관리");
                break;
            }
            case R.id.btn_revenue_management: {
                intent.putExtra("result", "매출관리");
                break;
            }
            case R.id.btn_product_management: {
                intent.putExtra("result", "상품관리");
                break;
            }
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
