package com.testrnhms;

import android.app.Application;
import android.util.Log;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.huawei.hianalytics.hms.HiAnalyticsTools;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.testrnhms.rnconfig.RNBuildConfigPackage;

import java.util.ArrayList;
import java.util.List;

import rnhms.RNHMSPackage;

public class MainApplication extends Application implements ReactApplication {

    HiAnalyticsInstance instance;

    private final ReactNativeHost mReactNativeHost =
            new ReactNativeHost(this) {
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    @SuppressWarnings("UnnecessaryLocalVariable")
                    List<ReactPackage> packages = new PackageList(this).getPackages();
                    // Packages that cannot be autolinked yet can be added manually here, for example:
                    // packages.add(new MyReactNativePackage());

                    List<ReactPackage> temp = new ArrayList<>();

                    // taking MainReactPackage
                    temp.add(packages.get(0));
                    temp.add(new RNHMSPackage());
                    temp.add(new RNBuildConfigPackage());

                    return temp;
                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }
            };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        // initializeFlipper(this); // Remove this line if you don't want Flipper enabled

        HiAnalyticsTools.enableLog();

        instance = HiAnalytics.getInstance(this);

        Log.i("MainApplication", instance.toString());

        // TODO: can be configurable
        instance.setAnalyticsEnabled(true);
        // TODO: can be configurable
        instance.setAutoCollectionEnabled(true);

    }

}
