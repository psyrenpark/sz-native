#import <React/RCTViewManager.h>
@interface RCT_EXTERN_MODULE(SzAdPieManager, RCTViewManager)
    RCT_EXPORT_VIEW_PROPERTY(slotId, NSString)
    RCT_EXPORT_VIEW_PROPERTY(onSuccess, RCTDirectEventBlock)
    RCT_EXPORT_VIEW_PROPERTY(onFail, RCTDirectEventBlock)
    RCT_EXPORT_VIEW_PROPERTY(onClickAd, RCTDirectEventBlock)
@end