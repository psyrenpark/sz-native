//
//import Foundation
//
//@objc(SzNativeEventEmitter)
//open class SzNativeEventEmitter: RCTEventEmitter {
//
//  public static var emitter: RCTEventEmitter!
//
//  override init() {
//    super.init()
//    SzNativeEventEmitter.emitter = self
//  }
//
//  open override func supportedEvents() -> [String] {
//    ["EventReminder", "onReady", "onPending", "onFailure"]      // etc.
//  }
//}


import Foundation
import UIKit

@objc(BrightnessModule)
class BrightnessModule : NSObject {
    
    
    // @objc
    // func constantsToExport() -> [AnyHashable : Any]! {
    //     return [
    //         "STRING_VALUE" : "Hello World",
    //         "NUMBER_VALUE" : 15
    //     ]
    // }
    
    
    @objc
    func getBrightness(_ resolve: @escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock){
        resolve(UIScreen.main.brightness)
    }
    
    @objc
    func setBrightness(_ brightness : CGFloat){
        print("Setting brightness to \(brightness)")
        DispatchQueue.main.async {
            UIScreen.main.brightness = brightness
        }
        
    }
    
    @objc
    static func requiresMainQueueSetup() -> Bool {
        return true
    }
    
}
