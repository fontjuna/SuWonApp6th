package hwa.seung.noh.suwonapp6th.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import hwa.seung.noh.suwonapp6th.R;

public class AdapterViewExamActivity extends AppCompatActivity {

    private static final String TAG = AdapterViewExamActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_exam);

        // view
        ListView listView = (ListView) findViewById(R.id.list_view);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // data
        final ArrayList<People> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int picture;
            if (i % 2 == 0) {
                picture = R.drawable.ic_launcher;
            } else {
                picture = R.drawable.ic_touch_app_black_24dp;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            data.add(people);
        }

        //adapter
        PeopleAdapter adapter = new PeopleAdapter(AdapterViewExamActivity.this, data);

        listView.setAdapter(adapter);
//        gridView.setAdapter(adapter);
//        spinner.setAdapter(adapter);

        //OnItemClickListnser
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                People people = data.get(position);
                People people = (People) parent.getAdapter().getItem(position);
                Toast.makeText(AdapterViewExamActivity.this, "그냥클릭", Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onItemClick: " + people.toString());  // debug
//                Log.e(TAG, "onItemClick: 에러");
//                Log.i(TAG, "onItemClick: 정보");
//                Log.w(TAG, "onItemClick: 경고");
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AdapterViewExamActivity.this, "롱 클릭", Toast.LENGTH_SHORT).show();
                return true; // true의 경우 이벤트 소비를 하겠다. 더이상 이벤트가 흘러가지 않겠다
                // 이벤트 소비를 제어 (false의 경우 "롱 클릭" 이 보인후 "그냥 클릭"도 보이게된다)
            }
        });
    }
}
