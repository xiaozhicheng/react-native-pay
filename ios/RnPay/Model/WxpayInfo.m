//
//  AlipayInfo.m
//  PaySDK-for-Ios 支付宝
//  支付信息实体类
//

#import "AlipayInfo.h"

@implementation AlipayInfo
+(instancetype)payInfoWithPrice:(NSString*)price subject:(NSString *)subject body:(NSString *)body partner:(NSString*)partner outTraceNo:(NSString)outTraceNo sellerId:(NSString)sellerId notifyUrl:(NSString)notifyUrl privateRsa:(NSString)privateRsa{
    AlipayInfo*info=[[AlipayInfo alloc] init];
    info.price=price;
    info.subject=subject;
    info.body=body;
    info.partner=partner;
    info.outTraceNo = outTraceNo;
    info.sellerId = sellerId;
    info.notifyUrl = notifyUrl;
    info.privateRsa = privateRsa;
    return info;
}
@end
