package com.tamcyber.taillerclinic_;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tamcyber.taillerclinic_.internal.di.components.ApplicationComponent;
import com.tamcyber.taillerclinic_.internal.di.components.DaggerApplicationComponent;
import com.tamcyber.taillerclinic_.internal.di.modules.ApplicationModule;

/**
 * Created by Tuane on 2016/12/14.
 */

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}

