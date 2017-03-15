//
//  AliPay.m
//  KPaySDK-for-Ios
//
//  Created by JiaPenghui on 15/12/30.
//  Copyright © 2015年 jph. All rights reserved.
//

#import "AliPay.h"
#import "Order.h"
#import "PayConfig.h"
#import <AlipaySDK/AlipaySDK.h>
#import "DataSigner.h"
@implementation AliPay
-(void)pay:(AlipayInfo *)info success:(void (^)(NSDictionary *, NSString *))success failure:(void (^)(NSDictionary *, NSString *))failure{
    /*
     *生成订单信息及签名
     */
    //将商品信息赋予AlixPayOrder的成员变量
    Order *order = [[Order alloc] init];
    order.partner = info.partner;
    order.seller = info.sellerId;
    order.tradeNO = info.outTraceNo; //订单ID（由商家自行制定）
    order.productName =info.subject; //商品标题
    order.productDescription=info.body; //商品描述
    order.amount = info.price; //商品价格
    order.notifyURL =  info.notifyUrl; //回调URL
    
    order.service = @"mobile.securitypay.pay";
    order.paymentType = @"1";
    order.inputCharset = @"utf-8";
    order.itBPay = @"30m";
    order.showUrl = @"m.alipay.com";
    
    //应用注册scheme,在AlixPayDemo-Info.plist定义URL types
    NSString *appScheme = AP_SCHEME_ALIPAY;
    
    //将商品信息拼接成字符串
    NSString *orderSpec = [order description];
    
    //获取私钥并将商户信息签名,外部商户可以根据情况存放私钥和签名,只需要遵循RSA签名规范,并将签名字符串base64编码和UrlEncode
    id<DataSigner> signer = CreateRSADataSigner(info.privateRsa);
    NSString *signedString = [signer signString:orderSpec];
    
    //将签名成功字符串格式化为订单字符串,请严格按照该格式
    NSString *orderString = nil;
    if (signedString != nil)    {
        orderString = [NSString stringWithFormat:@"%@&sign=\"%@\"&sign_type=\"%@\"",
                       orderSpec, signedString, @"RSA"];
        
        [[AlipaySDK defaultService] payOrder:orderString fromScheme:appScheme callback:^(NSDictionary *resultDic) {
            
            //支付回调
            NSString *info = [NSString stringWithFormat:@"pay  result = %@",[resultDic objectForKey:@"memo"]];
            NSLog(@"%@",[info stringByReplacingPercentEscapesUsingEncoding:NSUTF8StringEncoding]);
            NSString *resultStatus = [resultDic objectForKey:@"resultStatus"];
            if ([resultStatus isEqualToString:@"9000"]){ //订单支付成功
                success(resultDic,order.tradeNO);
                return ;
            }else if ([resultStatus isEqualToString:@"8000"]){//正在处理中
                
            }else if ([resultStatus isEqualToString:@"4000"]){ //订单支付失败
               
            }else if ([resultStatus isEqualToString:@"6001"]){//用户中途取消
                
            }else if ([resultStatus isEqualToString:@"6002"]){//网络连接出错
                
            }else{ //其他问题
               
            }
            failure(resultDic,order.tradeNO);
        }];
    }
}
@end
