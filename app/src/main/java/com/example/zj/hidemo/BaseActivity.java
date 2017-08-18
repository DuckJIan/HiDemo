package com.example.zj.hidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ZJ on 2017/8/18.
 */

public class BaseActivity extends Activity {

    public void startActivity(Class<? extends Activity> target, Bundle bundle, boolean finish) {
        Intent intent = new Intent();
        intent.setClass(this, target);
        if (bundle != null)
            intent.putExtra(getPackageName(), bundle);
        startActivity(intent);
        if (finish)
            finish();
    }
}
