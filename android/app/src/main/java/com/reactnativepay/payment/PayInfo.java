package com.reactnativepay.payment;


import com.reactnativepay.payment.wxpay.WXPayReq;

/**
 * 支付信息实体类
 * @author CXZ
 */
public class PayInfo {
    /**商品详情**/
    private String subject;
    /**商品描述，detail**/
    private String body;
    /**支付金额单位为元**/
    private String price;
    private String traceNo;
    private WXPayReq payReq;
    //1.支付宝，2.微信
    private int payType;
    /**
     * 支付信息实体类
     * @param subject 商品描述
     * @param body 商品详情
     * @param price 商品价格单位为元
     * @param traceNo 支付流水号
     */
    public PayInfo(String subject, String body, String price,String traceNo) {
        this.subject = subject;
        this.body = body;
        this.price = price;
        this.traceNo= traceNo;
    }


    /**
     * 支付信息实体类
     * @param subject 商品描述
     * @param body 商品详情
     * @param price 商品价格单位为元
     * @param payReq 支付流水号
     */
    public PayInfo(String subject, String body, String price,WXPayReq payReq) {
        this.subject = subject;
        this.body = body;
        this.price = price;
        this.payReq= payReq;
    }



    /**
     * 支付信息实体类
     * @param subject 商品描述
     * @param body 商品详情
     * @param price 商品价格单位为元
     * @param traceNo 支付流水号
     * @param payReq 微信支付参数
     */
    public PayInfo(String body,String price, String subject, String traceNo,WXPayReq payReq) {
        this.body = body;
        this.payReq = payReq;
        this.price = price;
        this.subject = subject;
        this.traceNo = traceNo;
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
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getTraceNo() {
        return traceNo;
    }
    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }
    public WXPayReq getPayReq() {
        return payReq;
    }
    public void setPayReq(WXPayReq payReq) {
        this.payReq = payReq;
    }
    public void setPayType(int payType) {
        this.payType = payType;
    }
    public int getPayType() {
        return payType;
    }
}
