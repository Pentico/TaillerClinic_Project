package com.data.repository.datasource;

import com.data.cache.UserCache;
import com.data.entity.UserEntity;

import rx.Observable;

/**
 * Created by Tuane on 2016/12/21.
 */

public class DiskUserDataStore implements UserDataStore {

    private final UserCache userCache;

    /**
     * Construct a {@link UserDataStore} based file system data store.
     *
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    DiskUserDataStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override public Observable<UserEntity> userEntityDetails(final int userId) {
        return this.userCache.get(userId);
    }

}
