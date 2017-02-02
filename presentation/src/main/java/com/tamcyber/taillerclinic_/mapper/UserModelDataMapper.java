package com.tamcyber.taillerclinic_.mapper;

import com.domain.User;
import com.tamcyber.taillerclinic_.internal.di.PerActivity;
import com.tamcyber.taillerclinic_.model.UserModel;

import javax.inject.Inject;

/**
 * Created by Tuane on 2016/12/21.
 */

@PerActivity
public class UserModelDataMapper {

    @Inject
    public UserModelDataMapper() {}

    /**
     * Transform a {@link User} into an {@link UserModel}.
     *
     * @param user Object to be transformed.
     * @return {@link UserModel}.
     */
    public UserModel transform(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        UserModel userModel = new UserModel(user.getUserId());
        userModel.setCoverUrl(user.getCoverUrl());
        userModel.setFullName(user.getFullName());
        userModel.setEmail(user.getEmail());
        userModel.setDescription(user.getDescription());
        userModel.setFollowers(user.getFollowers());

        return userModel;
    }

}

