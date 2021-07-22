//
//  SzNativeEventEmitter.h
//  Pods
//
//  Created by 경복박 on 2021/07/19.
//

#ifndef SzNativeEventEmitter_h
#define SzNativeEventEmitter_h

#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>

@interface SzNativeEventEmitter : RCTEventEmitter <RCTBridgeModule>

- (void) emitEvent:(NSString *) message;

@end


#endif /* SzNativeEventEmitter_h */
