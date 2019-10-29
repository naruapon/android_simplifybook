package com.example.supot.gridvwimg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] lstitle;
    int[] image;
    LayoutInflater inflater;

    public GridAdapter(Context context, String[] lstitle, int[] image){
        this.context = context;
        this.lstitle = lstitle;
        this.image = image;
    }
    @Override
    public int getCount() {
        return lstitle.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {//เมธอด getItemId()
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup  ) {
        TextView txttitle;
        ImageView imgflag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.grid_lst,viewGroup, false);

        txttitle = (TextView) itemView.findViewById(R.id.textView);

        imgflag = (ImageView) itemView.findViewById(R.id.imageView);
        txttitle.setText(lstitle[i]);

        // Capture position and set to the ImageView
        imgflag.setImageResource(image[i]);

        return itemView;
    }
}