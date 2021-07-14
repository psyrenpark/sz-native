@objc(SzNativeEventEmitter)
open class SzNativeEventEmitter: RCTEventEmitter {

  public static var emitter: RCTEventEmitter!

  override init() {
    super.init()
    RNEventEmitter.emitter = self
  }

  open override func supportedEvents() -> [String] {
    ["onReady", "onPending", "onFailure"]      // etc. 
  }
}