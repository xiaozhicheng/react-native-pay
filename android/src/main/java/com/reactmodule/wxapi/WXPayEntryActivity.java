package com.reactmodule.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.reactmodule.wxpay.WXPay;
/**
 * Created by moker on 2017/4/13.
 */

public class WXPayEntryActivity extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WXPay.handlerIntent(getIntent());
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        WXPay.handlerIntent(intent);
    }
}
