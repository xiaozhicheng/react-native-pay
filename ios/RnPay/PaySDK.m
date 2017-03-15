//
//  PaySDK.m
//  PaySDK-for-Ios
//

#import "KPaySDK.h"
#import "AliPay.h"
#import "WXPay.h"
@implementation PaySDK

-(void)onAlipay: payInfo:(AlipayInfo *)info success:(void (^)(NSDictionary *, NSString *))success failure:(void (^)(NSDictionary *, NSString *))failure{
    //支付宝支付
    [[[AliPay alloc] init] pay:info success:success failure:failure];
@end

-(void)onWxpay: payInfo:(WxpayInfo *)info success:(void (^)(NSDictionary *, NSString *))success failure:(void (^)(NSDictionary *, NSString *))failure{
    //微信支付
    [[[WXPay alloc] init] pay:info success:success failure:failure];
@end