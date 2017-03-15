//
//  Pay.h
//  支付公共协议
//
//  Created by JiaPenghui on 15/12/30.
//  Copyright © 2015年 jph. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AlipayInfo.h"
@protocol Pay <NSObject>
/**
 * 支付
 * @param info 支付信息实体
 * @param success 支付成功时的回调
 * @param failure  支付不成功时的回调
 **/
-(void)pay:(AlipayInfo*)info success:(void (^)(NSDictionary *resultDic, NSString* orderNum))success failure:(void(^)(NSDictionary *resultDic, NSString* orderNum))failure;
@end
