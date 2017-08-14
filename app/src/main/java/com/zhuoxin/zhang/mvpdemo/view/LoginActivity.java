package com.zhuoxin.zhang.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhuoxin.zhang.mvpdemo.R;
import com.zhuoxin.zhang.mvpdemo.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {

    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    protected LoginPresenter mLoginPresenter;
    @BindView(R.id.pb)
    ProgressBar mPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString().trim();
    }

    @Override
    public void loginSuccessed(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(int i) {
        mPb.setProgress(i);
    }

    @Override
    public void showResult(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {

        mLoginPresenter.login();
        mLoginPresenter.load();
    }


}
