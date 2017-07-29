package hwa.seung.noh.suwonapp6th.adapterview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import hwa.seung.noh.suwonapp6th.R;

public class AdapterViewExamActivity extends AppCompatActivity {

    private static final String TAG = AdapterViewExamActivity.class.getSimpleName();
    private ArrayList<People> mPeopleData;
    private PeopleAdapter mAdapter;
    private EditText mWeatherEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_exam);

        // view
        ListView listView = (ListView) findViewById(R.id.list_view);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // data
        mPeopleData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int picture;
            if (i % 2 == 0) {
                picture = R.drawable.ic_launcher;
            } else {
                picture = R.drawable.ic_touch_app_black_24dp;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            mPeopleData.add(people);
        }

        //adapter
        mAdapter = new PeopleAdapter(AdapterViewExamActivity.this, mPeopleData);

        listView.setAdapter(mAdapter);
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
                Intent intent = new Intent(AdapterViewExamActivity.this, DetailAddressActivity.class);
                intent.putExtra("name", people.getName());
                intent.putExtra("phone", people.getPhone());
                intent.putExtra("picture", people.getPicture());
                startActivity(intent);

            }
        });


//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdapterViewExamActivity.this, "롱 클릭", Toast.LENGTH_SHORT).show();
//                return true; // true의 경우 이벤트 소비를 하겠다. 더이상 이벤트가 흘러가지 않겠다
//                // 이벤트 소비를 제어 (false의 경우 "롱 클릭" 이 보인후 "그냥 클릭"도 보이게된다)
//            }
//        });

        // Context 메뉴 연결 - 롱 클릭과 같이 쓸수없다
        registerForContextMenu(listView);

        // Restore preferences
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String weather = settings.getString("weather", "맑음");
        mWeatherEditText = (EditText) findViewById(R.id.weather_edit);
        mWeatherEditText.setText(weather);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_address, menu);
        Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");

        int id = item.getItemId();


        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(AdapterViewExamActivity.this, DetailAddressActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_item1:
                Toast.makeText(this, "menu 1", Toast.LENGTH_SHORT).show();
                // 삭제
                mPeopleData.remove(info.position);
                // 업데이트
                mAdapter.notifyDataSetChanged();

                return true;
            case R.id.menu_item2:
                Toast.makeText(this, "menu 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        // 저장
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("weather", mWeatherEditText.getText().toString());

        // Commit the edits!
        editor.apply();

        // 뒤로가기
        super.onBackPressed();
    }
}
