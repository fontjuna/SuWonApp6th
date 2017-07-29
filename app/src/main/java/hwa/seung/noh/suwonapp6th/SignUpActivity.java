package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        String id = ((EditText) findViewById(R.id.id_edit)).getText().toString();
        String password = ((EditText) findViewById(R.id.password_edit)).getText().toString();
        String passwordconfirm = ((EditText) findViewById(R.id.password_confirm_button)).getText().toString();
        String email = ((EditText) findViewById(R.id.email_edit)).getText().toString();
        boolean isMale = ((RadioButton) findViewById(R.id.male_radiobutton)).isChecked();

        Intent intent = new Intent(this, SignUpSubActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("password", password);
        intent.putExtra("passwordconfirm", passwordconfirm);
        intent.putExtra("email", email);
        intent.putExtra("sex",isMale?"남자":"여자");

        startActivity(intent);
    }
}
