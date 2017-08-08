package hwa.seung.noh.suwonapp6th.another;

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
 * Created by fontjuna on 2017-08-08.
 */

public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<Item> mItems;

    public ItemAdapter(Context context, List<Item> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
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
                    .inflate(R.layout.ah_adpter, parent, false);
            holder=new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.ah_picture_image);
            holder.name = (TextView) convertView.findViewById(R.id.ah_name_text);
            holder.phone = (TextView) convertView.findViewById(R.id.ah_phone_text);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }

        Item item = (Item) getItem(position);
        holder.image.setImageResource(item.getImage());
        holder.name.setText(item.getName());
        holder.phone.setText(item.getPhone());

        return convertView;
    }

    private class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
    }
}
