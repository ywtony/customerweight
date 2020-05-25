package com.yw.customerweight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yw.customerweight.R;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author 杨伟-tony
 * create by 2020/5/25 9:26
 */
public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<String> datas = new ArrayList<>();
    private LayoutInflater layoutInflater;
    public MainAdapter(Context context, List<String> datas) {
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view = layoutInflater.inflate(R.layout.main_item,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_name.setText(datas.get(i));
        return view;
    }

    class ViewHolder {
        public TextView tv_name;

        public ViewHolder(View view) {
            tv_name = view.findViewById(R.id.item_tv);
        }
    }
}
