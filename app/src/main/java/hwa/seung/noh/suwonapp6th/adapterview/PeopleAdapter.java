package hwa.seung.noh.suwonapp6th.adapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hwa.seung.noh.suwonapp6th.R;

/**
 * Created by fontjuna on 2017-07-29.
 */

public class PeopleAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<People> mData;

    public PeopleAdapter(Context context, List<People> data) {
        mContext = context;
        mData = data;
    }

    // 데이타 갯수
    @Override
    public int getCount() {
        return mData.size();
    }

    // position번째의 어떤 아이템이 있는지 알려줘야함
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }


    // 데이타배이스의 id
    @Override
    public long getItemId(int position) {
        return position;
    }


    // position번째의 레이아웃 완성해서 알려줘야 함
    // convertView - position번째의 레이아웃 레퍼런스
    // parent - 이 어댑터가 붙을 부모의 레퍼런스(ListView나 GridView)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            //최초
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_exam, parent, false);
            holder = new ViewHolder();

            // 레이아웃 가져오기
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
            TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text);
            TextView phoneTextView = (TextView) convertView.findViewById(R.id.phone_text);
            holder.image = imageView;
            holder.name = nameTextView;
            holder.phone = phoneTextView;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        // data
        People people = (People) getItem(position);

        // 뿌리기
        holder.image.setImageResource(people.getPicture());
        holder.name.setText(people.getName());
        holder.phone.setText(people.getPhone());

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
    }
}
