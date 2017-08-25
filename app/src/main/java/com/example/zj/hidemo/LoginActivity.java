package com.example.zj.hidemo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

import static cn.bmob.v3.BmobUser.getCurrentUser;

/**
 * Created by ZJ on 2017/8/18.
 */

public class LoginActivity extends BaseActivity {

//    @Bind(R.id.go_register)
//    Button go_register;
//
////    @Bind(R.id.user_login)
////    Button user_login;
//
////    @Bind(R.id.user_name)
////    EditText userName;
////
////    @Bind(R.id.user_password)
////    EditText userPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "755c86d48170605ed782566c9d370d44");

        Button go_register = (Button)findViewById(R.id.go_register);
        Button login = (Button)findViewById(R.id.user_login);
        final EditText userName = (EditText)findViewById(R.id.user_name);
        final EditText userPassword = (EditText)findViewById(R.id.user_password);

        go_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RegisterActivity.class,null,false);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                final LogInListener listener = new LogInListener() {
//                    @Override
//                    public void done(Object o, BmobException e) {
//                        startActivity(MainActivity.class,null,true);
//                    }
//
//                    @Override
//                    public void done(Object o, Object o2) {
//
//                    }
//                };
                User user = new User();
                user.setUsername(userName.getText().toString());
                user.setPassword(userPassword.getText().toString());
                user.login(new SaveListener<User>() {

                    @Override
                    public void done(User user, BmobException e) {
                        if (e == null)
                           startActivity(MainActivity.class,null,true);
                        else{
                            Toast.makeText(getApplicationContext(),"用户名或者密码不正确",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

//    @OnClick(R.id.go_register)
//    public void onRegisterClick(View view){
//        startActivity(RegisterActivity.class,null,false);
//    }

//    @OnClick(R.id.user_login)
//    public void onLoginClick(View view){
//        UserModel.getInstance().login(userName.toString(), userPassword.toString(), new LogInListener() {
//                    @Override
//                    public void done(Object o, BmobException e) {
//                        if (e == null){
//                            //登陆成功
//                            startActivity(MainActivity.class,null,false);
//                        }else{
//
//                        }
//                    }
//                });
//    }

}
