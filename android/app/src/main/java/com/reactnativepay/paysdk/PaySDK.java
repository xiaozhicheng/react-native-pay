package com.reactnativepay.paysdk;

import android.app.Activity;

import com.reactnativepay.Constants;
import com.reactnativepay.payment.Pay;
import com.reactnativepay.payment.PayInfo;
import com.reactnativepay.payment.PayListener;
import com.reactnativepay.payment.alipay.AliPay;
import com.reactnativepay.payment.wxpay.WXPay;


/**
 * 支付SDK,支持微信支付，支付宝支付
 * @author JPH
 * @Date 2015-8-25 下午4:24:32
 */
public class PaySDK {

    private Pay pay;

    public PaySDK(Activity activity, String type) {
        if(type.equals(Constants.TYPE_WX))
            pay=new WXPay(activity);
        else if(type.equals(Constants.TYPE_ALI)){
            pay=new AliPay(activity);
        }
    }


    /**
     * 发起支付
     * @param info 支付信息实体
     * @param listener 支付结果监听器
     * @author JPH
     * @Date 2015-8-25 下午4:44:52
     */
    public void pay(PayInfo info, PayListener listener) {
        pay.pay(info, listener);
    }
}
