#############################################
#
# 对于一些基本指令的添加
#
#############################################
# 代码混淆压缩比，在 0~7 之间，默认为 5，一般不做修改
-optimizationpasses 5

# 混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames

# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses

# 这句话能够使我们的项目混淆后产生映射文件
# 包含有类名->混淆后类名的映射关系
-verbose

# 指定不去忽略非公共库的类成员
-dontskipnonpubliclibraryclassmembers

# 不做预校验，preverify 是 proguard 的四个步骤之一，Android 不需要 preverify，去掉这一步能够加快混淆速度。
-dontpreverify

# 保留 Annotation 不混淆
-keepattributes *Annotation*,InnerClasses

# 避免混淆泛型
-keepattributes Signature

# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

# 指定混淆是采用的算法，后面的参数是一个过滤器
# 这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !code/simplification/cast,!field/*,!class/merging/*


#############################################
#
# Android开发中一些需要保留的公共部分
#
#############################################

# 保留我们使用的四大组件，自定义的 Application 等等这些类不被混淆
# 因为这些子类都有可能被外部调用
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Appliction
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService


# 保留 support 下的所有类及其内部类
-keep class android.support.** { *; }

# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**

# 保留 R 下面的资源
-keep class **.R$* { *; }

# 保留本地 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# 保留在 Activity 中的方法参数是view的方法，
# 这样以来我们在 layout 中写的 onClick 就不会被影响
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

# 保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保留我们自定义控件（继承自 View）不被混淆
-keep public class * extends android.view.View {
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# 保留 Parcelable 序列化类不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# 保留 Serializable 序列化的类不被混淆
-keepnames class * implements java.io.Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# 对于带有回调函数的 onXXEvent、**On*Listener 的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}

# webView 处理，项目中没有使用到 webView 忽略即可
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
    public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

# js
-keepattributes JavascriptInterface
-keep class android.webkit.JavascriptInterface { *; }
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# @Keep
-keep,allowobfuscation @interface android.support.annotation.Keep
-keep @android.support.annotation.Keep class *
-keepclassmembers class * {
    @android.support.annotation.Keep *;
}


#所有 jar 都防混
-libraryjars libs


#-----防止某些控件动画异常-----------·
-keepclassmembers class android.support.** { public void setRotation(android.view.View, float); }
-keepclassmembers class android.support.** { public void setScaleX(android.view.View, float); }
-keepclassmembers class android.support.** { public void setScaleY(android.view.View, float); }
-keepclassmembers class android.support.** { public void setTranslationX(android.view.View, float); }
-keepclassmembers class android.support.** { public void setTranslationY(android.view.View, float); }
-keepclassmembers class android.support.** { public void setTranslationZ(android.view.View, float); }
-keepclassmembers class android.support.** { public void setAlpha(android.view.View, float); }
-keepclassmembers class android.support.** { public void setElevation(android.view.View, float); }
-keepclassmembers class android.support.** { public void setPivotX(android.view.View, float); }
-keepclassmembers class android.support.** { public void setPivotY(android.view.View, float); }

-keepclassmembers class android.support.** { public void setRotation(float); }
-keepclassmembers class android.support.** { public void setScaleX(float); }
-keepclassmembers class android.support.** { public void setScaleY(float); }
-keepclassmembers class android.support.** { public void setTranslationX(float); }
-keepclassmembers class android.support.** { public void setTranslationY(float); }
-keepclassmembers class android.support.** { public void setTranslationZ(float); }
-keepclassmembers class android.support.** { public void setAlpha(float); }
-keepclassmembers class android.support.** { public void setElevation(float); }
-keepclassmembers class android.support.** { public void setPivotX(float); }
-keepclassmembers class android.support.** { public void setPivotY(float); }

-keepclassmembers class android.support.** { public float getRotation(float); }
-keepclassmembers class android.support.** { public float getScaleX(float); }
-keepclassmembers class android.support.** { public float getScaleY(float); }
-keepclassmembers class android.support.** { public float getTranslationX(float); }
-keepclassmembers class android.support.** { public float getTranslationY(float); }
-keepclassmembers class android.support.** { public float getTranslationZ(float); }
-keepclassmembers class android.support.** { public float getAlpha(float); }
-keepclassmembers class android.support.** { public float getElevation(float); }
-keepclassmembers class android.support.** { public float getPivotX(float); }
-keepclassmembers class android.support.** { public float getPivotY(float); }


#环信混淆规则
-keep class org.xmlpull.** {*;}
-keep class com.hyphenate.** {*;}
-keep class com.hyphenate.chat.** {*;}
-dontwarn  com.hyphenate.**
-keep class org.jivesoftware.** {*;}
-keep class org.apache.** {*;}
#2.0.9后加入语音通话功能，如需使用此功能的api，加入以下keep
-keep class net.java.sip.** {*;}
-keep class org.webrtc.voiceengine.** {*;}
-keep class org.bitlet.** {*;}
-keep class org.slf4j.** {*;}
-keep class ch.imvs.** {*;}
-keep class com.superrtc.** { *; }
#mainacitvity 中运用到反射所以需要免混#
-keep class com.qiming.hqzl.app.MainActivity{ *; }
#gson
-keep class com.faw.hongqi.model.** { *; }
-keep class com.faw.hongqi.ui.C229WelccomeActivity { *; }
-keep class com.faw.hongqi.ui.C229LoadAndUnzipFileActivity { *; }
-keep class com.faw.hongqi.util.LoadAndUnzipUtil { *; }
#-keep interface com.faw.hongqi.model.** { *; }
#-keep class com.faw.hongqi.model.upgrade.internal.VersionInfo {*;}

#遇到警告的时候，忽略警告继续执行ProGuard，不建议添加此项。
-ignorewarnings









