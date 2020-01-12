package com.example.demo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListCellAdapter extends BaseAdapter {
    private Context context=null;
    public ListCellAdapter(Context context){
        this.context=context;
    }

    public Context getContext() {
        return context;
    }

    int pic = R.drawable.music;
    private ListCellData[] data = new ListCellData[]{
            new ListCellData(pic,"1",1,"1"),
            new ListCellData(pic,"2",2,"1"),
            new ListCellData(pic,"3",3,"1"),
    };

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public ListCellData getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout ll=null;
        if(view!=null){
            ll= (LinearLayout) view;
        }else{
            ll= (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.item_main,null);
        }
        ListCellData data = (ListCellData) getItem(i);
        ImageView pic=ll.findViewById(R.id.image);
        TextView title=ll.findViewById(R.id.title);
        TextView instrument=ll.findViewById(R.id.instrument);
        TextView speed=ll.findViewById(R.id.speed);
        pic.setImageResource(data.getPic());
        title.setText(data.getTitle());
        String speedStr=data.getSpeed()+"";
        speed.setText(speedStr);
        instrument.setText(data.getInstrument());
        return ll;
    }
}
