package com.bc.ywj.dazhongdianping_cilent.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bc.ywj.dazhongdianping_cilent.R;
import com.bc.ywj.dazhongdianping_cilent.adapter.MyViewpagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    private Context mContext;
    private ArrayList<ImageView> list;
    private ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (ImageButton) findViewById(R.id.tiyan);
        vp = (ViewPager) findViewById(R.id.vp);
        mContext = this;
        getdata();
        vp.setAdapter(new MyViewpagerAdapter(list));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterHome();
            }
        });

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                System.out.println("当前滑动=====" + position);
                if (position == 3) {
                    btn.setVisibility(View.VISIBLE);
                } else {
                    btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    /**
     * 获得Viewpager的页面集合
     */
    private void getdata() {
        list = new ArrayList<ImageView>();
        int[] img = new int[]{
                R.drawable.guide_welcome,
                R.drawable.guide_01,
                R.drawable.guide_02,
                R.drawable.guide_03
        };

        for (int i = 0; i < img.length; i++) {
            ImageView iv = new ImageView(mContext);
            iv.setBackgroundResource(img[i]);
            list.add(iv);
        }

    }

    /**
     * 进入主页面
     */
    public void enterHome() {
        startActivity(new Intent(MainActivity.this, PageActivity.class));
        this.finish();
    }

    /**
     * 调用onActivityResult在处理完毕之后 在请求页面关闭之后
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        enterHome();
    }
}
