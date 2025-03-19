package com.tylohelo.tylohelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes2.dex */
public class CustomListViewAdapter extends ArrayAdapter<Item> {
    Context context;

    public CustomListViewAdapter(Context context, int i, List<Item> list) {
        super(context, i, list);
        this.context = context;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView txtTitle;

        private ViewHolder() {
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Item item = getItem(i);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.txtTitle = (TextView) view.findViewById(R.id.textInScrollList);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.selectIcon);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (item != null) {
            viewHolder.txtTitle.setText(item.getTitle());
            viewHolder.imageView.setImageResource(item.getIconId());
        }
        return view;
    }
}
