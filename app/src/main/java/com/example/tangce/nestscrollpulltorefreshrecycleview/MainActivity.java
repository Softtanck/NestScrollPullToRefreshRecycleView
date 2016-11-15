package com.example.tangce.nestscrollpulltorefreshrecycleview;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tangce.nestscrollpulltorefreshrecycleview.adpater.ShopFragmentPagerAdapter;
import com.example.tangce.nestscrollpulltorefreshrecycleview.mode.ShopTypeResponse;
import com.example.tangce.nestscrollpulltorefreshrecycleview.utils.GsonUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button left_action;

    private TextView title;

    private ImageView right_action;

    private TabLayout tl_shop;

    private Toolbar toolbar;

    private ViewPager viewPager;

    private ShopFragmentPagerAdapter adapter;

    private List<ShopTypeResponse.MsgBean> list;

    private String titleString = "{\n" +
            "    \"desc\": null,\n" +
            "    \"code\": \"0000\",\n" +
            "    \"page\": null,\n" +
            "    \"msg\": [\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"name\": \"汽车座椅\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 3,\n" +
            "            \"name\": \"车窗挂饰\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            ",\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"汽车轮胎\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"token\": \"9a851f2c-91d8-461d-95c7-1bd90ea24f4c__1479199711563\"\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        left_action = (Button) findViewById(R.id.left_action);
        title = (TextView) findViewById(R.id.title);
        right_action = (ImageView) findViewById(R.id.right_action);
        tl_shop = (TabLayout) findViewById(R.id.tl_shop);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.vp_shop);
        left_action.setText("返回");
        title.setText("商城");
        toolbar.setTitle("");// 标题的文字需在setSupportActionBar之前，不然会无效
        setSupportActionBar(toolbar);
        ShopTypeResponse response = (ShopTypeResponse) GsonUtil.getInstance().convertJsonStringToObject(titleString, ShopTypeResponse.class);
        list = response.getMsg();
        adapter = new ShopFragmentPagerAdapter(getSupportFragmentManager(), getBaseContext(), list);
        viewPager.setAdapter(adapter);
        tl_shop.setupWithViewPager(viewPager);
        tl_shop.setTabMode(TabLayout.MODE_SCROLLABLE);
//        for (int i = 0; i < list.size(); i++) {
//            tl_shop.addTab(tl_shop.newTab().setText("标题:" + (i + 1)));
//        }
    }
}
