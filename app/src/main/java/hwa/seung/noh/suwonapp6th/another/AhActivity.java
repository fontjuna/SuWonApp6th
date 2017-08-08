package hwa.seung.noh.suwonapp6th.another;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hwa.seung.noh.suwonapp6th.CoffeeActivity;
import hwa.seung.noh.suwonapp6th.R;

public class AhActivity extends AppCompatActivity
        implements ListView.OnItemLongClickListener, ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ah);

        // 어댑터 및 뷰
        //======================================================================================//
        //1.뷰 준비
        ListView listView = (ListView) findViewById(R.id.ah_list_view);
        //2.데이타 준비
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new Item(
                    i % 2 == 0 ? R.drawable.ic_touch_app_black_24dp : R.drawable.ic_launcher,
                    "Name" + i,
                    "Phone" + i));
        }
        //3.어댑터 준비 (어댑터에 데이타 꽂아서)
        ItemAdapter adapter = new ItemAdapter(this, items);
        //4.뷰에 어댑터 연결
        listView.setAdapter(adapter);


        // 클릭 이벤트 처리
        //======================================================================================//
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Long Click", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = (Item) parent.getAdapter().getItem(position);
//        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CoffeeActivity.class);
        intent.putExtra("name", item.getName());
        startActivity(intent);
    }

    // 옵션메뉴
    //==========================================================================================//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.coffee_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1_menu:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
