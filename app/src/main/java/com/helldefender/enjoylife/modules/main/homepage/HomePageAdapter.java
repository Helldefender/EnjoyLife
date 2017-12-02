package com.helldefender.enjoylife.modules.main.homepage;

import android.content.Context;
import android.widget.FrameLayout;

import com.helldefender.enjoylife.R;
import com.helldefender.enjoylife.app.BaseAdapter;
import com.helldefender.enjoylife.app.BaseViewHolder;
import com.helldefender.enjoylife.app.MultiViewType;
import com.helldefender.enjoylife.widget.BannerView;
import com.helldefender.enjoylife.widget.recyclerview.RefreshHeaderLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helldefender on 2017/4/11.
 */

public class HomePageAdapter extends BaseAdapter<String> {

    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CONTENT = 2;

    public HomePageAdapter(Context context, MultiViewType<String> multiViewType, List<String> data, RefreshHeaderLayout refreshHeaderLayout, FrameLayout loadMoreFrameLayout) {
        super(context, multiViewType, data, refreshHeaderLayout, loadMoreFrameLayout);
    }

    @Override
    public void onBind(BaseViewHolder holder, String s, int position, int viewType) {
        if (viewType == TYPE_BANNER) {
            bindBanner(holder);
        } else {
            bindContent(holder);
        }
    }

    private void bindBanner(BaseViewHolder holder) {
        BannerView bannerView = holder.getView(R.id.carouselView);
        List<String> data = new ArrayList<String>();
        data.add("测试");
        data.add("测试");
        data.add("测试");
        bannerView.setImageUrls(data, data);
        bannerView.initUI();
        bannerView.startPlay();
    }

    private void bindContent(BaseViewHolder holder) {

    }
}