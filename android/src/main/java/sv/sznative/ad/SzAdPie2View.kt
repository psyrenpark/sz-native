package sv.sznative.ad

import android.util.Log
import android.widget.FrameLayout
import com.facebook.react.bridge.ReactContext
import com.gomfactory.adpie.sdk.InterstitialAd
import com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener


class SzAdPie2View(val context: ReactContext): FrameLayout(context){

    public var interstitialAd: InterstitialAd? = null

    init {
        Log.d("pppppp", "SzAdPie2View")
        interstitialAd = InterstitialAd(context, "57342e3d7174ea39844cac14")
//        interstitialAd!!.adListener = this
//        val targetingData = TargetingData.Builder()
//                .setGender(TargetingData.Gender.MALE)
//                .setAge(30)
//                .setYearOfBirthday(1970)
//                .build()
//        // 광고 요청시 타겟팅 정보를 넣어준다.
//        // 광고 요청시 타겟팅 정보를 넣어준다.
//        interstitialAd!!.load(targetingData)

        interstitialAd?.load()
        Log.d("pppppp", "load")

        interstitialAd!!.adListener = object : InterstitialAdListener {
            override fun onAdLoaded() {
                // 광고 로딩 완료 후 이벤트 발생

                // 광고 요청 후 즉시 노출하고자 할 경우 아래의 코드를 추가한다.
                if (interstitialAd!!.isLoaded) {
                    // 광고 표출
                    interstitialAd!!.show()
                }
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // 광고 요청 실패 후 이벤트 발생
                // error message -> AdPieError.getMessage(errorCode)
            }

            override fun onAdShown() {
                // 광고 표출 후 이벤트 발생
            }

            override fun onAdClicked() {
                // 광고 클릭 후 이벤트 발생
            }

            override fun onAdDismissed() {
                // 광고가 표출한 뒤 사라질 때 이벤트 발생
            }
        }


    }
//    override fun onAdLoaded() {
//        TODO("Not yet implemented")
//        Log.d("pppppp", "onAdLoaded")
//
//        if (interstitialAd!!.isLoaded) {
//            interstitialAd!!.show()
//        }
//
//    }
//
//    override fun onAdFailedToLoad(p0: Int) {
//        TODO("Not yet implemented")
//        Log.d("pppppp", "onAdFailedToLoad")
//    }
//
//    override fun onAdShown() {
//        TODO("Not yet implemented")
//        Log.d("pppppp", "onAdShown")
//    }
//
//    override fun onAdClicked() {
//        TODO("Not yet implemented")
//        Log.d("pppppp", "onAdClicked")
//    }
//
//    override fun onAdDismissed() {
//        TODO("Not yet implemented")
//        Log.d("pppppp", "onAdDismissed")
//    }
}