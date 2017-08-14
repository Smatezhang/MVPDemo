package com.zhuoxin.zhang.mvpdemo.model;

import android.os.AsyncTask;

/**
 * Created by Administrator on 2017/8/14.
 */

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    private OnLoadListener mOnLoadListener;


    public MyAsyncTask(OnLoadListener onLoadListener) {
        mOnLoadListener = onLoadListener;
    }


    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
                publishProgress(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mOnLoadListener.upDateProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        mOnLoadListener.setResult("下载成功");


    }
}
