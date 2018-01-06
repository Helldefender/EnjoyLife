package com.helldefender.communityfairs.app;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.helldefender.communityfairs.modules.community.detail.NewsDetailViewModel;
import com.helldefender.communityfairs.modules.main.MainViewModel;
import com.helldefender.communityfairs.modules.main.discovery.DiscoveryViewModel;
import com.helldefender.communityfairs.modules.main.homepage.HomePageViewModel;
import com.helldefender.communityfairs.modules.main.homepage.NewsItemViewModel;
import com.helldefender.communityfairs.modules.main.messsage.MessageViewModel;
import com.helldefender.communityfairs.modules.main.user.UserFragment;
import com.helldefender.communityfairs.modules.main.user.UserViewModel;

/**
 * Created by Helldefender on 2017/12/9 for CommunityFairs.
 * Function:
 * Description:
 */

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application application;

    private ViewModelFactory() {
        application = App.getInstance();
    }

    private static final class SingletonHolder {
        private static final ViewModelFactory instance = new ViewModelFactory();
    }

    public static ViewModelFactory getInstance() {
        return SingletonHolder.instance;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(application);
        } else if (modelClass.isAssignableFrom(HomePageViewModel.class)) {
            return (T) new HomePageViewModel(application);
        } else if (modelClass.isAssignableFrom(NewsItemViewModel.class)) {
            return (T) new NewsItemViewModel(application);
        } else if (modelClass.isAssignableFrom(DiscoveryViewModel.class)) {
            return (T) new DiscoveryViewModel(application);
        } else if (modelClass.isAssignableFrom(MessageViewModel.class)) {
            return (T) new MessageViewModel(application);
        } else if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(application);
        } else if (modelClass.isAssignableFrom(NewsDetailViewModel.class)) {
            return (T) new NewsDetailViewModel(application);
        } else {
            throw new IllegalArgumentException("向你抛出了一个异常--->未知的ViewModel类型:" + modelClass);
        }
    }
}
