//
//  AlipayInfo.h
//  PaySDK-for-Ios 支付宝
//
//

#import <Foundation/Foundation.h>
#import "WXPayReq.h"
@interface PayInfo : NSObject
#define PAY_SUBJECT_XD @"快递下单支付"
#define PAY_SUBJECT_RECHARGE @"快速递账户充值"

/**支付金额，单位为元**/
@property(nonatomic,copy)NSString* price;
@property(nonatomic,copy)NSString* appid;//应用ID
@property(nonatomic,copy)NSString* partnerid;//商户号
@property(nonatomic,copy)NSString* parpayid;// 预支付交易会话ID
@property(nonatomic,copy)NSString* packageValue;//扩展字段
@property(nonatomic,copy)NSString* noncestr;//随机字符串
@property(nonatomic,copy)NSString* timestamp;//时间戳
@property(nonatomic,copy)NSString* sign;//签名


+(instancetype)payInfoWithPrice:(NSString*)price appid:(NSString *)appid partnerid:(NSString *)partnerid parpayid:(NSString*)parpayid packageValue:(NSString)packageValue noncestr:(NSString)noncestr timestamp:(NSString)timestamp sign:(NSString)sign;
@end
