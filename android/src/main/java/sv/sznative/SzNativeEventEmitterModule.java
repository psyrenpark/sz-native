package sv.sznative;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

/**
 * Supports sending events to JavaScript.
 */
final class SzNativeEventEmitterModule extends ReactContextBaseJavaModule {

    private static DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = null;

    SzNativeEventEmitterModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public void initialize() {
        super.initialize();
        eventEmitter = getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /**
     * @return the name of this module. This will be the name used to {@code require()} this module
     * from JavaScript.
     */
    @Override
    public String getName() {
        return "SzNativeEventEmitter"; //TODO: SzNativeEventEmitterModule (x) // ios와 통일을 위해
    }

    @SuppressWarnings("ConstantConditions")
    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("MyEventName", "MyEventValue");
        return constants;
    }

    /**
     * To pass a JavaScript object instead of a simple string, create a {@link WritableNativeMap} and populate it.
     */
    @ReactMethod
    static void testEmitEvent(@NonNull String message) {

        WritableMap params = Arguments.createMap();
        params.putString("data", message);

        eventEmitter.emit("EventReminder", message);
    }
}
