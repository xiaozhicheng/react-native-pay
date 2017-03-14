package com.reactnativepay.wxpay;

/**
 * Created by Saxon Cheng on 2017/3/14.
 */

public class WxpayInfo {

    private String money;
    private String title;
    private String appId;
    private String partnerid;
    private String parpayid;
    private String packageValue;
    private String noncestr;
    private String timestamp;
    private String sign;

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getParpayid() {
        return parpayid;
    }

    public void setParpayid(String parpayid) {
        this.parpayid = parpayid;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
