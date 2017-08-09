package hwa.seung.noh.suwonapp6th;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    List<Map<String, Object>> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);

        mDataList = new ArrayList<>();

        Map<String, Object> data = new HashMap<>();
        data.put("title", "커피앱");
        data.put("description", "Intent, Activity");
        data.put("class", CoffeeActivity.class);

        mDataList.add(data);

        SimpleAdapter adapter = new SimpleAdapter(this, mDataList,
                android.R.layout.simple_list_item_2,
                new String[] {"title", "description"},
                new int[] {android.R.id.text1, android.R.id.text2});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class cls = (Class) mDataList.get(position).get("class");
                Intent intent = new Intent(MainActivity.this, cls);
                startActivity(intent);
            }
        });
    }
}
