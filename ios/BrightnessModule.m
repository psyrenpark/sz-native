//
//  BrightnessModule.m
//  sz-native
//
//  Created by 경복박 on 2021/12/23.
//

//#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(BrightnessModule, NSObject)
 RCT_EXTERN_METHOD(
                   getBrightness : (RCTPromiseResolveBlock)resolve
                                   rejecter: (RCTPromiseRejectBlock)reject
)
 RCT_EXTERN_METHOD(setBrightness: (CGFloat)brightness)
@end
