package com.helldefender.enjoylife.modules.main.discovery;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.helldefender.enjoylife.R;
import com.helldefender.enjoylife.modules.impl.DiscoveryPresenterImpl;
import com.helldefender.enjoylife.modules.community.detail.DetailContentActivity;
import com.helldefender.enjoylife.modules.main.discovery.organization.OrganizationRvAdapter;
import com.helldefender.enjoylife.app.BaseAdapter;
import com.helldefender.enjoylife.app.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Helldefender on 2017/2/16.
 */

public class DiscoveryFragment extends BaseFragment implements DiscoveryView {

    @Inject
    DiscoveryPresenterImpl discoveryPresenter;

    @BindView(R.id.rv_discovery_event)
    RecyclerView mEventRecyclerView;

    Unbinder unbinder;
    @BindView(R.id.tv_discovery_moreEvent)
    TextView tvDiscoveryMoreEvent;

    private OrganizationRvAdapter eventRvAdapter;

    @Override
    public void showLoadingLayout() {

    }

    @Override
    public void showEmptyLayout() {

    }

    @Override
    public void showErrorLayout(int message) {

    }

    @Override
    protected void initInject() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initPresenter() {
        mPresenter = discoveryPresenter;
        mPresenter.attachView(this);
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {
        //initPresenter();
        initRecyclerView();

        tvDiscoveryMoreEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHoldingActivity().startActivity(MoreEventActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected int getEmptyLayoutId() {
        return 0;
    }

    private void initRecyclerView() {
        List<String> data = new ArrayList<String>();
        data.add("我是数据");
        data.add("我是数据");
        data.add("我是数据");
        data.add("我是数据");
        data.add("我是数据");
        data.add("我是数据");
        data.add("我是数据");
        data.add("我是数据");
//
//        discoveryRecyclerView.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
//        discoveryRecyclerView.setAdapter(new DiscoveryRVAdapter(getHoldingActivity(), new MultiViewType<String>() {
//            @Override
//            public int getViewTypeSpanCount(int viewType) {
//                return 0;
//            }
//
//            @Override
//            public int getItemViewType(int position) {
//                if (position == 0) {
//                    return DiscoveryRVAdapter.DISCOVERY_TYPE_ORGANIZATION__TITLE;
//                } else if (position == 2) {
//                    return DiscoveryRVAdapter.DISCOVERY_TYPE_ORGANIZATION;
//                } else if (position == 3) {
//                    return DiscoveryRVAdapter.DISCOVERY_TYPE_EVENT_TITLE;
//                }
//                return DiscoveryRVAdapter.DISCOVERT_TYPE_EVENT;
//            }
//
//            @Override
//            public int getLayoutId(int viewType) {
//                if (viewType == DiscoveryRVAdapter.DISCOVERY_TYPE_ORGANIZATION__TITLE) {
//
//                }else if(viewType == DiscoveryRVAdapter.DISCOVERY_TYPE_ORGANIZATION){
//
//                } else if (viewType == DiscoveryRVAdapter.DISCOVERY_TYPE_EVENT_TITLE) {
//
//                }
//                return
//            }
//        }, data));

        eventRvAdapter = new OrganizationRvAdapter(getHoldingActivity(), R.layout.item_discovery_rv_event, data);
        mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
        mEventRecyclerView.setAdapter(eventRvAdapter);
        mEventRecyclerView.addItemDecoration(new DividerItemDecoration(getHoldingActivity(), DividerItemDecoration.VERTICAL));

        eventRvAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, int viewType) {
                getHoldingActivity().startActivity(DetailContentActivity.class);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}