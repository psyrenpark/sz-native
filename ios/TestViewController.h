//
//  TestViewController.h
//  test-pp-v3
//
//  Created by 경복박 on 2021/07/08.
//

#import <UIKit/UIKit.h>
#import <UIKit/UIKit.h>
#import <React/RCTBridge.h>
// #import "EventEmitter.h"

NS_ASSUME_NONNULL_BEGIN

@interface TestViewController : UIViewController

-(void)setRTCBridge:(RCTBridge*)rtc_bridge;

@end

NS_ASSUME_NONNULL_END
