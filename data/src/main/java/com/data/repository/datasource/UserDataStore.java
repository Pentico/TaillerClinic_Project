package com.data.repository.datasource;

/**
 * Created by Tuane on 2016/12/21.
 */

import com.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {

    /**
     * Get an {@link rx.Observable} which will emit a {@link UserEntity} by its id.
     *
     * @param userId The id to retrieve user data.
     */
    Observable<UserEntity> userEntityDetails(final int userId);
}
