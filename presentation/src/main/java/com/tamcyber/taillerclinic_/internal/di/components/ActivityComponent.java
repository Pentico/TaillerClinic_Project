package com.tamcyber.taillerclinic_.internal.di.components;

import android.app.Activity;

import com.tamcyber.taillerclinic_.internal.di.PerActivity;
import com.tamcyber.taillerclinic_.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by Tuane on 2016/12/14.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}