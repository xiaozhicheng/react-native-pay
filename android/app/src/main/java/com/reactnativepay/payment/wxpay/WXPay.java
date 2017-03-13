package com.reactnativepay.payment.wxpay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.reactnativepay.paysdk.PayConfig;
import com.reactnativepay.payment.PayInfo;
import com.reactnativepay.payment.Pay;
import com.reactnativepay.payment.PayListener;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * 微信支付
 * @author CXZ
 */
public class WXPay implements Pay {

    public final static String ACTION = "com.pay.WXPayResultRecevier";

    private final IWXAPI msgApi;
    private Activity activity;
    private PayListener listener;
    private WXPayResultRecevier resultRecevier;

    public WXPay(Activity activity) {
        this.activity = activity;
        msgApi = WXAPIFactory.createWXAPI(activity, null);
        // sb = new StringBuffer();
        //注册微信支付结果广播接收器
        resultRecevier=new WXPayResultRecevier();
        msgApi.registerApp(PayConfig.APP_ID);
        IntentFilter filter=new IntentFilter();
        filter.addAction(WXPay.ACTION);
        filter.addCategory("android.intent.category.DEFAULT");
        activity.registerReceiver(resultRecevier, filter);//注册广播接收器receiver
    }

    /**
     * 发起支付
     */
    @Override
    public void pay(PayInfo payInfo, PayListener listener) {
        this.listener = listener;
        sendPayReq(payInfo);
    }

    /**
     * 发起支付
     * @param payInfo
     */
    private void sendPayReq(PayInfo payInfo) {
        msgApi.registerApp(PayConfig.APP_ID);
        msgApi.sendReq(getPayReq(payInfo));
    }

    private BaseReq getPayReq(PayInfo payInfo) {
        WXPayReq payReq=payInfo.getPayReq();
        PayReq req=new PayReq();
        req.appId = payReq.getAppid();
        req.partnerId =payReq.getPartnerid();
        req.prepayId =payReq.getPrepayid();
        req.packageValue = payReq.getPackageValue();
        req.nonceStr =payInfo.getTraceNo();
        req.timeStamp = payReq.getTimestamp();
        req.nonceStr = payReq.getNoncestr();
        req.sign =payReq.getSign();
        return req;
    }

    /**
     * 微信支付结果广播接收器
     */
    public class WXPayResultRecevier extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent data) {
//			builder.setMessage(getString(R.string.pay_result_callback_msg, resp.errStr +";code=" + String.valueOf(resp.errCode)));
            int errCode = data.getIntExtra("errCode", -1);
            String errStr = data.getStringExtra("errStr");
            // doc https://open.weixin.qq.com/zh_CN/htmledition/res/dev/document/sdk/android/index.html
            switch (errCode) {
                case BaseResp.ErrCode.ERR_OK:// 正确返回
                    listener.onPaySuccess("支付成功");
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL:// 用户取消
                    listener.onPayFail("用户取消");
                    break;
                default:
                    listener.onPayFail(errStr);
                    break;
            }
            activity.unregisterReceiver(resultRecevier);//取消注册微信支付结果广播接收器
        }
    }
}
