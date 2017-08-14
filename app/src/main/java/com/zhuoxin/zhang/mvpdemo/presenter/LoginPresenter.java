package com.zhuoxin.zhang.mvpdemo.presenter;

import com.zhuoxin.zhang.mvpdemo.model.OnLoadListener;
import com.zhuoxin.zhang.mvpdemo.model.OnLoginListener;
import com.zhuoxin.zhang.mvpdemo.model.UserBiz;
import com.zhuoxin.zhang.mvpdemo.view.LoginActivity;

/**
 * Created by Administrator on 2017/8/14.
 */

public class LoginPresenter implements ILoginPresenter{
    private UserBiz mUserBiz;
    private LoginActivity mLoginActivity;

    public LoginPresenter(LoginActivity loginActivity) {
        mLoginActivity = loginActivity;
        mUserBiz = new UserBiz();

    }

    @Override
    public void login() {
        mUserBiz.login(mLoginActivity.getUserName(), mLoginActivity.getPassword(), new OnLoginListener() {
            @Override
            public void onSuccessed(String msg) {
                mLoginActivity.loginSuccessed(msg);
            }

            @Override
            public void onFailed(String error) {
                mLoginActivity.loginFailed(error);
            }


        });
    }

    @Override
    public void load() {
        mUserBiz.load(new OnLoadListener() {
            @Override
            public void upDateProgress(int progress) {
                mLoginActivity.showProgress(progress);
            }

            @Override
            public void setResult(String s) {
                mLoginActivity.showResult(s);
            }
        });
    }


}
