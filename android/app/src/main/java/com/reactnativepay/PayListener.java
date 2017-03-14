package com.reactnativepay;

/**
 * 支付监听器
 * @author CXZ
 */
public interface PayListener{

    /**
     * 支付成功
     * @param resultInfo 支付结果相关信息
     */
    void onPaySuccess(String resultInfo);
    /**
     * 支付失败
     * @param resultInfo 支付结果相关信息
     */
    void onPayFail(String resultInfo);
    /**
     * 订单创建等待用户支付
     * @param resultInfo 支付确认中
     */
    void onPayConfirm(String resultInfo);
}
