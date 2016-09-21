package com.example.tangce.nestscrollpulltorefreshrecycleview;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button left_action;

    private TextView title;

    private ImageView right_action;

    private TabLayout tl_shop;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inti();
    }

    private void inti() {
        left_action = (Button) findViewById(R.id.left_action);
        title = (TextView) findViewById(R.id.title);
        right_action = (ImageView) findViewById(R.id.right_action);
        tl_shop = (TabLayout) findViewById(R.id.tl_shop);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");// 标题的文字需在setSupportActionBar之前，不然会无效
        setSupportActionBar(toolbar);
    }
}
