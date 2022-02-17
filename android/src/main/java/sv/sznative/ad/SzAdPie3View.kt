package sv.sznative.ad

import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.facebook.react.bridge.ReactContext
import com.gomfactory.adpie.sdk.AdPieError
import com.gomfactory.adpie.sdk.NativeAd
import com.gomfactory.adpie.sdk.nativeads.NativeAdView
import com.gomfactory.adpie.sdk.nativeads.NativeAdView.ResourceLoadEventListener
import com.gomfactory.adpie.sdk.nativeads.NativeAdViewBinder
import sv.sznative.R
import sv.sznative.databinding.AdPieTestViewBinding


class SzAdPie3View(val context: ReactContext): FrameLayout(context){

    private var nativeAd: NativeAd? = null
    private val binding : AdPieTestViewBinding

    init {
        Log.d("pppppp", "SzAdPie3View")


        val inflater = LayoutInflater.from(context)
        binding = AdPieTestViewBinding.inflate(inflater, this, true)



        val viewBinder = NativeAdViewBinder.Builder(R.layout.adpie_native_ad_template)
                .setTitleId(R.id.native_ad_title)
                .setDescriptionId(R.id.native_ad_description)
                .setMainId(R.id.native_ad_main)
                .setIconImageId(R.id.native_ad_icon)
                .setCallToActionId(R.id.native_ad_cta)
                .setOptOutId(R.id.native_optout)
                .build()

        nativeAd = NativeAd(context, viewBinder)
        nativeAd!!.setSlotId("57bd1f3f7174ea576fa3c3a3")
        nativeAd!!.setAdListener(object : NativeAd.AdListener {
            override fun onAdLoaded(nativeAdView: NativeAdView) {
                Log.d("pppppp", "onAdLoaded : " + nativeAdView.isResourceLoaded)

                if (nativeAdView.isResourceLoaded) {
                    // 기본 값으로 이미지 관련 리소스 로딩 완료
                    // 이미지 관련 리소스 로딩 완료
//                    (listview.getAdapter() as com.gomfactory.adpie.sample.NativeAdActivity.ListViewAdapter).addItem(adIdx, nativeAdView)
//                    (listview.getAdapter() as com.gomfactory.adpie.sample.NativeAdActivity.ListViewAdapter).notifyDataSetChanged()

                    try {
                        binding.container.addView(nativeAdView.copy())
                        binding.container.setVisibility(VISIBLE)
                        binding.container.setVisibility(GONE)
                    } catch (e: Exception) {
                    }


                } else {
                    // nativeAd.setSkipDownload(true)를 호출한 경우로 이미지 다운로드 필요
                    // 이미지 다운로드 및 설정이 필요
                    run {
                        // 방법 1 : SDK 통한 이미지 다운로드
                        nativeAdView.downloadResource(object : ResourceLoadEventListener {
                            override fun onSuccess() {
                                Log.d("pppppp", "onSuccess")
//                                (listview.getAdapter() as com.gomfactory.adpie.sample.NativeAdActivity.ListViewAdapter).addItem(adIdx, nativeAdView)
//                                (listview.getAdapter() as com.gomfactory.adpie.sample.NativeAdActivity.ListViewAdapter).notifyDataSetChanged()
                            }

                            override fun onError() {
                                Log.d("pppppp", "onError")
//                                printMessage(this@NativeAdActivity, "NativeAdView resource download failed.")
                            }
                        })
                    }
                    run {

                        // 방법 2 : SDK 를 통하지 않고 매체에서 별도로 이미지 로딩을 하는 경우 별도로 설정가능
                        val nativeAdData = nativeAdView.nativeAdData
                        val iconImageUrl = nativeAdData.iconImageUrl
                        val iconImageView = nativeAdView.iconImageView
                        val mainImageUrl = nativeAdData.mainImageUrl
                        val mainImageView = nativeAdView.mainImageView
                    }
                }
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                Log.d("pppppp", "NativeAdView onAdFailedToLoad "
                        + AdPieError.getMessage(errorCode))
            }

            override fun onAdShown() {

                Log.d("pppppp", "NativeAdView onAdShown ")

            }

            override fun onAdClicked() {
                Log.d("pppppp", "NativeAdView onAdClicked")

            }
        })

        nativeAd!!.loadAd()


    }

}