package com.data.repository.datasource;

import com.data.cache.UserCache;
import com.data.entity.UserEntity;
import com.data.net.RestApi;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Tuane on 2016/12/21.
 */

public class CloudUserDataStore implements UserDataStore {

    private final RestApi restApi;
    private final UserCache userCache;


    private final Action1<UserEntity> saveToCacheAction = userEntity -> {
        if (userEntity != null) {
            CloudUserDataStore.this.userCache.put(userEntity);
        }
    };

    /**
     * Construct a {@link UserDataStore} based on connections to the api (Cloud).
     *
     * @param restApi The {@link RestApi} implementation to use.
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    CloudUserDataStore(RestApi restApi, UserCache userCache) {
        this.restApi = restApi;
        this.userCache = userCache;
    }

    @Override
    public Observable<UserEntity> userEntityDetails(final int userId) {
        return this.restApi.userEntityById(userId).doOnNext(saveToCacheAction);
    }
}
