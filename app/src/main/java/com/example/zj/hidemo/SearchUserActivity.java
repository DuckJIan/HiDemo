package com.example.zj.hidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by ZJ on 2017/8/23.
 */

public class SearchUserActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        final EditText searchName = (EditText)findViewById(R.id.find_name);
        Button btnFind = (Button)findViewById(R.id.btn_search);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"请输入好友名称",Toast.LENGTH_SHORT).show();
                }else{
                    query(searchName.getText().toString());
                }
            }
        });
    }
    private void query(String s) {
        BmobQuery<User> userList = new BmobQuery<>();
        userList.addWhereContains("username",s);
        userList.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null){
                    for (User user : list){
                        Log.d("searchUser", "done: "+user.getUsername());
                    }
                }
            }
        });
    }

}
