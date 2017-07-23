package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SalesManagementOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management_other);

        String message = "ID : ";
        Intent intent = getIntent();
        message += intent.getStringExtra("id")+"\n PW : ";
        message += intent.getStringExtra("password");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
