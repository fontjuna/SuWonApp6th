package hwa.seung.noh.suwonapp6th.adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import hwa.seung.noh.suwonapp6th.R;

/**
 * Created by fontjuna on 2017-08-07.
 */

public class DetailAddressActivity extends AppCompatActivity {
    private EditText mNameEdit;
    private EditText mPhoneEdit;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_address);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            int image = intent.getIntExtra("image", R.mipmap.ic_launcher);

            mNameEdit = (EditText) findViewById(R.id.name_text);
            mPhoneEdit= (EditText) findViewById(R.id.phone_text);
            mImageView = (ImageView) findViewById(R.id.image_view);

            mNameEdit.setText(name);
            mPhoneEdit.setText(phone);
            mImageView.setImageResource(image);
        }

    }
}