package com.reactnativepay.payment.wxpay;

/**
 * 微信支付接口所需参数(从服务器获取(安全)，或本地生成)
 * Author: JPH
 * Date: 2016/5/19 0019 16:03
 */
public class WXPayReq {
    //    {appid:"",partnerid:"",prepayid:"",packageValue:"",noncestr:"",timestamp:"",sign:"",sta	tus:""}
    int status;
    String appid;//应用ID
    String partnerid;//商户号
    String prepayid;// 预支付交易会话ID
    String packageValue;//扩展字段
    String noncestr;//随机字符串
    String timestamp;//时间戳
    String sign;//签名
    public WXPayReq() {
    }

    public WXPayReq(String appid, String noncestr, String packageValue, String partnerid, String prepayid, String sign, int status, String timestamp) {
        this.appid = appid;
        this.noncestr = noncestr;
        this.packageValue = packageValue;
        this.partnerid = partnerid;
        this.prepayid = prepayid;
        this.sign = sign;
        this.status = status;
        this.timestamp = timestamp;
    }

    public WXPayReq(String appid, String noncestr, String packageValue, String partnerid, String prepayid, String sign, String timestamp) {
        this.appid = appid;
        this.noncestr = noncestr;
        this.packageValue = packageValue;
        this.partnerid = partnerid;
        this.prepayid = prepayid;
        this.sign = sign;
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

