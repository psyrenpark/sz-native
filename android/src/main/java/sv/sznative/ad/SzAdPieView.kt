package sv.sznative.ad

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.facebook.react.bridge.ReactContext
import com.gomfactory.adpie.sdk.AdPieSDK
import com.gomfactory.adpie.sdk.AdView
import com.gomfactory.adpie.sdk.TargetingData
import sv.sznative.databinding.CounterViewBinding
import sv.sznative.databinding.SzAdPieViewBinding


class SzAdPieView(val context: ReactContext): FrameLayout(context){

//    private var adView: AdView? = null
    private val binding : SzAdPieViewBinding

    init {

        Log.d("pppppp", "start-1")

        val inflater = LayoutInflater.from(context)
        binding = SzAdPieViewBinding.inflate(inflater, this, true)

       val adView =  binding.adView as AdView
        adView.setSlotId("57342e0d7174ea39844cac13")
        Log.d("pppppp", "adView SlotId" + adView.slotId )

//
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

//        binding.button.text = "+1"
//        binding.button2.text = "-1"


//        this.addV

    }


//    private val binding : CounterViewBinding
//
//    fun setLeftButtonText(text : String) {
//        binding.button.text = text
//    }
//
//    fun setRightButtonText(text : String) {
//        binding.button2.text = text
//    }
//
//    fun setValue(value : Int) {
//        binding.textView.text = value.toString()
//    }
//
//    fun setupEvents() {
//        val eventEmitter = context.getJSModule(RCTEventEmitter::class.java)
//        binding.button.setOnClickListener{
//            eventEmitter.receiveEvent(id , "pressLeftButton", null)
//        }
//        binding.button2.setOnClickListener{
//            val event = Arguments.createMap()
//            event.putString("message", "Hello world")
//            eventEmitter.receiveEvent(id , "pressRightButton", event)
//        }
//    }
//
//    init {
////        val view = View.inflate(context, R.layout.counter_view, this)
////        view.findViewById<TextView>(R.id.textView).text = "20"
//        val inflater = LayoutInflater.from(context)
//        binding = CounterViewBinding.inflate(inflater, this, true)
//        this.setupEvents()
////        binding.button.text = "+1"
////        binding.button2.text = "-1"
//
//    }
}