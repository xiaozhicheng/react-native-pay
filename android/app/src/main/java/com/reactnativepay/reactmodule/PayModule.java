package com.reactnativepay.reactmodule;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.reactnativepay.Constants;
import com.reactnativepay.alipay.AlipayInfo;
import com.reactnativepay.PayListener;
import com.reactnativepay.alipay.AliPay;
import com.reactnativepay.wxpay.WXPay;
import com.reactnativepay.wxpay.WxpayInfo;

/**
 * Created by cxz
 */
public class PayModule extends ReactContextBaseJavaModule{


    public PayModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }


    @ReactMethod
    public void onAliPay(ReadableMap readableMap, final Promise promise){
        if(readableMap==null){
            promise.reject("-1","支付失败");
        }else {
            String money = readableMap.getString(Constants.MONEY);
            String subject = readableMap.getString(Constants.SUBJECT);
            String body = readableMap.getString(Constants.BODY);
            String partner = readableMap.getString(Constants.PARTNER);
            String sellerid = readableMap.getString(Constants.SELLERID);
            String outtraceno = readableMap.getString(Constants.OUTTRACENO);
            String notifyurl = readableMap.getString(Constants.NOTIFYURL);
            String privatersa = readableMap.getString(Constants.PRIVATERSA);

            AlipayInfo payInfo = new AlipayInfo(money,subject,body,partner,sellerid,outtraceno,notifyurl,privatersa);
            AliPay aliPay = new AliPay(getCurrentActivity());
            aliPay.pay(payInfo,new PayListener() {
                @Override
                public void onPaySuccess(String resultInfo) {
                    promise.resolve("支付成功");
                }
                @Override
                public void onPayFail(String resultInfo) {
                    promise.reject("-1","支付失败");
                }
                @Override
                public void onPayConfirm(String resultInfo) {}
            });
        }
    }


    @ReactMethod
    public void onWxPay(ReadableMap readableMap, final Promise promise){
        if(readableMap==null){
            promise.reject("-1","支付失败");
        }else {
            WxpayInfo wxPayReq = new WxpayInfo();
            wxPayReq.setTitle(readableMap.getString("title"));
            wxPayReq.setMoney(readableMap.getString("money"));
            wxPayReq.setAppId(readableMap.getString(Constants.APPID));
            wxPayReq.setPartnerid(readableMap.getString(Constants.PARTNERID));
            wxPayReq.setParpayid(readableMap.getString(Constants.PARTNERID));
            wxPayReq.setPackageValue(readableMap.getString(Constants.PACKAGEVALUE));
            wxPayReq.setNoncestr(readableMap.getString(Constants.NONCESTR));
            wxPayReq.setTimestamp(readableMap.getString(Constants.TIMESTAMP));
            wxPayReq.setSign(readableMap.getString(Constants.SIGN));
            WXPay wxPay = new WXPay(getCurrentActivity(),wxPayReq);
            wxPay.pay(new PayListener() {
                @Override
                public void onPaySuccess(String resultInfo) {
                    promise.resolve("支付成功");
                }
                @Override
                public void onPayFail(String resultInfo) {
                    promise.reject("-1","支付失败");
                }
                @Override
                public void onPayConfirm(String resultInfo) {}
            });
        }
    }

    @Override
    public String getName() {
            return "RnPay";
    }
}
