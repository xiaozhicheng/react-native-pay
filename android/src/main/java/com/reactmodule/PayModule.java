package com.moker.bookteller.reactmodule;

import android.text.TextUtils;
import android.util.Log;

import com.moker.bookteller.reactmodule.alipay.AliPay;
import com.moker.bookteller.reactmodule.wxpay.WXPay;
import com.moker.bookteller.reactmodule.wxpay.WxpayInfo;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import java.util.Date;

/**
 * Created by cxz
 */
public class PayModule extends ReactContextBaseJavaModule{


    public PayModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }


    @ReactMethod
    public void onAliPay(String orderInfo, final Promise promise){

        Log.i("onAliPay","onAliPay-->"+orderInfo);

        if(!TextUtils.isEmpty(orderInfo)){
            AliPay aliPay = new AliPay(getCurrentActivity());
            aliPay.pay(orderInfo,new PayListener() {
                @Override
                public void onPaySuccess(String resultInfo) {
                    promise.resolve("支付成功");
                }
                @Override
                public void onPayFail(String code,String resultInfo) {
                    promise.reject(code,"支付失败");
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
            wxPayReq.setAppId(readableMap.getString(Constants.APPID));
            wxPayReq.setPartnerid(readableMap.getString(Constants.PARTNERID));
            wxPayReq.setPrepayid(readableMap.getString(Constants.PREPAYID));
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
                public void onPayFail(String code,String resultInfo) {
                    promise.reject(code,resultInfo);
                }
                @Override
                public void onPayConfirm(String resultInfo) {}
            });
        }
    }


    public String getTimeStamp(){

        return String.valueOf(System.currentTimeMillis()/1000);

    }



    @Override
    public String getName() {
            return "ReactNativePay";
    }
}


