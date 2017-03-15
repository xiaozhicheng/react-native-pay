//
//  WXPay.m
//  KPaySDK-for-Ios
//  微信支付
//

#import "WXPay.h"
#import "WXApi.h"
#import "WXApiManager.h"
#import "WXPayReq.h"
#import "PayConfig.h"
@implementation WXPay
-(void)pay:(WxpayInfo *)info success:(void (^)(NSDictionary *, NSString *))success failure:(void (^)(NSDictionary *, NSString *))failure{
    //向微信注册
    [WXApi registerApp:APP_ID_WX withDescription:info.desc];
    WXApiManager*manager=[WXApiManager sharedManager];
    manager.payFailure=failure;
    manager.paySuccess=success;
    PayReq* req= [[PayReq alloc] init];
    req.partnerId= info.partnerid;
    req.prepayId= info.parpayid;
    req.nonceStr= info.noncestr;
    req.timeStamp= [info.timestamp intValue];
    req.package=info.packageValue;
    req.sign=info.sign;
    [WXApi sendReq:req];
 
}
@end
