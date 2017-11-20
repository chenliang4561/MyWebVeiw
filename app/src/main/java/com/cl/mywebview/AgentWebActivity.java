package com.cl.mywebview;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.just.library.AgentWeb;

/**
 * AgentWeb
 * @author admin
 * @date 2017-11-14
 */

public class AgentWebActivity extends Activity{

    private String mUrl;
    private LinearLayout llAgentWebView;
    private AgentWeb mAgentWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_web);
        mUrl = getIntent().getStringExtra("URL");
        initView();
    }

    private void initView() {
        llAgentWebView = findViewById(R.id.ll_agent_web);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
        mAgentWeb = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(llAgentWebView, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .createAgentWeb()
                .ready()
                .go(mUrl);
    }
}
