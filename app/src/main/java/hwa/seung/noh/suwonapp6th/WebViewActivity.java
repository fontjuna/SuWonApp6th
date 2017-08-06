package hwa.seung.noh.suwonapp6th;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {

    WebView mWebView;
    EditText mUrlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = (WebView) findViewById(R.id.window_web_view);
        mUrlEditText = (EditText) findViewById(R.id.url_edit_text);
        mWebView.setWebViewClient(new WebViewClient());     // 안 해주면 안됨
        mWebView.getSettings().setJavaScriptEnabled(true);  // 자바스크립트 페이지 보이게

    }

    public void onMoveButtonClicked(View view) {
        String url = mUrlEditText.getText().toString();
        mWebView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()){
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onBackButtonClicked(View view) {
        mWebView.goBack();
    }

    public void onForwardButtonClicked(View view) {
        mWebView.goForward();
    }
}
