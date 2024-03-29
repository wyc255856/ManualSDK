package com.faw.hongqi.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.faw.hongqi.R;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.widget.C229NativeInterface;


public class BrightSpotFragment extends BaseFragment {
    WebView webView;
    public static Activity context;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c229_bring;
    }
    @Override
    protected void initData() {
        context = getActivity();
    }

    @Override
    protected void initView(View view) {
        webView=view.findViewById(R.id.web_view);
        webView.getSettings().setAllowFileAccess(true);
        webView.setBackgroundColor(0);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }


            @Override

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript:itemLoaderHide()");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                LogUtil.logError("url = " + url);


               // if (Build.VERSION.SDK_INT < 26) {
                    view.loadUrl(url);
                    return true;

            }
        });
        //支持App内部javascript交互
        webView.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);



       // webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.addJavascriptInterface(new C229NativeInterface(), "Android");
        webView.getSettings().setDomStorageEnabled(true);
       // webView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
       // String appCachePath = mContext.getApplicationContext().getCacheDir().getAbsolutePath();
        //webView.getSettings().setAppCachePath(appCachePath);

        //webView.getSettings().setAppCacheEnabled(true);
        loadUrl();
    }

    private void loadUrl() {
        webView.loadUrl("http://www.haoweisys.com/c229_360/");
//        webView.loadUrl(Constant.TRIM_WEB_URL);
    }

    @Override
    protected void initWidgetActions() {

    }

    @Override
    public void refreshData() {

    }


}
