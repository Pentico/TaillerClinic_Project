package com.data.net;

/**
 * Created by Tuane on 2016/12/21.
 */

import com.data.entity.UserEntity;

import rx.Observable;

/**
 * RestApi for restrieving data from server.
 */
public interface RestApi {

    // The main address location
    String API_BASE_URL = "http://www.tailerclinic.com/app/--";

    /** Api url for getting all users */
    String API_URL_GET_USER_LIST = API_BASE_URL + "users.json";
    /** Api url for getting a user profile: Remember to concatenate id + 'json' */
    String API_URL_GET_USER_DETAILS = API_BASE_URL + "user_";
    /**
     * Retrieves an {@link rx.Observable} which will emit a List of {@link UserEntity}
     *
     */
    Observable<UserEntity> userEntityById(final int userId);

}
