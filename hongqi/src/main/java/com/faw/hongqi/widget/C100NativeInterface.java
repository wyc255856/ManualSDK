package com.faw.hongqi.widget;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.faw.hongqi.fragment.BrightFragment;
public class C100NativeInterface {
    GetId getId;
    public C100NativeInterface(GetId getId){
        this.getId = getId;
    }

    @JavascriptInterface
    public void JsTest(final String id,final String name) {
        BrightFragment.context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("","id----"+id+"      name----"+name);
                getId.getid(id);
            }
        });
    }
    public interface GetId{
        void getid(String id);
    }
}
