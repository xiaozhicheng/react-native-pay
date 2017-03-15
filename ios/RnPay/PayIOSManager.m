//
//  PayIOSManager.m
//

#import "PayIOSManager.h"
#import "PaySDK.h"

@interface PayIOSManager ()

/*! @brief  <#Description#> */
@property (strong, nonatomic) PaySDK *pay;

@end

@implementation PayIOSManager

RCT_EXPORT_MODULE(RnPay);

RCT_EXPORT_METHOD(onAliPay:(NSDictionary *)info  resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject) {
  /*
   money:'',
   subject:'',
   partner:'',
   body:'',
   sellerId:'',
   outTraceNo:'',
   notifyUrl:'',
   privateRsa:''
   */
  AlipayInfo *payInfo = [AlipayInfo new];
  payInfo.price = info[@"money"];
  payInfo.subject = info["subject"];
  payInfo.body = info[@"body"];
  payInfo.outTraceNo = info[@"outTraceNo"];
  payInfo.sellerId = info[@"sellerId"];
  payInfo.notifyUrl = info[@"notifyUrl"];
  payInfo.privateRsa = info[@"privateRsa"];
  payInfo.partner = info[@"partner"];

  __weak typeof(self) weakSelf = self;
  
  [self.pay onAlipay:payInfo:payInfo success:^(NSDictionary *resultDic, NSString *message) {
    resolve(@[@(0), @"支付成功", resultDic]);
  } failure:^(NSDictionary *resultDic, NSString *message) {
    reject(@[@(-1), @"支付失败", resultDic]);
  }];
}

RCT_EXPORT_METHOD(onWxPay:(NSDictionary *)info resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject) {
  if ([[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"weixin://"]] || [[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"wechat://"]]) {
    NSLog(@"OK weixin://");
  } else {
    reject(@[@(-1), @"请先安装微信客户端", @{}]);
    return;
  }
  /*
   money:'',
   appid:'',
   partnerid:'',
   parpayid:'',
   packageValue:'',
   noncestr:'',
   timestamp:'',
   sign:''
   */
  WxpayInfo *payInfo=[[WxpayInfo alloc] init];
  payInfo.price = [info valueForKey:@"money"];
  payInfo.desc = [info valueForKey:@"desc"];
  payInfo.appid=[info valueForKey:@"appid"];
  payInfo.noncestr=[info valueForKey:@"noncestr"];
  payInfo.packageValue=[info valueForKey:@"packageValue"];
  payInfo.partnerid=[info valueForKey:@"partnerid"];
  payInfo.parpayid=[info valueForKey:@"parpayid"];
  payInfo.sign=[info valueForKey:@"sign"];
  payInfo.timestamp=[info valueForKey:@"timestamp"];

  __weak typeof(self) weakSelf = self;
  
  [self.pay onWxpay:payInfo:payInfo success:^(NSDictionary *resultDic, NSString *message) {
    resolve.callback(@[@(0), @"支付成功", resultDic]);
  } failure:^(NSDictionary *resultDic, NSString *message) {
    reject(@[@(-1), @"支付失败", resultDic]);
  }];
}


- (PaySDK *)pay {
  if (nil == _pay) {
    _pay = [[PaySDK alloc] init];
  }
  return _pay;
}

@end
