package com.faw.hongqi.adaptar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.faw.hongqi.R;
import com.faw.hongqi.holder.RvHolder;
import com.faw.hongqi.model.RightBean;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.FileUtil;
import com.faw.hongqi.util.GlideRoundTransform;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.widget.RvListener;

import java.io.File;
import java.util.List;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


public class ClassifyDetailAdapter extends RvAdapter<RightBean> {

    public ClassifyDetailAdapter(Context context, List<RightBean> list, RvListener listener) {
        super(context, list, listener);
    }


    @Override
    protected int getLayoutId(int viewType) {
        return viewType == 0 ? R.layout.item_title : R.layout.item_classify_detail;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).isTitle() ? 0 : 1;
    }

    @Override
    protected RvHolder getHolder(View view, int viewType) {
        return new ClassifyHolder(view, viewType, listener);
    }

    RequestOptions options = bitmapTransform(new GlideRoundTransform(30));

    public class ClassifyHolder extends RvHolder<RightBean> {
        TextView tvCity;
        ImageView avatar;
        TextView tvTitle;

        public ClassifyHolder(View itemView, int type, RvListener listener) {
            super(itemView, type, listener);
            switch (type) {
                case 0:
                    tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                    break;
                case 1:
                    tvCity = (TextView) itemView.findViewById(R.id.tvCity);
                    avatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
                    break;
            }

        }

        @Override
        public void bindHolder(RightBean sortBean, int position) {
            int itemViewType = ClassifyDetailAdapter.this.getItemViewType(position);
            switch (itemViewType) {
                case 0:
                    tvTitle.setText(sortBean.getTopTitle());
                    tvTitle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                    break;
                case 1:
                    tvCity.setText(sortBean.getTitle());
                    if (!TextUtils.isEmpty(sortBean.getHead_image())) {

//                        String url = FileUtil.getResPath() + sortBean.getHead_image().replace("HONGQIH9/standard/","");
                        String url = Constant.BASE_URL + sortBean.getHead_image();
                        LogUtil.logError("image url = " + url);
//                        File file = new File(FileUtil.getResPath() + sortBean.getHead_image().replace("HONGQIH9/standard/",""));
                        File file = new File(Constant.BASE_URL + sortBean.getHead_image());

//                        Glide.with(mContext)
//                                .load(url)
//                                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                                .placeholder(R.mipmap.download_error)
//                                .error(R.mipmap.download_error)
//                                .dontAnimate()
//                                .into(avatar);

                        RequestOptions options = new RequestOptions()
                                .centerCrop()
                                .placeholder(R.mipmap.down_error_content) //预加载图片
                                .error(R.mipmap.down_error_content) //加载失败图片
                                .priority(Priority.HIGH) //优先级
                                .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存
                                .transform(new GlideRoundTransform(8)); //圆角
                        Glide.with(mContext).load(url).apply(options).into(avatar);



                    } else {
                        String url = "images/2019-04-26/5cc2b440a0ab1.png";
                        Glide.with(mContext)
                                .load(url)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(R.mipmap.download_error)
                                .error(R.mipmap.download_error)
                                .dontAnimate()
                                .into(avatar);
                    }
                    break;
            }

        }
    }
}
