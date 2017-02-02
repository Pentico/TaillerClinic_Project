package com.tamcyber.taillerclinic_.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.tamcyber.taillerclinic_.R;
import com.tamcyber.taillerclinic_.internal.di.HasComponent;
import com.tamcyber.taillerclinic_.internal.di.components.DaggerLoginComponent;
import com.tamcyber.taillerclinic_.internal.di.components.DaggerUserComponent;
import com.tamcyber.taillerclinic_.internal.di.components.LoginComponent;
import com.tamcyber.taillerclinic_.view.fragment.LoginFragment;

/**
 * Created by Tuane on 4/01/17.
 */

public class LoginActivity extends BaseActivity  implements HasComponent<LoginComponent>{

    private LoginComponent loginComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activiy_layout);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new LoginFragment());
        }
    }

    private void initializeInjector() {
        this.loginComponent = DaggerLoginComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }



    @Override public LoginComponent getComponent() {
        return loginComponent;
    }

}
