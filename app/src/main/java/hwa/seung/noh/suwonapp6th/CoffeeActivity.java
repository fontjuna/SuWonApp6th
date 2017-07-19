package hwa.seung.noh.suwonapp6th;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeActivity extends AppCompatActivity {

    private final int UNIT_PRICE = 3000;
    private final int MINIMUM_QTY = 1;
    private TextView mQuantityTextView;
    private TextView mPriceTextView;
    private int mQuantity = MINIMUM_QTY;
    private DecimalFormat df = new DecimalFormat("#,###");
//    private Button mPlusButton;
//    private Button mMinusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레이아웃 설정
        setContentView(R.layout.activity_coffee);

        // XML에 있는 View의 레퍼런스를 가져오는 방법
//        mMinusButton = (Button) findViewById(R.id.minus_button);
//        mPlusButton = (Button) findViewById(R.id.plus_button);
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text);
        mPriceTextView = (TextView) findViewById(R.id.price_text);
        // mQuantityTextView.setText(String.valueOf(mQuantity));
        mQuantityTextView.setText(mQuantity + "");
        priceView();
    }

    public void minusButtonClicked(View view) {
        //Toast.makeText(this,"마이너스",Toast.LENGTH_SHORT).show();
        if (mQuantity > MINIMUM_QTY) {
            mQuantityTextView.setText(--mQuantity + "");
        }
        priceView();
    }

    public void plusButtonClicked(View view) {
        mQuantityTextView.setText(++mQuantity + "");
        priceView();
    }

    private void priceView() {
        mPriceTextView.setText(df.format(mQuantity * UNIT_PRICE) + "");
    }
}
