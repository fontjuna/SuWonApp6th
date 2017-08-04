package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    EditText mUrlEditText;
    EditText mPhoneEditText;
    EditText mSmsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        mUrlEditText = (EditText) findViewById(R.id.url_edit_text);
        mPhoneEditText = (EditText) findViewById(R.id.phone_edit_text);
        mSmsEditText = (EditText) findViewById(R.id.sms_edit_text);
    }

    public void onWebButtonClicked(View view) {
        Uri webpage = Uri.parse(mUrlEditText.getText().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onPhoneButtonClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + mPhoneEditText.getText().toString()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onSmsButtonClicked(View view) {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setData(Uri.parse("smsto:" + mSmsEditText.getText().toString()));  // This ensures only SMS apps respond
//        intent.putExtra("sms_body", "실험적 문자 메세지이니 답장 줘!");
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"실험적 문자 메세지이니 답장 줘!");
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
