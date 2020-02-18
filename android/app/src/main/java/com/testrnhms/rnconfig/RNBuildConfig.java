package com.testrnhms.rnconfig;

import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.testrnhms.BuildConfig;

public class RNBuildConfig extends ReactContextBaseJavaModule {

    private String flavor;

    public RNBuildConfig(ReactApplicationContext reactContext) {
        super(reactContext);
        flavor = BuildConfig.FLAVOR;
    }

    @Override
    public String getName() {
            return "BuildConfigTest";
    }

    @ReactMethod
    public void getFlavor(final Promise promise) {

        if (null == flavor) {
            promise.reject("-1", "Error with FLAVOR");
            return;
        }
        WritableMap map = Arguments.createMap();
        map.putString("flavor", flavor);

        promise.resolve(map);
    }

}