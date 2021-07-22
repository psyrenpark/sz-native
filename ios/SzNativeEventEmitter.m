//#import <React/RCTBridgeModule.h>
//#import <React/RCTEventEmitter.h>
//
//
//@interface RCT_EXTERN_MODULE(SzNativeEventEmitter, RCTEventEmitter)
//  RCT_EXTERN_METHOD(supportedEvents)
//@end



// React Native module that lets Objective-C send events to JavaScript.

#import <Foundation/Foundation.h>
#import <React/RCTEventEmitter.h>
#import "SzNativeEventEmitter.h"

@implementation SzNativeEventEmitter
{
    BOOL hasObservers; // This is purely a performance thing
}

RCT_EXPORT_MODULE(SzNativeEventEmitter)

/*! @brief Required because we export constantsToExport */
//+ (BOOL) requiresMainQueueSetup
//{
//    return YES;
//}

/*!
 * Allows us to write 'EventEmitter.MyEventName' in JavaScript and get 'MyEventValue.
 * Hardcoding 'MyEventValue' in JavaScript would have the same effect.
 */
//- (NSDictionary<NSString *, id> *) constantsToExport
//{
//    return @{@"MyEventName": @"MyEventValue"};
//}

- (NSArray <NSString *> *) supportedEvents
{
    return @[
            @"MyEventValue",
            @"EventReminder"
            ];
}

//- (void) startObserving
//{
//    hasObservers = YES;
//}
//
//- (void) stopObserving
//{
//    hasObservers = NO;
//}

- (void) emitEvent:(NSString *) message
{
//    if (hasObservers) {
        [self sendEventWithName:@"MyEventValue" body:message];
//    }
}


RCT_EXPORT_METHOD(testEmitEvent: (NSString *)name) {
 
    [self sendEventWithName:@"EventReminder" body:@{@"name": name}];
}

@end
