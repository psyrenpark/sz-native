package sv.sznative.test

import android.text.format.DateFormat
import android.util.Log
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.text.SimpleDateFormat
import java.util.*


class LocalizeTimeModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "LocalizeTimeModule"
    }

    override fun getConstants(): MutableMap<String, Any> {
        val constants = HashMap<String, Any>()
        constants.put("SAMPLE_VALUE2", "Hello World2")
        return constants;
    }


    @ReactMethod
    fun getLocalizeTimeStringAsync(_timestamp: Double?, _format: String?, promise: Promise) {

        val time = if (_timestamp is Double) _timestamp.toLong() else System.currentTimeMillis()
        val format = if (_format is String) _format else "MM dd"

        val bestDateFormat = DateFormat.getBestDateTimePattern(Locale.getDefault(), _format);
        val dateFormat = SimpleDateFormat(bestDateFormat)
        val convertedDate = dateFormat.format(Date(time))
        promise.resolve(convertedDate)
    }

//    @ReactMethod
//    fun getLocalizeTimeString(_timestamp: Double?, _format: String?): String {
//
//        Log.d("tttt", _timestamp.toString())
//
//        val time = if (_timestamp is Double) _timestamp.toLong() else System.currentTimeMillis()
//        val format = if (_format is String) _format else "MM dd"
//
//        val bestDateFormat = DateFormat.getBestDateTimePattern(Locale.getDefault(), _format);
//        val dateFormat = SimpleDateFormat(bestDateFormat)
//        val convertedDate = dateFormat.format(Date(time))
//
//        return convertedDate.toString()
//    }


//    @ReactMethod
//    fun setBrightness(brightness : Float) {
//     val activity = currentActivity!!
//        activity.runOnUiThread {
//            val lp =activity.window.attributes
//            lp.screenBrightness = brightness
//            activity.window.attributes = lp
//        }
//    }
}