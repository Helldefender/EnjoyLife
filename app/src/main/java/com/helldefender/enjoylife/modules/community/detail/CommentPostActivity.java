package com.helldefender.enjoylife.modules.community.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.helldefender.enjoylife.R;
import com.helldefender.enjoylife.app.BaseActivity;

/**
 * Created by Helldefender on 2017/2/24.
 */

public class CommentPostActivity extends BaseActivity {

    private EditText contentEdit;

    private TextView releaseBtn;

    private LinearLayout placeHolderLayout;

    //private SubscriberOnNextListener commentPostListener;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean isEnable = contentEdit.getText().length() > 0;
            updateReleaseBtn(releaseBtn, isEnable);
        }
    };


    @Override
    public int getLayoutId() {
        return R.layout.activity_comment_post;
    }

    @Override
    public void initInject() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void widgetClick(View view) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpStatusBar(android.R.color.transparent);

        setUpContentEdit();

        setUpReleaseBtn();

        setPlaceHolderLayout();

        //initCommentPostListener();
    }

    private void setUpContentEdit() {
        contentEdit = (EditText) findViewById(R.id.post_comment_content_edit);
        contentEdit.addTextChangedListener(textWatcher);
    }

    private void setUpReleaseBtn() {
        releaseBtn = (TextView) findViewById(R.id.post_comment_release_btn);
        releaseBtn.setEnabled(false);

        releaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // HttpMethods.getInstance().
               // contentEdit.getText().toString();

            }
        });
    }

    private void setPlaceHolderLayout() {
        placeHolderLayout = (LinearLayout) findViewById(R.id.post_comment_place_holder_layout);

        placeHolderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//    private void initCommentPostListener() {
//        commentPostListener = new SubscriberOnNextListener<CommentBean>() {
//            @Override
//            public void onNext(CommentBean commentBean) {
//                //判断是否成功，刷新数据（for result）
//            }
//        };
//    }

    private void updateReleaseBtn(TextView releaseBtn, boolean isEnable) {
        releaseBtn.setEnabled(isEnable);
        releaseBtn.setTextColor(isEnable ? getResources().getColor(R.color.login_btn_enable) : getResources().getColor(R.color.login_btn_disable));
    }
}