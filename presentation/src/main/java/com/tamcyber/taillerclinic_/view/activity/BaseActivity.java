package com.tamcyber.taillerclinic_.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.tamcyber.taillerclinic_.AndroidApplication;
import com.tamcyber.taillerclinic_.internal.di.components.ApplicationComponent;
import com.tamcyber.taillerclinic_.internal.di.modules.ActivityModule;
import com.tamcyber.taillerclinic_.navigation.Navigator;

import javax.inject.Inject;

/**
 * Created by Tuane on 2016/12/14.
 */

public class BaseActivity  extends Activity{

    @Inject
    Navigator navigator;


    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link com.tamcyber.taillerclinic_.internal.di.components.ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link com.tamcyber.taillerclinic_.internal.di.modules.ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
