package com.zhuoxin.zhang.mvpdemo.view;

/**
 * Created by Administrator on 2017/8/14.
 */

public interface ILoginActivity {
    String getUserName();
    String getPassword();
    void loginSuccessed(String str);
    void loginFailed(String error);
    void showProgress(int i);
    void showResult(String s);

}
