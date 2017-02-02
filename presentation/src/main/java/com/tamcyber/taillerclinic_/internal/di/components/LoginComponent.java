package com.tamcyber.taillerclinic_.internal.di.components;

/**
 * Created by Tuane on 6/01/17.
 */

import com.tamcyber.taillerclinic_.internal.di.PerActivity;
import com.tamcyber.taillerclinic_.internal.di.modules.ActivityModule;
import com.tamcyber.taillerclinic_.internal.di.modules.LoginModule;
import com.tamcyber.taillerclinic_.view.fragment.LoginFragment;

import dagger.Component;

/**
 * A scope {@link PerActivity}
 * Injects User specific Fragments
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,  modules = {ActivityModule.class,
        LoginModule.class})
public interface LoginComponent extends ActivityComponent {
    void inject(LoginFragment loginFragment);
}
