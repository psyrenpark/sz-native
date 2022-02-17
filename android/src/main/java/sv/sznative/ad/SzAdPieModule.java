// SzNativeModule.java

package sv.sznative.ad;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.gomfactory.adpie.sdk.AdPieSDK;


public class SzAdPieModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public SzAdPieModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "SzAdPie"; //TODO: SzNativeModule (x) // ios와 통일을 위해
    }

    // ----------------------------------------
    // ReactMethod

    @ReactMethod
    public void init(String text) {
        AdPieSDK.getInstance().initialize(reactContext, "57342d1b7174ea39844cac10" );

        Log.d("pppppp", "init");
        Toast.makeText(reactContext, text, Toast.LENGTH_LONG).show();
    }

//    @ReactMethod
//    public void testCallBack(String stringArgument, int numberArgument, Callback mySuccessCallback, Callback myFailureCallback) {
//        String data = "Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument;
//        // 안드로이드 작업
//
//        // 성공
//        if (true) {
//            mySuccessCallback.invoke(data);
//        }
//        // 실패
//        else {
//            myFailureCallback.invoke("error");
//        }
//    }
//
//    @ReactMethod
//    public void testCallBackToAsync(String stringArgument, int numberArgument, Promise callback) {
//
//        String data = "Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument;
//
//        try {
//            // 안드로이드 작업
//            callback.resolve(data);
//        } catch (Exception e) {
//            callback.reject("Create Event Error", e);
//        }
//    }
//
//    @ReactMethod
//    void testStartActivity(String name, Integer age) {
//
//        Activity activity = getCurrentActivity();
//
//        if (activity != null) {
//            Intent intent = new Intent(activity, ExampleActivity.class);
//            intent.putExtra("name", name); /*송신*/
//            intent.putExtra("age", age);
//            activity.startActivity(intent);
//
//        }
//    }
//
//    @ReactMethod
//    public void testCreateEvent(String text) {
//        SzNativeEventEmitterModule.testEmitEvent(text);
//    }

}
