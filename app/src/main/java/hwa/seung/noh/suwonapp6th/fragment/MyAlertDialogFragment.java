package hwa.seung.noh.suwonapp6th.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import hwa.seung.noh.suwonapp6th.R;

/**
 * Created by fontjuna on 2017-08-14.
 */

public class MyAlertDialogFragment extends DialogFragment {

    private DialogInterface.OnClickListener mListener;

    public static MyAlertDialogFragment newInstance(DialogInterface.OnClickListener listener) {

        Bundle args = new Bundle();
        MyAlertDialogFragment fragment = new MyAlertDialogFragment();
        fragment.setArguments(args);
        // listner는 Bundle에 들어가지 않는다 data가 아니고 interface이므로
        // 때문에 밖에서 listener를 전달 받도록 멤버변수 mListener와 다음의 메소드를 준비 한다.
        // setPositiveButtonClickListener() <- onCreateDialog보다 먼저 실행됨
        fragment.setPositiveButtonClickListener(listener);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("삭제");
        builder.setMessage("정말로 삭제 하시겠습니까?");
        // 바깥 부분을 클릭 했을때 닫기
        builder.setCancelable(false);
        builder.setIcon(R.drawable.girl);
        builder.setPositiveButton("예", mListener);
        builder.setNegativeButton("아니오", null);
        return builder.create();
    }

    public void setPositiveButtonClickListener(DialogInterface.OnClickListener listener) {
        mListener = listener;
    }
}

