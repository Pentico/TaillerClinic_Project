package com.tamcyber.taillerclinic_.internal.di.modules;

import android.app.Activity;

import com.tamcyber.taillerclinic_.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tuane on 2016/12/14.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
