package com.reactnativepay.reactmodule;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.reactnativepay.Constants;
import com.reactnativepay.payment.PayInfo;
import com.reactnativepay.payment.PayListener;
import com.reactnativepay.paysdk.PaySDK;
import com.reactnativepay.payment.wxpay.WXPayReq;

/**
 * Created by cxz
 */
public class PayModule extends ReactContextBaseJavaModule{

    private String type = "alipay";
    private String payFlag = "";
    private String money = "0.0";
    private String traceNo;
    private ReadableMap wxReq;

    public PayModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void onPay(ReadableMap payReq, final Callback callback){
        if(payReq==null){
            callback.invoke(-1,"支付失败");
        }else {
            type = payReq.getString("type");
            payFlag = payReq.getString("payFlag");
            money = payReq.getString("money");

            if(type.equals(Constants.TYPE_ALI))  //获取商品号
                traceNo = payReq.getString(Constants.PKPAYORDER);
            else if(type.equals(Constants.TYPE_WX))
                wxReq = payReq.getMap(Constants.WXREQ);
            WXPayReq wxPayReq = new WXPayReq();
            if(wxReq!=null){
                wxPayReq.setAppid(wxReq.getString(Constants.APPID));
                wxPayReq.setPartnerid(wxReq.getString(Constants.PARTNERID));
                wxPayReq.setPrepayid(wxReq.getString(Constants.PREPAYID));
                wxPayReq.setPackageValue(wxReq.getString(Constants.PACKAGEVALUE));
                wxPayReq.setNoncestr(wxReq.getString(Constants.NONCESTR));
                wxPayReq.setTimestamp(wxReq.getString(Constants.TIMESTAMP));
                wxPayReq.setSign(wxReq.getString(Constants.SIGN));
                wxPayReq.setStatus(wxReq.getInt(Constants.STATUS));
            }

            PayInfo payInfo = new PayInfo(payFlag,money,payFlag,traceNo,wxPayReq);

            PaySDK paySDK = new PaySDK(getCurrentActivity(), type);

            paySDK.pay(payInfo,new PayListener() {
                @Override
                public void onPaySuccess(String resultInfo) {
                    callback.invoke(0,"支付成功");
                }
                @Override
                public void onPayFail(String resultInfo) {
                    callback.invoke(-1,"支付失败");
                }
                @Override
                public void onPayWait(String resultInfo) {


                }
            });



        }
    }

    @Override
    public String getName() {
            return "RnPay";
    }
}
