package com.example.supot.samplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    String mModel = "GALAXY Note II";
    int p;
    String[] article;
    int[]  image;
    final static String ARG_POSITION = "position";
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        image = new int[] {
                R.drawable.note_two, R.drawable.galaxytab,R.drawable.tablet};
        article = new String[] {"\nคู่มือนำเสนอแอพที่มากับเครื่องครบทั้งโทร/แชต ดูหนัง/ฟังเพลง ท่องเน็ต และประยุกต์ใช้งานธุรกิจ Find my mobile" +
                " : ตามหาโทรศัพท์กรณีเครื่องหาย บันทึกและขีดเขียนได้ทุกสถานณการณ์ด้วย S Note ใช้คุณสมบัติใหม่ Air View, Popup Note, Quick Command  อัพเดตล่าสุด!" +
                " Android 4.1 Jelly Bean พร้อมสิ่งใหม่ใน Android 4.2 พร้อมเมนู 2 ภาษา (ไทย – อังกฤษ)\n",
                "\nเจาะลึก! ทุกแง่มุมการใช้งาน Samsung Galaxy Tabตั้งแต่อธิบายรายละเอียดทุกพื้นฐานเกี่ยวกับ Galaxy Tab และแอพที่มากับเครื่องครบทั้งโทร/แชต ดูหนัง/ฟังเพลง ท่องเน็ต" +
                        "ประยุกต์ใช้ Galaxy Tab ทั้งมัลติมีเดีย งานธุรกิจและโลกออนไลน์รวมทั้งสรุปการใช้งานแอพเด็ดที่พลาดไม่ได้\n",
                "\nเจาะลึก! ทุกเรื่องต้องรู้กับการงาน Android Tablet ทุกรุ่นตั้งแต่แนะนำรุ่นและทุกพื้นฐานเกี่ยวกับ Android Tabletครบทั้งโทร/แชต ดูหนัง/ฟังเพลง ท่องเน็ต" +
                        "ประยุกต์ใช้ Android Tablet ทั้งมัลติมีเดีย งานธุรกิจและโลกออนไลน์รวมทั้งสรุปการใช้งานแอพเด็ดที่พลาดไม่ได้\n"};

        Log.v("DetailFragment", "onActivityCreated()");

        showDetail(p);
    }

    public void showDetail(int position) {
        TextView tvtitle = (TextView) getView().findViewById(R.id.Sub_title);
        tvtitle.setText(mModel);
        TextView tvdetail = (TextView) getView().findViewById(R.id.detail_heading);
        ImageView imgflag = (ImageView) getView().findViewById(R.id.imageView);
        tvdetail.setText(article[position]);
        imgflag.setImageResource(image[position]);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("DetailFragment", "onCreateView()");

        if (savedInstanceState != null) {
            p = savedInstanceState.getInt(ARG_POSITION);
        }

        View view = inflater.inflate(R.layout.detail_view, container, false);
        return view;
    }

    public void setMobileContent(String Model,int position) {
        mModel = Model;
        p = position;
    }

    public void updateMobileContent(String Model,int position) {
        mModel = Model;
        p = position;
        showDetail(p);

    }
}