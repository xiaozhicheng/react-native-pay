package com.reactnativepay.payment;


/**
 * 支付公共接口
 * @author JPH
 * @Date 2015-8-25 下午4:37:05
 */
public interface Pay {
    /**
     * 发起支付请求
     * @param info
     * @param listener
     * @author JPH
     * @Date 2015-7-14 下午5:05:36
     */
    void pay(final PayInfo info, PayListener listener);
}
