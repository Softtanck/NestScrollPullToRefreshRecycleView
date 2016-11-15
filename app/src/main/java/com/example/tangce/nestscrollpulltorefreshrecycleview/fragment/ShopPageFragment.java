package com.example.tangce.nestscrollpulltorefreshrecycleview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.tangce.nestscrollpulltorefreshrecycleview.R;
import com.example.tangce.nestscrollpulltorefreshrecycleview.adpater.ShopListAdapter;
import com.example.tangce.nestscrollpulltorefreshrecycleview.mode.ShopListResponse;
import com.example.tangce.nestscrollpulltorefreshrecycleview.utils.GsonUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ShopPageFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2 {

    public static final String ARG_PAGE = "ARG_PAGE";

    public static final String ARG_ID = "ARG_ID";

    private static final String ARG_NAME = "ARG_NAME";

    private String currentName;

    private int mPage;

    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    private boolean isLoaded;//是否已经联网加载过数据了

    private PullToRefreshRecyclerView recyclerView;

    private LinearLayout fl_shop_page_empty;//空布局

    private int currentPage = 1;

    private int currentId;

    private List<ShopListResponse.MsgBean> list = new ArrayList<>();

    private ShopListAdapter adapter;

    private int total;

    private boolean isHeadRefresh = false;

    private boolean isEmpty;

    private String mSortType;//当前排序类型

    private String mKeyWord;//当前关键字

    private String content = "{\n" +
            "    \"desc\": null,\n" +
            "    \"code\": \"0000\",\n" +
            "    \"page\": {\n" +
            "        \"pageSize\": 10,\n" +
            "        \"total\": 9,\n" +
            "        \"pageNumber\": 1\n" +
            "    },\n" +
            "    \"msg\": [\n" +
            "        {\n" +
            "            \"id\": 9,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_b85ea51b-7f03-4a65-a289-143f21a581c0.jpg\",\n" +
            "            \"stock\": 51,\n" +
            "            \"fullName\": \"儿童安全座椅超级百变王 快乐长颈鹿\",\n" +
            "            \"price\": 1588,\n" +
            "            \"sales\": 9\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 8,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_b0643636-0ead-4ca2-9339-468a43451ed8.jpg\",\n" +
            "            \"stock\": 53,\n" +
            "            \"fullName\": \"宝得适 britax 儿童安全座椅超级百变王白金版 闪电黑\",\n" +
            "            \"price\": 1880,\n" +
            "            \"sales\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 6,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_28a40159-1ade-4d54-86f1-831db3a61f9a.jpg\",\n" +
            "            \"stock\": 53,\n" +
            "            \"fullName\": \"Dota2夏季凉席座椅\",\n" +
            "            \"price\": 200,\n" +
            "            \"sales\": 11\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 14,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_1b4c9f4a-bddf-4365-9d7b-f6a80d087bc4.jpg\",\n" +
            "            \"stock\": 53,\n" +
            "            \"fullName\": \"儿童安全座椅多普乐 闪电黑\",\n" +
            "            \"price\": 2599,\n" +
            "            \"sales\": 50\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_c91879d4-e570-4447-9c4b-51f460e53f5c.jpg\",\n" +
            "            \"stock\": 53,\n" +
            "            \"fullName\": \"熊猫太空座椅AAA\",\n" +
            "            \"price\": 500,\n" +
            "            \"sales\": 67\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 13,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_53dd34cf-9fd6-4949-a792-120d70677820.jpg\",\n" +
            "            \"stock\": 52,\n" +
            "            \"fullName\": \"迈可适 MAXI-COSI 佩泊 婴儿汽车座椅 粉色\",\n" +
            "            \"price\": 1799,\n" +
            "            \"sales\": 88\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 10,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_45fae34a-dc76-49cc-9e53-2926f4d6b833.jpg\",\n" +
            "            \"stock\": 53,\n" +
            "            \"fullName\": \"宝得适 britax 儿童安全座椅头等舱 辣椒红\",\n" +
            "            \"price\": 1880,\n" +
            "            \"sales\": 5\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 15,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_72ff9bfd-4536-4721-939a-fada4f6d2121.jpg\",\n" +
            "            \"stock\": 51,\n" +
            "            \"fullName\": \"佩泊婴儿汽车座椅 经典蓝\",\n" +
            "            \"price\": 899,\n" +
            "            \"sales\": 11\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 7,\n" +
            "            \"image\": \"/upload/tenant/1/productImage/src_23dd7fc8-105c-434d-8a28-0c3a0bb838da.jpg\",\n" +
            "            \"stock\": 32,\n" +
            "            \"fullName\": \"多彩火影主题儿童座椅\",\n" +
            "            \"price\": 88,\n" +
            "            \"sales\": 2\n" +
            "        }\n" +
            "    ],\n" +
            "    \"token\": \"9a851f2c-91d8-461d-95c7-1bd90ea24f4c__1479199712427\"\n" +
            "}";

    public static ShopPageFragment newInstance(int page, int id, String name) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putInt(ARG_ID, id);
        args.putString(ARG_NAME, name);
        ShopPageFragment pageFragment = new ShopPageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        currentId = getArguments().getInt(ARG_ID);
        currentName = getArguments().getString(ARG_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = ((PullToRefreshRecyclerView) ((RelativeLayout) view).getChildAt(1));
        ShopListResponse response = (ShopListResponse) GsonUtil.getInstance().convertJsonStringToObject(content, ShopListResponse.class);
        list = response.getMsg();
        adapter = new ShopListAdapter(getActivity(), list);
        recyclerView.getRefreshableView().setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.getRefreshableView().setAdapter(adapter);
        recyclerView.getRefreshableView().setEmptyView(fl_shop_page_empty);
        recyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        recyclerView.setOnRefreshListener(this);
        recyclerView.getRefreshableView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) { //滑动的时候对RecycleView的优化
                if (newState == RecyclerView.SCROLL_STATE_IDLE) { // 滑动的时候暂停加载
                    Picasso.with(getActivity()).resumeTag(getActivity());
                } else {
                    Picasso.with(getActivity()).pauseTag(getActivity());
                }
            }
        });
        isPrepared = true;
    }


//        if (list.size() < total) {
//            recyclerView.onRefreshComplete();
//            recyclerView.setMode(PullToRefreshBase.Mode.BOTH);
//        } else {
//            recyclerView.onRefreshComplete();
//            recyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
//        }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        currentPage = 1;
//        list.clear();
        isHeadRefresh = true;
        if (-1 == currentId)
            mKeyWord = currentName;
        recyclerView.onRefreshComplete();
//        sendPacket(1, currentId, mSortType, mKeyWord);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentPage++;
        isHeadRefresh = false;
        if (-1 == currentId)
            mKeyWord = currentName;
        recyclerView.onRefreshComplete();
//        sendPacket(1, currentId, mSortType, mKeyWord);
    }

}
