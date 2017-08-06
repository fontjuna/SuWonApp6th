package hwa.seung.noh.suwonapp6th.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hwa.seung.noh.suwonapp6th.R;

public class AdapterViewExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_exam);

        ListView listView = (ListView) findViewById(R.id.list_view);

        // 1단계 : 데이타 준비
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("데이타 " + i);
        }

        // 2단계 : 어댑터 준비
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                AdapterViewExamActivity.this,
                android.R.layout.simple_list_item_1,
                data
        );

        // 3단계 : 연결
        listView.setAdapter(adapter);
    }
}
