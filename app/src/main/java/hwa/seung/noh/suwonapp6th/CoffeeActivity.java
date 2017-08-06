package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CoffeeActivity extends AppCompatActivity {

    public static final int WHIPPING_CREAM_UNIT_PRICE = 1000;
    private final int COFFEE_UNIT_PRICE = 3000;
    private final int MINIMUM_QTY = 1;

    private EditText mNameEditText;
    private CheckBox mWhippingCreamChecked;
    private TextView mQuantityTextView;
    private TextView mPriceTextView;

    private int mQuantity = MINIMUM_QTY;

    private DecimalFormat df = new DecimalFormat("#,##0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레이아웃 설정
        setContentView(R.layout.activity_coffee);

        // XML에 있는 View의 레퍼런스를 가져오는 방법
        mNameEditText = (EditText) findViewById(R.id.name_edit);
        mWhippingCreamChecked = (CheckBox) findViewById(R.id.whipping_cream_check);
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text);
        mPriceTextView = (TextView) findViewById(R.id.price_text);

        priceView();
    }

    public void minusButtonClicked(View view) {
        //Toast.makeText(this,"마이너스",Toast.LENGTH_SHORT).show();
        if (mQuantity > MINIMUM_QTY) {
            mQuantity--;
        }
        priceView();
    }

    public void plusButtonClicked(View view) {
        mQuantity++;
        priceView();
    }

    private void priceView() {
        mQuantityTextView.setText(mQuantity + "");
        String message = "주문자 : " + mNameEditText.getText().toString();
        message += "\n========================";
        message += "\n휘핑크림 추가 : " + mWhippingCreamChecked.isChecked();
        message += "\n갯수 : " + mQuantity;
        message += "\n가격 : " + df.format(mQuantity * COFFEE_UNIT_PRICE
                + (mWhippingCreamChecked.isChecked() ? WHIPPING_CREAM_UNIT_PRICE : 0)) + "원";
        mPriceTextView.setText(message);
    }

    public void onCheckBoxClicked(View view) {
        priceView();
    }

    public void onOrderButtonClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fontjuna@naver.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "커피주문");
        intent.putExtra(Intent.EXTRA_TEXT, mPriceTextView.getText());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.coffee_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1_menu:
                startActivity(new Intent(this,BasketBallActivity.class));
                return true;
            case R.id.item2_menu:
                startActivity(new Intent(this,SalesManagementActivity.class));
                return true;
            case R.id.item3_menu:
                Toast.makeText(this, "메뉴3번을 클릭 했습니다.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4_menu:
                Toast.makeText(this, "잘했어요!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
