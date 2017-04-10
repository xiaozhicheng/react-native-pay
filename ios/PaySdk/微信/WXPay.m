//
//  WXPay.m
//  KPaySDK-for-Ios
//  微信支付
//

#import "WXPay.h"
#import "WXApi.h"
#import "WXApiManager.h"
@implementation WXPay
+(void)pay:(NSDictionary *)info success:(void (^)(NSDictionary *, NSString *))success failure:(void (^)(NSDictionary *, NSString *))failure{
  
    WXApiManager*manager=[WXApiManager sharedManager];
    manager.payFailure=failure;
    manager.paySuccess=success;
    PayReq* req= [[PayReq alloc] init];
    req.partnerId= [info valueForKey:@"partnerid"];
    req.prepayId= [info valueForKey:@"prepayid"];
    req.nonceStr= [info valueForKey:@"noncestr"];
    req.timeStamp = [[info valueForKey:@"timestamp"] intValue];
    req.package=[info valueForKey:@"package"];
    req.sign=[info valueForKey:@"sign"];
    [WXApi sendReq:req];
}
@end
