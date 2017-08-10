package hwa.seung.noh.suwonapp6th.fragment.exam;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import hwa.seung.noh.suwonapp6th.R;

public class CallBackExamActivity extends AppCompatActivity implements ChatFragment.OnSendMessageListener {
    private ChatFragment mChatFragment1;
    private ChatFragment mChatFragment2;
    private ChatFragment mChatFragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back_exam);

        mChatFragment1 = (ChatFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_chat_1);
        mChatFragment2 = (ChatFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_chat_2);
        mChatFragment3 = (ChatFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_chat_3);
    }

    @Override
    public void onSendMessage(String message) {
        mChatFragment1.sendMessage(message);
        mChatFragment2.sendMessage(message);
        mChatFragment3.sendMessage(message);
    }
}
