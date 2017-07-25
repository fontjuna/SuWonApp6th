package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
    }

    public void onClickFindButton(View view) {
        EditText url_et = (EditText) findViewById(R.id.url_et);
        openWebPage(url_et.getText().toString());
    }


    // 암시적 인텐트
    // 공통 인텐트중 웹페이지 열기에서 가져옴
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickPhoneButton(View view) {
        EditText phone_et = (EditText) findViewById(R.id.phone_et);
        dialPhoneNumber(phone_et.getText().toString());
    }

    // 전화걸기 공통인텐트에서 복붙
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickSmsButton(View view) {
        EditText sms_et = (EditText) findViewById(R.id.sms_et);
        sendTextMessage(sms_et.getText().toString());
    }

    public void sendTextMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
