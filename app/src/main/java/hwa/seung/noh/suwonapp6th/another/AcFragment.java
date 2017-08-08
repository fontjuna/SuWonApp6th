package hwa.seung.noh.suwonapp6th.another;


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
public class AcFragment extends Fragment {

    public AcFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ac, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int color = getArguments().getInt("color");
        view.setBackgroundColor(color);
    }

    public static AcFragment newInstance(int color) {
        Bundle args = new Bundle();
        args.putInt("color", color);
        AcFragment fragment = new AcFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static AcFragment newInstance() {
        int a = new Random().nextInt();
        int r = new Random().nextInt();
        int g = new Random().nextInt();
        int b = new Random().nextInt();
        int color = Color.argb(a, r, g, b);

        Bundle args = new Bundle();
        args.putInt("color", color);
        AcFragment fragment = new AcFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
