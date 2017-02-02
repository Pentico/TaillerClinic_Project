package com.tamcyber.taillerclinic_.view.activity;

import android.os.Bundle;

import com.tamcyber.taillerclinic_.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateToUserLogin();
    }

    /**
     * Goes to the login screen
     */
    void navigateToUserLogin(){
        this.navigator.navigateToUserLogin(this);
    }

    /**
     * Goes to the SignUp screen
     */
    void navigateToUserSignUp(){

    }
}
