package com.cl.mywebview;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import static android.webkit.WebSettings.PluginState.ON;

/**
 *
 * @author admin
 * @date 2017-11-15
 */

public class HtmlActivity extends Activity{
    private WebView mWebViewHtml;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        mWebViewHtml = findViewById(R.id.web_view_html);
        String string = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><script language='JavaScript' type='text/JavaScript'>var sumbit_flg = true;function dosubmit() {var url = 'https://gateway.95516.com/gateway/api/frontTransReq.do';if (url == null) {alert('URL IS NULL');return;}if (sumbit_flg) {document.turn2bank.submit();}sumbit_flg = false;}</script></head><body onload='dosubmit();'><form name='turn2bank' action='https://gateway.95516.com/gateway/api/frontTransReq.do' method='post'><table style='width:100%'><input type='hidden' name='txnType' value='79' /><input type='hidden' name='frontUrl' value='https://www.xlpayment.com/bkg/OBKGPUB1/4420038.dow' /><input type='hidden' name='channelType' value='07' /><input type='hidden' name='currencyCode' value='156' /><input type='hidden' name='merId' value='891451047840028' /><input type='hidden' name='tokenPayData' value='{trId=62000000217&tokenType=01}' /><input type='hidden' name='txnSubType' value='00' /><input type='hidden' name='customerInfo' value='e3Bob25lTm89MTU5MTA0ODUzNjcmY2VydGlmSWQ9MTMwNDI5MTk5MDA4Mjg4MDE2JmNlcnRpZlRwPTAxJmN1c3RvbWVyTm095oiQ5Y+s6ZizfQ==' /><input type='hidden' name='version' value='5.0.0' /><input type='hidden' name='accType' value='01' /><input type='hidden' name='accNo' value='6225758339842840' /><input type='hidden' name='signMethod' value='01' /><input type='hidden' name='backUrl' value='https://www.xlpayment.com/bkg/OBKGPUB1/4420037.dow' /><input type='hidden' name='certId' value='70113171353' /><input type='hidden' name='encoding' value='UTF-8' /><input type='hidden' name='bizType' value='000902' /><input type='hidden' name='encryptCertId' value='69042905377' /><input type='hidden' name='orderId' value='UNWTZ20171116400281776645' /><input type='hidden' name='signature' value='m9It4IdhEBEXbTRtraJDsjIkwi71inZ/gNSDHqquF0Ao+MEp1AXCDultYHlrrqVaAst0BMLsQH/mTi0oK6duZRhuzyshHcErbq5CtHT4SmQkXexVttrNoy8rhisnAahH39sk0ji8vtFv7x1Kvit39DyVUqYJx2fydpNqAUvbCjugDT+bR2DbcHMJzr/NptQcQjMkKFGCY/mXzcNJ6tha2FqNj5ehHQ1ACBVsuVaqg+IMpQEMWdo+TreUg8arTcTQrB/G8iPu1ZOxukLQ9Pp9lT4Bi9G5I7BZdW5DfA/+7iJPvTutFfdblTlRAAejQbQQH8TOm1LlYskPjzxaZ83DZg==' /><input type='hidden' name='accessType' value='0' /><input type='hidden' name='txnTime' value='20171116152114' /></table></form></body></html>";
//        mWebViewHtml.loadDataWithBaseURL("about:blank", string, "text/html" , "utf-8", null);
        // 启用支持javascript
        WebSettings settings = mWebViewHtml.getSettings();
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);

        //如果访问的页面中有Javascript，则WebView必须设置支持Javascript
        //是否使用缓存
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);

        //设置js可以直接打开窗口，如window.open()，默认为false
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        //是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        settings.setJavaScriptEnabled(true);
        mWebViewHtml.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        //是否显示缩放按钮，默认false
        settings.setBuiltInZoomControls(true);
        settings.setSupportMultipleWindows(false);

        //设置此属性，可任意比例缩放。大视图模式
        settings.setUseWideViewPort(false);
        //是否可以缩放，默认true
        settings.setSupportZoom(false);
        settings.setPluginState(ON);

        //可以加载html5网页
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);

        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);

        // 加载index.html

        mWebViewHtml.loadDataWithBaseURL(null, string, "text/html" , "utf-8", null);
        mWebViewHtml.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                WebView.HitTestResult hitTestResult = view.getHitTestResult();
                if (!TextUtils.isEmpty(url) && hitTestResult == null) {
                    view.loadUrl(url);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // TODO Auto-generated method stub
                // 接受所有网站的证书
                handler.proceed();
            }
        });
    }

}
