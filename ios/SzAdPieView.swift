import UIKit
import AdPieSDK

class SzAdPieView: UIView, APAdViewDelegate {

    private var adView: APAdView!
    private var slotID: String!

    @objc var slotId: String = ""  {
        didSet {
            if slotId == "" { //배너
                adView.slotId = "INPUT_KEY"
            }
        
            adView.slotId = slotId
            adView.delegate = self
            adView.load()
        }
    }
    

    override init(frame: CGRect) {
        super.init(frame: frame)
        setupView()
    }

    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        setupView()
    }

    private func setupView() {
        adView = APAdView()
        adView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        self.addSubview(adView)
    }

    @objc var onSuccess: RCTDirectEventBlock?
    @objc var onFail: RCTDirectEventBlock?
    @objc var onClickAd: RCTDirectEventBlock?

    func adViewDidLoadAd(_ view: APAdView!) {

        if onSuccess == nil {
            return
        }
        let event = [AnyHashable: Any]()
        onSuccess!(event)

    }

    func adViewDidFail(toLoadAd view: APAdView!, withError error: Error!) {

        if onFail == nil {
            return
        }
        let event = [AnyHashable: Any]()
        onFail!(event)
    }

    func adViewWillLeaveApplication(_ view: APAdView!) {

        if onClickAd == nil {
            return
        }
        let event = [AnyHashable: Any]()
        onClickAd!(event)
    }
}
