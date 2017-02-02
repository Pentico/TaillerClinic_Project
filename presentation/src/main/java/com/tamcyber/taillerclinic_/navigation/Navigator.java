package com.tamcyber.taillerclinic_.navigation;

import android.content.Context;
import android.content.Intent;

import com.tamcyber.taillerclinic_.view.activity.LoginActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 2016/12/14.
 */

@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    public void navigateToUserLogin(Context context){
        if(context != null){
            Intent intentToLaunch = LoginActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }
}
