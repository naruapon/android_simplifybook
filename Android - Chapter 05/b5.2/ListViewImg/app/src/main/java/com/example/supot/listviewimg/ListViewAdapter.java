package com.example.supot.listviewimg;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by supot on 1/7/2560.
 */

public class ListViewAdapter extends BaseAdapter {
    Context context;
    String[] lstitle, Subtitle;
    int[] image;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] lstitle,String[] Subtitle, int[] image) {
        this.context = context;
        this.lstitle = lstitle;
        this.Subtitle = Subtitle;
        this.image = image;
    }

    @Override
    public int getCount() {
        return lstitle.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup  ) {
        TextView txttitle, txtsubtitle;
        ImageView imgflag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.row_column,viewGroup, false);

        txttitle = (TextView) itemView.findViewById(R.id.title);
        txtsubtitle = (TextView) itemView.findViewById(R.id.subtitle);

        imgflag = (ImageView) itemView.findViewById(R.id.imageView);
        txttitle.setText(lstitle[i]);
        txtsubtitle.setText(Subtitle[i]);

        // Capture position and set to the ImageView
        imgflag.setImageResource(image[i]);

        return itemView;
    }


}
