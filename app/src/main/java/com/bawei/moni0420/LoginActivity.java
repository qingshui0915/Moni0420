package com.bawei.moni0420;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.moni0420.bean.LoginBean;
import com.bawei.moni0420.loginmvp.LoginConstract;
import com.bawei.moni0420.loginmvp.LoginPresenter;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements LoginConstract.ILoginView {

    private LoginPresenter loginPresenter;
    private EditText login_name_et,login_pwd_et;
    private Button login_bl;
    private String sname,spwd;
    public static final String URL="http://172.17.8.100/small/user/v1/login";
    private LoginBean loginBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter();
        loginPresenter.accth(this);

        login_name_et = findViewById(R.id.login_name_et);
        login_pwd_et = findViewById(R.id.login_pwd_et);

        login_bl = findViewById(R.id.login_dl);
        login_bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = login_name_et.getText().toString();
                spwd = login_pwd_et.getText().toString();
                if (!sname.isEmpty()&&!spwd.isEmpty()){
                    loginPresenter.getlogin(URL,sname,spwd);
                }
            }
        });


    }

    @Override
    public void getData(String data) {
        Gson gson = new Gson();
        if (!data.isEmpty()){
            loginBean = gson.fromJson(data, LoginBean.class);
            Toast.makeText(this, loginBean.getMessage(),Toast.LENGTH_LONG).show();
            if (loginBean.getStatus().equals("0000")){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.decth();

    }
}
