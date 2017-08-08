package hwa.seung.noh.suwonapp6th.another;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hwa.seung.noh.suwonapp6th.R;

public class AdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        ListView listView = (ListView) findViewById(R.id.ad_list_view);

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new Item(
                    i % 2 == 0 ? R.drawable.ic_launcher : R.drawable.ic_touch_app_black_24dp,
                    "Name " + i, "Phone " + i
            ));
        }

        ItemAdapter adapter = new ItemAdapter(this, items);

        listView.setAdapter(adapter);
    }
}
