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

        // view
        ListView listView = (ListView) findViewById(R.id.list_view);

        // data
        // ArrayList<String> data = new ArrayList<>();
        ArrayList<People> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
//            data.add("데이타 " + i);
            int picture;
            if (i % 2 == 0) {
                picture = R.drawable.girl;
            } else {
                picture = R.drawable.bonfire_night;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            data.add(people);
        }

        //adapter
//        ArrayAdapter<People> adapter = new ArrayAdapter<People>(AdapterViewExamActivity.this,
//                android.R.layout.simple_list_item_1,
//                data);

        PeopleAdapter adapter = new PeopleAdapter(AdapterViewExamActivity.this, data);

        listView.setAdapter(adapter);
    }
}
