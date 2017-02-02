package com.tamcyber.taillerclinic_.internal.di.components;

import com.tamcyber.taillerclinic_.internal.di.PerActivity;
import com.tamcyber.taillerclinic_.internal.di.modules.ActivityModule;
import com.tamcyber.taillerclinic_.internal.di.modules.UserModule;

import dagger.Component;

/**
 * Created by Tuane on 6/01/17.
 */

/**
 * A scope {@link PerActivity}
 * Injects User specific Fragments
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,  modules = {ActivityModule.class,
        UserModule.class})
public interface UserComponent extends ActivityComponent {

}
