//
//  LocalizeTimeModule.m
//  sz-native
//
//  Created by 경복박 on 2021/12/23.
//

//#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(LocalizeTimeModule, NSObject)
 RCT_EXTERN_METHOD(
     getLocalizeTimeStringAsync : 
                   (nonnull NSNumber *)_timestamp  
                   _format:(NSString *)_format
                resolve:  (RCTPromiseResolveBlock)resolve
                rejecter: (RCTPromiseRejectBlock)reject
)
 RCT_EXTERN_METHOD(
     getLocalizeTimeStringAsyncV2 : 
                   (nonnull NSNumber *)_timestamp  
                   _format:(NSString *)_format
                resolve:  (RCTPromiseResolveBlock)resolve
                rejecter: (RCTPromiseRejectBlock)reject
)
@end
