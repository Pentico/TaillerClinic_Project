package com.tamcyber.taillerclinic_.presenter;

import com.domain.interactor.UseCase;

/**
 * Created by Tuane on 7/01/17.
 */

public class UserLoginPresenter implements Presenter {

    private final UseCase getUserLoginDetails;

    public UserLoginPresenter(UseCase getUserLoginDetails) {
        this.getUserLoginDetails = getUserLoginDetails;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
