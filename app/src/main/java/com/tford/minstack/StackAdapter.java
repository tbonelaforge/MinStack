package com.tford.minstack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by tford on 3/14/17.
 */
public class StackAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Integer[] integers;

    public StackAdapter(Context context, Integer[] integers) {
        inflater = LayoutInflater.from(context);
        this.integers = integers;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //Integer value = integers[position];
        Integer value = (Integer) getItem(position);
        if (view == null) {
            view = inflater.inflate(R.layout.stack_datum, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.stack_datum_text);
        textView.setText(String.valueOf(value));
        return view;
    }

    @Override
    public Object getItem(int position) {
        return integers[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return integers.length;
    }

    public void setIntegers(Integer[] integers) {
        this.integers = integers;
        notifyDataSetChanged();
    }

}
