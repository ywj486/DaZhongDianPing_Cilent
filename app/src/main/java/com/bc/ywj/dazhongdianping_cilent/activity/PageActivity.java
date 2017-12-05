package com.bc.ywj.dazhongdianping_cilent.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.bc.ywj.dazhongdianping_cilent.R;
import com.bc.ywj.dazhongdianping_cilent.entity.Tab;
import com.bc.ywj.dazhongdianping_cilent.fragment.FindFragment;
import com.bc.ywj.dazhongdianping_cilent.fragment.FirstPageFragment;
import com.bc.ywj.dazhongdianping_cilent.fragment.MineFragment;
import com.bc.ywj.dazhongdianping_cilent.fragment.TuanGouFragment;
import com.bc.ywj.dazhongdianping_cilent.wight.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class PageActivity extends AppCompatActivity {

    private FragmentTabHost mTabhost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);
        mInflater = LayoutInflater.from(this);
        initTab();
    }

    private void initTab() {
        Tab tab_firstPage = new Tab(FirstPageFragment.class, R.drawable.selector_icon_firstpage, R.string.firstPage);
        Tab tab_tuanGou = new Tab(TuanGouFragment.class, R.drawable.selector_icon_tuangou, R.string.tuanGou);
        Tab tab_find = new Tab(FindFragment.class, R.drawable.selector_icon_find, R.string.find);
        Tab tab_mine = new Tab(MineFragment.class, R.drawable.selector_icon_mine, R.string.mine);

        mTabs.add(tab_firstPage);
        mTabs.add(tab_tuanGou);
        mTabs.add(tab_find);
        mTabs.add(tab_mine);

        mTabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabhost.addTab(tabSpec, tab.getFragment(), null);
        }
        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);
        img.setImageResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;
    }
}
