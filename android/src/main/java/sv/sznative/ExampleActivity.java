package sv.sznative;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;
import com.gomfactory.adpie.sdk.AdView;


public final class ExampleActivity extends ReactActivity {

    private AdView adView;

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        Intent intent = getIntent(); /*데이터 수신*/

        String name = intent.getExtras().getString("name");
        int age = intent.getExtras().getInt("age");

        // Display app and React Native versions:
        this.<TextView>findViewById(R.id.app_version).setText("name : " + name);
        this.<TextView>findViewById(R.id.react_native_version).setText("age : " + age);

        findViewById(R.id.go_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.trigger_alert_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The target of this event does two things:
                // 1. It sets the "extra text" that shows up when you tap "Call JavaScript from Java"
                //    on the front page. This should always work.
                // 2. It calls "alert". This does note work unless this activity forwards lifecycle
                //    events to React Native. The easiest way to do that is to inherit ReactActivity
                //    instead of ReactActivity, but you can code it yourself if you want.
                // The iOS version does not suffer from this problem.
                // EventEmitterModule.emitEvent("Hello from " + ExampleActivity.class.getSimpleName());
                Toast.makeText(ExampleActivity.this, "Extra message was changed", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.call_javascript_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                ReactContext reactContext = getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
//                WritableMap params = Arguments.createMap();
//                params.putString("eventProperty", "good~" );
//                TestPpv3Module.sendEvent(reactContext, "EventReminder", params);
                SzNativeEventEmitterModule.testEmitEvent("goood~");

//                 MainApplication application = (MainApplication) ExampleActivity.this.getApplication();
//                 ReactNativeHost reactNativeHost = application.getReactNativeHost();
//                 ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
//                 ReactContext reactContext = reactInstanceManager.getCurrentReactContext();
//
//                 if (reactContext != null) {
//                     CatalystInstance catalystInstance = reactContext.getCatalystInstance();
//                     WritableNativeArray params = new WritableNativeArray();
//                     params.pushString("Set Extra Message was called!");
//
//                     // AFAIK, this approach to communicate from Java to JavaScript is officially undocumented.
//                     // Use at own risk; prefer events.
//
//                     // Note: Here we call 'setMessage', which does not show UI. That means it is okay
//                     // to call it from an activity that doesn't forward lifecycle events to React Native.
//                     catalystInstance.callFunction("JavaScriptVisibleToJava", "setMessage", params);
//                     Toast.makeText(ExampleActivity.this, "Extra message was changed", Toast.LENGTH_SHORT).show();
//
//                     try {
//                         // Need new params, as the old has been consumed and would cause an exception
//                         params = new WritableNativeArray();
//                         params.pushString("Hello, alert! From native side!");
//
//                         // Note: Here we call 'alert', which does show UI. That means it does nothing if
//                         // called from an activity that doesn't forward lifecycle events to React Native.
//                         // See comments on EventEmitterModule.emitEvent above.
//                         catalystInstance.callFunction("JavaScriptVisibleToJava", "alert", params);
//                     } catch (Exception e) {
//                         Toast.makeText(ExampleActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                     }
//                 }
            }
        });


        adView = (AdView) findViewById(R.id.ad_view);
        adView.setSlotId("57342e0d7174ea39844cac13");

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
                 Log.d("pppppp", "onAdFailedToLoad");
                 Log.d("pppppp",String.valueOf(errorCode));
             }

             @Override
             public void onAdClicked() {
                 // 광고 클릭 후 이벤트 발생
                 Log.d("pppppp", "onAdClicked");
             }
         });
        adView.load();

    }
}
