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
