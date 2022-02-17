@objc (SzAdPieManager)
class SzAdPieManager : RCTViewManager {

    override static func requiresMainQueueSetup() -> Bool {
        return true
    }

    override func view() -> UIView! {
        return SzAdPieView()
    }

}