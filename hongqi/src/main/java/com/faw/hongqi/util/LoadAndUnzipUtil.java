package com.faw.hongqi.util;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.model.VersionUpdateModel;
import com.faw.hongqi.ui.C229SelectCarModelActivity;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;

public class LoadAndUnzipUtil {
    static BaseDownloadTask singleTask;
    public static int singleTaskId = 0;
    public  static  String saveZipFilePath = FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
            + File.separator + "MyFolder";
    private static String TAG = LoadAndUnzipUtil.class.getSimpleName();
    private static String fileName;

    public static void startDownloadNews(final Activity context, String downloadUrl, final VersionUpdateModel model) {
        singleTask = FileDownloader.getImpl().create(downloadUrl)
                .setPath(saveZipFilePath, true)
                .setCallbackProgressTimes(300)
                .setMinIntervalUpdateSpeed(400)
                .setListener(new FileDownloadSampleListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.pending(task, soFarBytes, totalBytes);
                    }
                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.e(TAG, "----->progress taskId:" + task.getId() + ",soFarBytes:" + soFarBytes + ",totalBytes:" + totalBytes
                                + ",percent:" + soFarBytes * 1.0 / totalBytes + ",speed:" + task.getSpeed());
                        super.progress(task, soFarBytes, totalBytes);
                    }
                    @Override
                    protected void blockComplete(BaseDownloadTask task) {
                        Log.e(TAG, "----------->blockComplete taskId:" + task.getId() + ",filePath:" + task.getPath() +
                                ",fileName:" + task.getFilename() + ",speed:" + task.getSpeed() + ",isReuse:" + task.reuse());
                        fileName = task.getFilename();
                        context.runOnUiThread(new Runnable() {
                            public void run() {
                                //下载完成
                                DBUtil.getInstance().initData(context);
                                Intent intent = new Intent(context,C229SelectCarModelActivity.class);
                                intent.putExtra("data",model);
                                context.startActivity(intent);
                                context.finish();

                            }
                        });
                        super.blockComplete(task);
                    }
                    @Override
                    protected void completed(BaseDownloadTask task) {
                        Log.e(TAG, "---------->completed taskId:" + task.getId() + ",isReuse:" + task.reuse());
                        super.completed(task);
                    }
                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.paused(task, soFarBytes, totalBytes);
                    }
                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        Log.e(TAG, "--------->error taskId:" + task.getId() + ",e:" + e.getLocalizedMessage());
                        super.error(task, e);
                    }
                    @Override
                    protected void warn(BaseDownloadTask task) {
                        super.warn(task);
                    }
                });
        singleTaskId = singleTask.start();

    }
    public static void startDownloadCategory(final Activity context,String downloadUrl) {
        singleTask = FileDownloader.getImpl().create(downloadUrl)
                .setPath(saveZipFilePath, true)
                .setCallbackProgressTimes(300)
                .setMinIntervalUpdateSpeed(400)
                .setListener(new FileDownloadSampleListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.pending(task, soFarBytes, totalBytes);
                    }
                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.e(TAG, "----->progress taskId:" + task.getId() + ",soFarBytes:" + soFarBytes + ",totalBytes:" + totalBytes
                                + ",percent:" + soFarBytes * 1.0 / totalBytes + ",speed:" + task.getSpeed());
                        super.progress(task, soFarBytes, totalBytes);
                    }
                    @Override
                    protected void blockComplete(BaseDownloadTask task) {
                        Log.e(TAG, "----------->blockComplete taskId:" + task.getId() + ",filePath:" + task.getPath() +
                                ",fileName:" + task.getFilename() + ",speed:" + task.getSpeed() + ",isReuse:" + task.reuse());
                        fileName = task.getFilename();
                        context.runOnUiThread(new Runnable() {
                            public void run() {
                                //下载完成
                                DBUtil.getInstance().initData(context);
                            }
                        });
                        super.blockComplete(task);
                    }
                    @Override
                    protected void completed(BaseDownloadTask task) {
                        Log.e(TAG, "---------->completed taskId:" + task.getId() + ",isReuse:" + task.reuse());
                        super.completed(task);
                    }
                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.paused(task, soFarBytes, totalBytes);
                    }
                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        Log.e(TAG, "--------->error taskId:" + task.getId() + ",e:" + e.getLocalizedMessage());
                        super.error(task, e);
                    }
                    @Override
                    protected void warn(BaseDownloadTask task) {
                        super.warn(task);
                    }
                });
        singleTaskId = singleTask.start();
    }

}
