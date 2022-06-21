package com.faw.hongqi.fragment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.Bright_Adapter;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.view.PagingScrollHelper;
import com.faw.hongqi.widget.C100NativeInterface;
import org.json.JSONArray;
import org.json.JSONException;
public class BrightFragment extends Fragment implements PagingScrollHelper.onPageChangeListener,
        Bright_Adapter.Bright_onclick1 , C100NativeInterface.GetId {
    WebView webView;
    public static Activity context;
    String jsonary;
    RecyclerView recyclerView;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private LinearLayoutManager hLinearLayoutManager = null;
    private DividerItemDecoration hDividerItemDecoration = null;
    private RecyclerView.ItemDecoration lastItemDecoration = null;
    Bright_Adapter bright_adapter;
    JSONArray bright_ary;
    public static final BrightFragment newInstance_bright(String jsonArray) {
        BrightFragment fragment = new BrightFragment();
        Bundle bundle = new Bundle();
        bundle.putString("jsonArray", jsonArray);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bright, container, false);
        bright_ary = new JSONArray();
        jsonary = getArguments().getString("jsonArray");
        recyclerView = view.findViewById(R.id.recy_bright_text);
        context = getActivity();
        webView = view.findViewById(R.id.webview_bright);
        webView.loadUrl("file:///android_asset/pano_2/index.html");
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
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError
                    error) {
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
                if (url != null) {
//                    if (!url.contains("mp4")) {
//                        LogUtil.logError("url = vr");
//                        webView.setLayerType(View.LAYER_TYPE_NONE, null);
//                    } else {
//                        LogUtil.logError("url = LAYER_TYPE_HARDWARE");
//                        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                    }
                }
                if (Build.VERSION.SDK_INT < 26) {
                    view.loadUrl(url);
                    return true;
                }
                LogUtil.logError("url = " + url);
                return false;
            }
        });
        //支持App内部javascript交互
        webView.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        //设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //设置是否出现缩放工具
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setLayerType(View.LAYER_TYPE_NONE, null);
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        WebSettings mWebSettings = webView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.addJavascriptInterface(new C100NativeInterface(this), "Android");
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        String appCachePath = getContext().getApplicationContext().getCacheDir().getAbsolutePath();
        webView.getSettings().setAppCachePath(appCachePath);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);


        return view;
    }
    public JSONArray setJSONARYLIST(int k ,JSONArray jsonArray){
       JSONArray jsona = new JSONArray();
        try {
            jsona = jsonArray.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getJSONArray("carContentTemplate");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsona;
    }
    @Override
    public void onPageChange(int index) {
    }
    @Override
    public void brightonItemClick1(int position) {
    }
    @Override
    public void getid(String id) {
        Log.e("id----",id);
        int n = 0;
        try {
            JSONArray jsonArray = new JSONArray(jsonary);
            for (int j = 0 ; j < jsonArray.length() ; j++){
                String jsons = jsonArray.getJSONObject(j).getJSONArray("sonContentlist").getJSONObject(0).getString("contentId");
                if (jsons != null && jsons.equals(id)){
                    n = j;
                }
            }
            bright_ary = setJSONARYLIST(n,new JSONArray(jsonary));

            bright_adapter = new Bright_Adapter(getContext(),bright_ary,this);

            LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
            layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            //设置布局管理器
            recyclerView.setLayoutManager(layoutManager1);
            recyclerView.setAdapter(bright_adapter);

            RecyclerView.LayoutManager layoutManager_ = null;
            RecyclerView.ItemDecoration itemDecoration = null;
            scrollHelper.setUpRecycleView(recyclerView);
            scrollHelper.setOnPageChangeListener(this);
            layoutManager_ = hLinearLayoutManager;
            itemDecoration = hDividerItemDecoration;
            if (layoutManager_ != null) {
                recyclerView.setLayoutManager(layoutManager_);
                recyclerView.removeItemDecoration(lastItemDecoration);
                recyclerView.addItemDecoration(itemDecoration);
                scrollHelper.updateLayoutManger();
                scrollHelper.scrollToPosition(0);
                lastItemDecoration = itemDecoration;
            }
            recyclerView.setHorizontalScrollBarEnabled(true);
            //获取总页数,采用这种方法才能获得正确的页数。否则会因为RecyclerView.State 缓存问题，页数不正确。
            recyclerView.post(new Runnable() {
                @Override
                public void run() {
//                tv_page_total.setText("共" + scrollHelper.getPageCount() + "页");
                }
            });


            bright_adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}