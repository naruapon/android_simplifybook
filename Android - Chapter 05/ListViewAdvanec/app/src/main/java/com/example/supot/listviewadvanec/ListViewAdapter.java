package com.example.supot.listviewadvanec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {
    Context context;

    public static ArrayList<DataModel> modelArrayList;
    LayoutInflater inflater;
    public ListViewAdapter(Context context, ArrayList< DataModel> modelArrayList) {
         this.context = context;
        this.modelArrayList = modelArrayList;
       // this.image = image;
    }


    private class ViewHolder {
        private ImageView imgflag;
        private TextView txtName;
        private TextView txtDesc;
        protected  CheckBox checkBox;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }


    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_column, null, true);

            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            holder.txtName = (TextView) convertView.findViewById(R.id.textView);
            holder.txtDesc = (TextView) convertView.findViewById(R.id.textView2);
            holder.imgflag = (ImageView)  convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }


        //holder.checkBox.setText("Checkbox "+position);
        holder.txtName.setText(modelArrayList.get(position).getName());
        holder.txtDesc.setText(modelArrayList.get(position).getSubtitle());
        holder.checkBox.setChecked(modelArrayList.get(position).getSelected());
        holder.imgflag.setImageResource(modelArrayList.get(position).getImg());

       // holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag( position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // View tempview = (View) holder.checkBox.getTag(R.integer.btnplusview);
               // TextView tv = (TextView) tempview.findViewById(R.id.animal);
                Integer pos = (Integer)  holder.checkBox.getTag();
                Toast.makeText(context, "Checkbox "+pos+" clicked!", Toast.LENGTH_SHORT).show();

                if(modelArrayList.get(pos).getSelected()){
                    modelArrayList.get(pos).setSelected(false);
                }else {
                    modelArrayList.get(pos).setSelected(true);
                }
            }
        });
        return convertView;

    }
}
