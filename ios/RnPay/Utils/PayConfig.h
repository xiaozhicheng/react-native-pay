//
//  Constants.h
//  KPaySDK-for-Ios
//
//  Created by JiaPenghui on 15/12/29.
//  Copyright © 2015年 jph. All rights reserved.
//
/******支付宝支付相关配置********/
#define AP_SCHEME_ALIPAY @"ksudi-alipay"

// 1测试环境， 0为预发布和正式环境
#define PAY_TEST 0

#if PAY_TEST
//合作者身份ID,以2088开头
#define AP_PARTNER_ID @"2088911778508925"
// 商户收款账号
#define AP_SELLER @"adoby.chen@ksudi.com"
// 商户私钥，pkcs8格式
#define AP_RSA_PRIVATE @"MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMTpyCoVRxkDSBUKRoPA+TaLf7Uqk6O7uGKy19bBpJf3HozciYMeqJhZvu7/OHKEM3bDvfcR/P5jNn71liFJNf17cetDjp6RkFTNwiof4bkUqFCXqkhmWJ3Cnj57yW9h0ojkr3Zpt670HPtdxargxW8xgVHVd95YQu8DKa8c2bUdAgMBAAECgYAX4XJRCDuTIP7A7noWyHRw1QIr6nn1RXLbJW1fsiRP+bxOwQA8Up+HunqZaYJjAP1szdhf+mKAR2/4fbgzWTmeybpUoU9c9gVW4M7O3vqKCkP53jQuyewriYt9RJiViUB7qNme2V7s7Qut43m33yptVUBmzwhDYrTYSR5To6tcUQJBAOdCvskyegIYcXbqDC61wRkyuah5WznHJ8kbwEzqiG31dTd9E+RC7OtE86569HPRM1iBo7ASujrAlLVq3h68/EcCQQDZ+mc9Sow64HmflUK7Zq+MuRiaepbp/icSJieaAPm0JyEIX1vasHbsWe63rc9DQ/fU8uxkjimPQ+YobV3gYgl7AkAwQjFl8u6a+VbUJcsdBDijdX5gtdJfoDuhL/VVF6wYphwr1CIOhBjEj8L6KhZRBNreIU9zMrVCBWYC5aYsa+uJAkAC3fZJqhdaFuXCoZX1HQ6mDTEzpvUhMsSUyoeu0OB37CPVFlwA7l1CEpS/ObwGKHi0BlXxpKULS1tVoMqhTujNAkAzFhAXQDKeoE0p7RVFlebe2sg2YYXMk/8LMURM3ayW4M+IL7Mn/6rBHp9DLdFnnUCWYjs1PoEm/K9k0msaUYJ4"
//回掉地址
//#define AP_NOTIFY_URL @"http://wuruile.tunnel.qydev.com/ksudi-star-payment/notify/alipay/app/"
//#define AP_NOTIFY_URL @"http://lzwuruile.6655.la/ksudi-star-payment/notify/alipay/app/"
//内测回掉
#define AP_NOTIFY_URL @"http://www.ksudi.org/ksudi-star-payment/notify/alipay/app/"
#else
//合作者身份ID,以2088开头
#define AP_PARTNER_ID @"2088611798941730"
// 商户收款账号
#define AP_SELLER @"support@oeffect.com"
// 商户私钥，pkcs8格式
#define AP_RSA_PRIVATE @"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMWYZVTvQiROITDX9U6Wewdmm0CBugrr8WmbjKTzjIkzqtEE0EA9uOQFECK5iSggUa/S3fqhOeef5TOWHXruedfwDYl4QonUMAOP0wG0TGnPpjIPJ4kCM9jX6/7qwJxOn3jlSeU3IEh2jxsXFCqjEzVp51RM5XTJ2DtmF63m3czdAgMBAAECgYEAo74fMtw2fml0XcqIkQBooYBo5XLbXhOZ8b8iNMtSyZvUUPPhM2synVqIvY3s2CC4MLDYnMogdw5s3GvosCeRNWe9tX9gWzsVWp7djTMCeLeua/SauFmmRHLMq6brS55viS5Y7l0as9HLsOo77KcL9r/JiIk2Ruf1KiNRVtq25SECQQD0cLRFE1/m8XNyD7bev8GIE7Um90mwRMim4BncM7hI1BRUqPClvDtcnfV34WMo6t8IeWayKySjjnKmDic8PffJAkEAzvCRKm0+9lM3Iij1Y8jCWJL5o0snW7UQiQ6BCY8IbtvjWz6qTDJ2c6IVlM4lQMTuA6SYzg/EtxhGaFEDpHIedQJABVCiCtJ2Bl5/pR5EWqmOure6+6Lq3kNQnZhH16rkOekqnACkYuYp4ESq/rVO46ffu55wJjWb8VZ6lbO/FKdASQJAHfC8cBECTQ1ZKr4WUuuXAs2xBKk49pHJ5KqOjN1+8Nsrl+YHKaMbdDt9N9xjk21qqmhEG3w4j+0ZMrqV9lL0iQJAe3G4G771b84z4S45KlfvrXjm7JY+bqLFyWjZb1wxWhry5PvC5AgQBZgKhOnjZC0IQ1CdWr0E8/9t3yl89m7F1Q=="
////预回掉
//#define AP_NOTIFY_URL @"http://yu.oeffect.com/payment/notify/alipay/app/"
//正式回掉
#define AP_NOTIFY_URL @"http://admin.ksudi.com/ksudi-star-payment/notify/alipay/app/"
#endif



/******微信支付相关配置********/
#define APP_ID_WX           @"wx1d45484df3d3307b"
#define APP_SECRET_WX       @"080fd1ee12c814bb0179bf71529f564b"
//商户号，填写商户对应参数
#define MCH_ID_WX           @"1261858001"
//商户API密钥，填写相应参数
#define PARTNER_ID_WX       @"080fd1ee12c814bb0179bf71529f564b"
//支付结果回调页面
#define NOTIFY_URL          @"http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php"
//获取服务器端支付数据地址（商户自定义）
#define SP_URL              @"http://wxpay.weixin.qq.com/pub_v2/app/app_pay.php"



/******Other********/
//正式地址
#define URL_SERVER_PAYMENT @"http://admin.ksudi.com/ksudi-star-payment/"
////预地址
//#define URL_SERVER_PAYMENT @"http://yu.oeffect.com/payment/"
//内测地址
//#define URL_SERVER_PAYMENT @"http://www.ksudi.org/ksudi-star-payment/"
//吴瑞乐服务器
//#define URL_SERVER_PAYMENT @"http://lzwuruile.6655.la/ksudi-star-payment/"
//#define URL_SERVER_PAYMENT @"http://wuruile.tunnel.qydev.com/ksudi-star-payment/"

//李建军服务器
//#define URL_SERVER_PAYMENT @"http://192.168.1.51:80/ksudi-star-payment/"
#define APPDELEGATE ((AppDelegate *)[[UIApplication sharedApplication] delegate])
#define kWidth [[UIScreen mainScreen] bounds].size.width
#define kHeight [[UIScreen mainScreen] bounds].size.height