// SzNativePackage.java

package sv.sznative;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sv.sznative.ad.SzAdPie2Manager;
import sv.sznative.ad.SzAdPie3Manager;
import sv.sznative.ad.SzAdPie4Manager;
import sv.sznative.ad.SzAdPieManager;
import sv.sznative.ad.SzAdPieModule;
import sv.sznative.counter.CounterManager;
import sv.sznative.test.BrightnessModule;
import sv.sznative.test.LocalizeTimeModule;
import sv.sznative.test.MyViewManager;


public class SzNativePackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        // return Arrays.<NativeModule>asList(new SzNativeModule(reactContext));
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new SzNativeModule(reactContext));
        modules.add(new SzNativeEventEmitterModule(reactContext));
        modules.add(new BrightnessModule(reactContext));
        modules.add(new LocalizeTimeModule(reactContext));
        modules.add(new SzAdPieModule(reactContext));
        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new SzNativeManager(),
                new CounterManager(),
                new SzAdPieManager(),
                new SzAdPie2Manager(),
                new SzAdPie3Manager(),
                new SzAdPie4Manager(reactContext),
                new MyViewManager(reactContext)
        );
    }
}
