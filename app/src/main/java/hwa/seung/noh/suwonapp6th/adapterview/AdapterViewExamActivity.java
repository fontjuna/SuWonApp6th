package hwa.seung.noh.suwonapp6th.adapterview;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
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

public class AdapterViewExamActivity extends AppCompatActivity implements AlertDialog.OnClickListener {

    ArrayList<People> mPeopleData;
    PeopleAdapter mAdapter;
    EditText mWeatherEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_exam);

        ListView listView = (ListView) findViewById(R.id.list_view);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // 1단계 : 데이타 준비
        mPeopleData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int picture;
            if (i % 2 == 0) {
                picture = R.mipmap.ic_launcher;
            } else {
                picture = R.drawable.ic_touch_app_black_24dp;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            mPeopleData.add(people);
        }

        // 2단계 : 어댑터 준비
        mAdapter = new PeopleAdapter(AdapterViewExamActivity.this, mPeopleData);

        // 3단계 : 연결
        listView.setAdapter(mAdapter);
        gridView.setAdapter(mAdapter);
        spinner.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                People people = (People) parent.getAdapter().getItem(position);
                // Toast.makeText(AdapterViewExamActivity.this, people.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdapterViewExamActivity.this, DetailAddressActivity.class);
                intent.putExtra("name", people.getName());
                intent.putExtra("phone", people.getPhone());
                intent.putExtra("image", people.getImage());
                startActivity(intent);
            }
        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdapterViewExamActivity.this, "롱 클릭", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

        registerForContextMenu(listView);

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
            case R.id.menu_add:
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
        // 컨텍스트 메뉴가 최초로 한번만 호출되는 콜백 메서드
        Log.d("test", "onCreateContextMenu");
        getMenuInflater().inflate(R.menu.coffee_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        // 롱클릭했을 때 나오는 context Menu 의 항목을 선택(클릭) 했을 때 호출
        switch (item.getItemId()) {
            case R.id.item1_menu:
//                Toast.makeText(this, "1 번 클릭", Toast.LENGTH_SHORT).show();
                //삭제전 다이얼로그 띄워 삭제 물어봄
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("삭제");
                builder.setMessage("정말 삭제 합니까?");
                builder.setCancelable(false);
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //삭제
                        mPeopleData.remove(info.position);
                        //데이타가 변경되었음을 에댑터에게 통지하여 화면 갱신
                        mAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("아니오", this);
                builder.create().show();

                return true;
            case R.id.item2_menu:
                Toast.makeText(this, "2 번 클릭", Toast.LENGTH_SHORT).show();
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

        // 쓰기
        editor.apply();

        // 뒤로가기
        super.onBackPressed();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}

