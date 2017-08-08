package hwa.seung.noh.suwonapp6th.fragment.Color;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import hwa.seung.noh.suwonapp6th.R;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

//    public void onCreateFragmentButtonClicked(View view) {
//        // 새로운 프레그먼트를 생성
//        // ColorFragment fragment = new ColorFragment();
//        ColorFragment fragment = new ColorFragment().newInstance(Color.RED);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, fragment)
//                .commit();
//    }

    public void onCreateRedFragmentButtonClicked(View view) {
        // ColorFragment fragment = new ColorFragment(); 인자 전달을 위해 아래로 바꿈
        ColorFragment fragment = new ColorFragment().newInstance(Color.RED);

        // ColorFragment fragment = new ColorFragment(Color.RED); <= 요거 안됨
        // 프레그먼트에 인자를 전달할때 Bundle에 담아서 보낸다
//        Bundle bundle = new Bundle();
//        bundle.putInt("color", Color.RED );
//        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onCreateBlueFragmentButtonClicked(View view) {
        ColorFragment fragment = new ColorFragment().newInstance(Color.BLUE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onCreateGreenFragmentButtonClicked(View view) {
        ColorFragment fragment = new ColorFragment().newInstance(Color.GREEN);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onCreateRandomFragmentButtonClicked(View view) {
        ColorFragment fragment = new ColorFragment().newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
