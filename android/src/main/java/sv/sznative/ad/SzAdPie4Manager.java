package sv.sznative.ad;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.AdView;

public class SzAdPie4Manager extends SimpleViewManager<com.gomfactory.adpie.sdk.AdView> {

    public static final String REACT_CLASS = "SzAdPie4";
    ReactApplicationContext mCallerContext;

    AdView adView;

    public SzAdPie4Manager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public com.gomfactory.adpie.sdk.AdView createViewInstance(ThemedReactContext context) {
        adView =  new com.gomfactory.adpie.sdk.AdView(context);

        adView.setSlotId("57342e0d7174ea39844cac13");
        Log.d("pppppp", "adView SlotId" + adView.getSlotId() );

        adView.setAdListener(new com.gomfactory.adpie.sdk.AdView.AdListener() {

            @Override
            public void onAdLoaded() {
                // 광고 표출 성공 후 이벤트 발생
                Log.d("pppppp", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // 광고 요청 또는 표출 실패 후 이벤트 발생
                // error message -> AdPieError.getMessage(errorCode)
                Log.d("pppppp", "onAdFailedToLoad " + String.valueOf(errorCode));
            }

            @Override
            public void onAdClicked() {
                // 광고 클릭 후 이벤트 발생
                Log.d("pppppp", "onAdClicked");
            }
        });

        adView.load();

        return adView;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}