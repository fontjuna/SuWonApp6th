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
 * Created by fontjuna on 2017-08-07.
 */

public class PeopleAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<People> mData;


    public PeopleAdapter(Context context, List<People> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_exam, parent, false);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
            TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text);
            TextView phoneTextView = (TextView) convertView.findViewById(R.id.phone_text);

            holder = new ViewHolder();
            holder.image = imageView;
            holder.name = nameTextView;
            holder.phone = phoneTextView;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        People people = (People) getItem(position);
        holder.image.setImageResource(people.getImage());
        holder.name.setText(people.getName());
        holder.phone.setText(people.getPhone());

        return convertView;
    }

    static class ViewHolder {
        private ImageView image;
        private TextView name;
        private TextView phone;
    }
}
