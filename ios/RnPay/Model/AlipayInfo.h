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
/**商品title*/
@property (nonatomic,copy)NSString*subject;
/**商品描述 detail*/
@property(nonatomic,copy)NSString*body;
/**商户唯一识别*/
@property (copy, nonatomic) NSString *partner;
/**支付流水号*/
@property(nonatomic,copy)NSString*outTraceNo;
/**商户id */
@property (copy, nonatomic) NSString *sellerId;
/**回调函数 */
@property (copy, nonatomic) NSString *notifyUrl;
/**密钥 */
@property (copy, nonatomic) NSString *privateRsa;


+(instancetype)payInfoWithPrice:(NSString*)price subject:(NSString *)subject body:(NSString *)body partner:(NSString*)partner outTraceNo:(NSString)outTraceNo sellerId:(NSString)sellerId notifyUrl:(NSString)notifyUrl privateRsa:(NSString)privateRsa;
@end
