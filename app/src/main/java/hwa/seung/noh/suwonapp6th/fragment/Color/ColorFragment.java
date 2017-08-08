package hwa.seung.noh.suwonapp6th.fragment.Color;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import hwa.seung.noh.suwonapp6th.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    // 프레그먼트는 빈 생성자만 있어야한다. 오버로드 안됨
    // ColorFragment(Bundle)=>안됨
    // 인자를 전달하고 싶다면 Bundle에담아서 보낸고 onCreateView()에서 받는다.
    public ColorFragment() {
        // Required empty public constructor
    }

// 팩토리 패턴
public static ColorFragment newInstance(int color) {

    Bundle args = new Bundle();
    args.putInt("color", color);

    ColorFragment fragment = new ColorFragment();
    fragment.setArguments(args);
    return fragment;
}


    public static ColorFragment newInstance() {

        Bundle args = new Bundle();

        int r = new Random().nextInt();
        int g = new Random().nextInt();
        int b = new Random().nextInt();
        int color = Color.argb(255, r, g, b);
        args.putInt("color", color);

        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    int r = new Random().nextInt();
    int g = new Random().nextInt();
    int b = new Random().nextInt();
    int color = Color.argb(255, r, g, b);

    color = getArguments().getInt("color", 0);
    view.setBackgroundColor(color);
}

public void setColor(int color) {
    // getView()는 이 프래그먼트에서 완성된 View를 가져온다
    getView().setBackgroundColor(color);
}
}
