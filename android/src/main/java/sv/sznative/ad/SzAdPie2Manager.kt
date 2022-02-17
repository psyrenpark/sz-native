package sv.sznative.ad

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

class SzAdPie2Manager : SimpleViewManager<SzAdPie2View>() {

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(reactContext: ThemedReactContext): SzAdPie2View {
        return SzAdPie2View(reactContext)
    }

//    @ReactProp(name = "leftButtonText")
//    fun setLeftButtonText(view : CounterView, text : String){
//        view.setLeftButtonText(text)
//    }
//
//    @ReactProp(name = "rightButtonText")
//    fun setrightButtonText(view : CounterView, text : String){
//        view.setRightButtonText(text)
//    }
//
//    @ReactProp(name = "value")
//    fun setValue(view : CounterView , value : Int){
//        view.setValue(value)
//    }

//    override fun getExportedCustomBubblingEventTypeConstants(): MutableMap<String, Any> {
////        return super.getExportedCustomBubblingEventTypeConstants()
//
//        val builder = MapBuilder.builder<String, Any>()
//
//        return builder
//                .put("pressLeftButton", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPressLeftButton")))
//                .put("pressRightButton", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPressRightButton")))
//                .build()
//    }

    companion object {
        const val REACT_CLASS = "SzAdPie2"
    }
}