//
//  PaySDK.h
//  PaySDK-for-Ios
//
//

#import <Foundation/Foundation.h>、

@interface PaySDK : NSObject
/**
 * 支付
 * @param info 支付信息
 * @param success 支付成功回调
 * @param failure 支付失败回调
 **/
-(void)onAlipay:payInfo:(AlipayInfo *)info success:(void (^)(NSDictionary *resultDic, NSString* message))success failure:(void(^)(NSDictionary *resultDic, NSString* message))failure;
@end


-(void)onWxpay:payInfo:(WxpayInfo *)info success:(void (^)(NSDictionary *resultDic, NSString* message))success failure:(void(^)(NSDictionary *resultDic, NSString* message))failure;
@end