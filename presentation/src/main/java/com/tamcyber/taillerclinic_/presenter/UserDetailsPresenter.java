package com.tamcyber.taillerclinic_.presenter;

import android.support.annotation.NonNull;

import com.domain.User;
import com.domain.exception.DefaultErrorBundle;
import com.domain.exception.ErrorBundle;
import com.domain.interactor.DefaultSubscriber;
import com.domain.interactor.UseCase;
import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.tamcyber.taillerclinic_.execution.ErrorMessageFactory;
import com.tamcyber.taillerclinic_.mapper.UserModelDataMapper;
import com.tamcyber.taillerclinic_.model.UserModel;
import com.tamcyber.taillerclinic_.view.UserDetailsView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Tuane on 2016/12/21.
 */

public class UserDetailsPresenter implements Presenter {

    private UserDetailsView userDetailsView;

    private final UseCase getUserDetailsUseCase;
    private final UserModelDataMapper userModelDataMapper;


    @Inject
    public UserDetailsPresenter(@Named("userDetails") UseCase getUserDetailsUseCase,
                                UserModelDataMapper userModelDataMapper) {
        this.getUserDetailsUseCase = getUserDetailsUseCase;
        this.userModelDataMapper = userModelDataMapper;
    }


    public void setView(@NonNull UserDetailsView view) {
        this.userDetailsView = view;
    }

    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getUserDetailsUseCase.unsubscribe();
        this.userDetailsView = null;
    }

    /**
     * Initializes the presenter by start retrieving user details.
     */
    public void initialize() {
        this.loadUserDetails();
    }

    /**
     * Loads user details.
     */
    private void loadUserDetails() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getUserDetails();
    }

    private void showViewLoading() {
        this.userDetailsView.showLoading();
    }

    private void hideViewLoading() {
        this.userDetailsView.hideLoading();
    }

    private void showViewRetry() {
        this.userDetailsView.showRetry();
    }

    private void hideViewRetry() {
        this.userDetailsView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.userDetailsView.context(),
                errorBundle.getException());
        this.userDetailsView.showError(errorMessage);
    }

    private void showUserDetailsInView(User user) {
        final UserModel userModel = this.userModelDataMapper.transform(user);
        this.userDetailsView.renderUser(userModel);
    }

    private void getUserDetails() {
        this.getUserDetailsUseCase.execute(new UserDetailsSubscriber());
    }

    @RxLogSubscriber
    private final class UserDetailsSubscriber extends DefaultSubscriber<User> {

        @Override
        public void onCompleted() {
            UserDetailsPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            UserDetailsPresenter.this.hideViewLoading();
            UserDetailsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            UserDetailsPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(User user) {
            UserDetailsPresenter.this.showUserDetailsInView(user);
        }
    }
}
