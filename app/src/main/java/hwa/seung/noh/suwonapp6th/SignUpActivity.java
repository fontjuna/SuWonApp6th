package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_SIGNUP = 1000;
    private String mId;
    private String mPassword;
    private String mPasswordConfirm;
    private String mEmail;
    private boolean mIsMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViewById(R.id.reset_button).setOnClickListener(this);
        findViewById(R.id.signup_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_button:
                reset();
                break;
            case R.id.signup_button:
                setMemberVar();
                if (isCorrect()) {
                    signUp();
                }
                break;
        }
    }

    private boolean isCorrect() {
        boolean okAll = true;
        String message = "";
        if (TextUtils.isEmpty(mId) ||
                TextUtils.isEmpty(mPassword) ||
                TextUtils.isEmpty(mPasswordConfirm) ||
                TextUtils.isEmpty(mEmail) ) {
            Toast.makeText(this, "모두 압력해 주셔야 합니다", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mPassword.equals(mPasswordConfirm)) {
            Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setMemberVar() {
        mId = ((EditText) findViewById(R.id.id_edit)).getText().toString();
        mPassword = ((EditText) findViewById(R.id.password_edit)).getText().toString();
        mPasswordConfirm = ((EditText) findViewById(R.id.password_confirm_button)).getText().toString();
        mEmail = ((EditText) findViewById(R.id.email_edit)).getText().toString();
        mIsMale = ((RadioButton) findViewById(R.id.male_radiobutton)).isChecked();
    }

    private void signUp() {
        Intent intent = new Intent(SignUpActivity.this, SignUpSubActivity.class);
        intent.putExtra("id", mId);
        intent.putExtra("password", mPassword);
        intent.putExtra("passwordconfirm", mPasswordConfirm);
        intent.putExtra("email", mEmail);
        intent.putExtra("sex", mIsMale ? "남자" : "여자");

        startActivityForResult(intent, REQUEST_CODE_SIGNUP);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "확인 버튼을 누르셨습니다", Toast.LENGTH_SHORT).show();
    }

    private void reset() {
        ((EditText) findViewById(R.id.id_edit)).setText("");
        ((EditText) findViewById(R.id.password_edit)).setText("");
        ((EditText) findViewById(R.id.password_confirm_button)).setText("");
        ((EditText) findViewById(R.id.email_edit)).setText("");
        ((RadioButton) findViewById(R.id.male_radiobutton)).setChecked(true);
    }
}
