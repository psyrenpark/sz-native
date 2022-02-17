package sv.sznative.ad

import android.util.Log
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.gomfactory.adpie.sdk.AdView

//class SzAdPieManager : SimpleViewManager<SzAdPieView>() {
//
//    override fun getName(): String {
//        return REACT_CLASS
//    }
//
//    override fun createViewInstance(reactContext: ThemedReactContext): SzAdPieView {
//        return SzAdPieView(reactContext)
//    }
//
//    companion object {
//        const val REACT_CLASS = "SzAdPie"
//    }
//}

class SzAdPieManager : SimpleViewManager<com.gomfactory.adpie.sdk.AdView>() {

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(reactContext: ThemedReactContext): com.gomfactory.adpie.sdk.AdView {
        val adView = com.gomfactory.adpie.sdk.AdView(reactContext)

        adView.setSlotId("57342e0d7174ea39844cac13")
        Log.d("pppppp", "adView SlotId" + adView.slotId )

//        adView.setScaleUp(true)
//        adView.setAutoBgColor(true)

        adView.setAdListener(object : AdView.AdListener {
            override fun onAdLoaded() {
                Log.d("pppppp", "onAdLoaded")
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                Log.d("pppppp", "onAdFailedToLoad " + errorCode.toString())
            }

            override fun onAdClicked() {
                Log.d("pppppp", "onAdClicked")
            }
        })

//        val targetingData = TargetingData.Builder()
//                .setGender(TargetingData.Gender.MALE)
//                .setAge(30)
//                .setYearOfBirthday(1970)
//                .build()
//
//        adView!!.load(targetingData)

        adView!!.load();
        Log.d("pppppp", "load")

        return adView;
    }

    companion object {
        const val REACT_CLASS = "SzAdPie"
    }
}