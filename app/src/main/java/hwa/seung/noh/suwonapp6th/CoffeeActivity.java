package hwa.seung.noh.suwonapp6th;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeActivity extends AppCompatActivity {

    private final int UNIT_PRICE = 3000;
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
        message += "\n가격 : " + df.format(mQuantity * UNIT_PRICE + (mWhippingCreamChecked.isChecked() ? 1000 : 0)) + "원";
        mPriceTextView.setText(message);
    }

    public void onCheckBoxClicked(View view) {
        priceView();
    }
}
