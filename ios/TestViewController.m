//
//  TestViewController.m
//  test-pp-v3
//
//  Created by 경복박 on 2021/07/08.
//

#import "TestViewController.h"

@interface TestViewController ()

@property (nonatomic, strong) RCTBridge* bridge;

@end

@implementation TestViewController


- (void) setRTCBridge:(RCTBridge*) rtc_bridge
{
    self.bridge = rtc_bridge;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)handleTriggerEvent:(id)sender {
    // RCTBridge *reactBridge = self.bridge;
    // EventEmitter *eventEmitter = [reactBridge moduleForName:@"EventEmitter"];
    // [eventEmitter emitEvent:@"Hello from iOS event emitter!"];

    RNEventEmitter.emitter.sendEvent(withName: "onReady", body: [])
}

@end
