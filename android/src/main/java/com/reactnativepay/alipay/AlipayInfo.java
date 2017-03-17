package com.reactnativepay.alipay;

/**
 * Created by Saxon Cheng on 2017/3/14.
 */

public class AlipayInfo {

    private String money;
    private String subject;
    private String body;
    private String partner;
    private String sellerId;
    private String outTraceNo;
    private String notifyUrl;
    private String privateRsa;

    public AlipayInfo(String money, String subject, String body, String partner, String sellerId,String outTraceNo, String notifyUrl,String privateRsa) {
        this.money = money;
        this.subject = subject;
        this.body = body;
        this.partner = partner;
        this.outTraceNo = outTraceNo;
        this.sellerId = sellerId;
        this.notifyUrl = notifyUrl;
        this.privateRsa = privateRsa;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getOutTraceNo() {
        return outTraceNo;
    }

    public void setOutTraceNo(String outTraceNo) {
        outTraceNo = outTraceNo;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public void setPrivateRsa(String privateRsa) {
        this.privateRsa = privateRsa;
    }

    public String getPrivateRsa() {
        return privateRsa;
    }
}
