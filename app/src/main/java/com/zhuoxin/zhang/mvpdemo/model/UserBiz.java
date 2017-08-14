package com.zhuoxin.zhang.mvpdemo.model;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2017/8/14.
 */

public class UserBiz implements Iuser {
    private  boolean isSuccessed;
    Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void login(String username,String password, final OnLoginListener onLoginListener) {
        if (username.length() ==0||password.length() < 6){
            onLoginListener.onFailed("用户名或者密码不符合");

            return;
        }else {

            new Thread() {
                @Override
                public void run() {
                   mHandler.post(new Runnable() {
                       @Override
                       public void run() {
                           if (isSuccessed){
                               onLoginListener.onFailed("登录失败");

                           }else {
                               onLoginListener.onSuccessed("登录成功");
                           }
                            isSuccessed = !isSuccessed;
                       }
                   });
                }
            }.start();
        }
    }

    @Override
    public void load(OnLoadListener onLoadListener) {
        MyAsyncTask mMyAsyncTask = new MyAsyncTask(onLoadListener);
        mMyAsyncTask.execute();
    }
}
