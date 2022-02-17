package sv.sznative.ad

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

class SzAdPie3Manager : SimpleViewManager<SzAdPie3View>() {

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(reactContext: ThemedReactContext): SzAdPie3View {
        return SzAdPie3View(reactContext)
    }

    companion object {
        const val REACT_CLASS = "SzAdPie3"
    }
}