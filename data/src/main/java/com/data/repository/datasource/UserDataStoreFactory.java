package com.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.data.cache.UserCache;
import com.data.entity.mapper.UserEntityJsonMapper;
import com.data.net.RestApi;
import com.data.net.RestApiImpl;

import javax.inject.Inject;

/**
 * Created by Tuane on 2016/12/21.
 */

public class UserDataStoreFactory {

    private final Context context;
    private final UserCache userCache;

    @Inject
    public UserDataStoreFactory(@NonNull Context context, @NonNull UserCache userCache) {
        this.context = context.getApplicationContext();
        this.userCache = userCache;
    }

    /**
     * Create {@link UserDataStore} from a user id.
     */
    public UserDataStore create(int userId) {
        UserDataStore userDataStore;

        if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = new DiskUserDataStore(this.userCache);
        } else {
            userDataStore = createCloudDataStore();
        }

        return userDataStore;
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     */
    public UserDataStore createCloudDataStore() {
        UserEntityJsonMapper userEntityJsonMapper = new UserEntityJsonMapper();
        RestApi restApi = new RestApiImpl(this.context, userEntityJsonMapper);

        return new CloudUserDataStore(restApi, this.userCache);
    }
}
