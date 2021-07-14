// SzNative.m

#import <Foundation/Foundation.h>
#import <UIKit/UIAlertController.h>
#import <UIKit/UINavigationController.h>
#import <React/RCTUtils.h>
#import <React/RCTViewManager.h>
#import <React/RCTLog.h>

#import "SzNative.h"
// #import "SzNativeEventEmitter.h"

@implementation SzNative

RCT_EXPORT_MODULE(SzNative)

RCT_EXPORT_METHOD(testToastShow:(NSString *)name)
{
//    RCTLogInfo(@"Pretending to create an event %@", name);
    
    #ifdef TARGET_IPHONE_SIMULATOR
        NSLog(@"Cannot dial on simulator");
    #else
        NSString *url = [@"tel://" stringByAppendingString:name];
        dispatch_async(dispatch_get_main_queue(), ^{
            BOOL success = [[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];
            NSLog(@"Open phone URL: %s", success ? "YES" : "NO");
        });
    #endif
    
}

RCT_EXPORT_METHOD(testCallBack:(NSString *)stringArgument
                  numberParameter:(nonnull NSNumber *)numberArgument
                  callback:(RCTResponseSenderBlock)successCallback
                  callback:(RCTResponseSenderBlock)failureCallback)
 {
    // ios 작업
    @try {
        successCallback(@[[NSString stringWithFormat: @" success : numberArgument: %@ stringArgument: %@", numberArgument, stringArgument]]);
    }
    @catch ( NSException *e ) {
        failureCallback(@[e]);
    }
    
 }



RCT_EXPORT_METHOD(testCallBackToAsync:(NSString *)stringArgument
                  numberParameter:(nonnull NSNumber *)numberArgument
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
 {
    // ios 작업
    NSString  *data =[NSString stringWithFormat: @" success : numberArgument: %@ stringArgument: %@", numberArgument, stringArgument];
    @try {
        resolve(data);
    }
    @catch ( NSException *e ) {
        reject(@"event_failure", @"no event id returned", nil);
    }
    
    
}


// RCT_EXPORT_METHOD(testStartActivity: (NSString *)name numberParameter:(nonnull NSNumber *)age)
// {
    
// }


// RCT_EXPORT_METHOD(testCreateEvent: (NSString *)name numberParameter:(nonnull NSNumber *)age)
// {
    
// }



//public static void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
//    reactContext
//            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
//            .emit(eventName, params);
//}



@end
