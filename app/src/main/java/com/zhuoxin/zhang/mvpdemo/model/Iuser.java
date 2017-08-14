package com.zhuoxin.zhang.mvpdemo.model;

/**
 * Created by Administrator on 2017/8/14.
 */

public interface Iuser {
    void login(String username,String password,OnLoginListener onLoginListener);
    void load(OnLoadListener onLoadListener);
}
