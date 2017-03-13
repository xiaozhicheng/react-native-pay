package com.reactnativepay.paysdk;

/**
 * 支付的相关配置
 * @author CXZ
 */
public class PayConfig {

    /*********** 支付宝 start ************/
    // 商户PID
    public static final String PARTNER = "2088611798941730";
    //	 商户收款账号
    public static final String SELLER = "support@oeffect.com";
    //	 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMWYZVTvQiROITDX9U6Wewdmm0CBugrr8WmbjKTzjIkzqtEE0EA9uOQFECK5iSggUa/S3fqhOeef5TOWHXruedfwDYl4QonUMAOP0wG0TGnPpjIPJ4kCM9jX6/7qwJxOn3jlSeU3IEh2jxsXFCqjEzVp51RM5XTJ2DtmF63m3czdAgMBAAECgYEAo74fMtw2fml0XcqIkQBooYBo5XLbXhOZ8b8iNMtSyZvUUPPhM2synVqIvY3s2CC4MLDYnMogdw5s3GvosCeRNWe9tX9gWzsVWp7djTMCeLeua/SauFmmRHLMq6brS55viS5Y7l0as9HLsOo77KcL9r/JiIk2Ruf1KiNRVtq25SECQQD0cLRFE1/m8XNyD7bev8GIE7Um90mwRMim4BncM7hI1BRUqPClvDtcnfV34WMo6t8IeWayKySjjnKmDic8PffJAkEAzvCRKm0+9lM3Iij1Y8jCWJL5o0snW7UQiQ6BCY8IbtvjWz6qTDJ2c6IVlM4lQMTuA6SYzg/EtxhGaFEDpHIedQJABVCiCtJ2Bl5/pR5EWqmOure6+6Lq3kNQnZhH16rkOekqnACkYuYp4ESq/rVO46ffu55wJjWb8VZ6lbO/FKdASQJAHfC8cBECTQ1ZKr4WUuuXAs2xBKk49pHJ5KqOjN1+8Nsrl+YHKaMbdDt9N9xjk21qqmhEG3w4j+0ZMrqV9lL0iQJAe3G4G771b84z4S45KlfvrXjm7JY+bqLFyWjZb1wxWhry5PvC5AgQBZgKhOnjZC0IQ1CdWr0E8/9t3yl89m7F1Q==";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";


    /**支付宝服务器异步通知页面路径**/
//    public static final String NOTIFY_URL = "http://ksudi.tunnel.qydev.com/ksudi-star-payment/notify/alipay/app/";
    /**测试**/
//	public static final String NOTIFY_URL = "http://www.ksudi.org/ksudi-star-payment/notify/alipay/app/";
    /**预**/
//	public static final String NOTIFY_URL = "http://yu.oeffect.com/payment/notify/alipay/app/";
    /**正式**/
	public static final String NOTIFY_URL = "http://admin.ksudi.com/ksudi-star-payment/notify/alipay/app/";


    public static final int SDK_PAY_FLAG = 1;
    public static final int SDK_CHECK_FLAG = 2;
    /*********** 支付宝 end ************/

    /*********** 微信 start ************/
    // appid
    // 请同时修改 androidmanifest.xml里面，.PayActivityd里的属性<data
    // android:scheme="wxb4ba3c02aa476ea1"/>为新设置的appid
    public static final String APP_ID = "wx1d45484df3d3307b";
    // 商户号
    public static final String MCH_ID = "1261858001";
    // API密钥，在商户平台设置
    public static final String API_KEY = "080fd1ee12c814bb0179bf71529f564b";
    /*********** 微信 end ************/

}
