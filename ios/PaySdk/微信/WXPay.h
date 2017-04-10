//
//  WXPay.h
//  KPaySDK-for-Ios
//
//  Created by Penn on 16/5/20.
//  Copyright © 2016年 jph. All rights reserved.
//

#import <Foundation/Foundation.h>
@interface WXPay : NSObject

+(void)pay:(NSDictionary *)info success:(void (^)(NSDictionary *, NSString *))success failure:(void (^)(NSDictionary *, NSString *))failure;

@end
