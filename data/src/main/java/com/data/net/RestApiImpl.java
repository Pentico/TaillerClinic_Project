package com.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.data.entity.UserEntity;
import com.data.entity.mapper.UserEntityJsonMapper;
import com.data.exception.NetworkConnectionException;
import com.fernandocejas.frodo.annotation.RxLogObservable;

import java.net.MalformedURLException;

import rx.Observable;

/**
 * Created by Tuane on 2016/12/21.
 */

public class RestApiImpl implements RestApi {

    private final Context context;
    private final UserEntityJsonMapper userEntityJsonMapper;

    /**
     * Constructor of the class
     *
     * @param context {@link android.content.Context}.
     * @param userEntityJsonMapper {@link UserEntityJsonMapper}.
     */
    public RestApiImpl(Context context, UserEntityJsonMapper userEntityJsonMapper) {
        if (context == null || userEntityJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.userEntityJsonMapper = userEntityJsonMapper;
    }


    @RxLogObservable
    @Override
    public Observable<UserEntity> userEntityById(final int userId) {
        return Observable.create(subscriber -> {
            if (isThereInternetConnection()) {
                try {
                    String responseUserDetails = "Get Response.."; // getUserDetailsFromApi(userId);    // TODO fix this part
                    if (responseUserDetails != null) {
                        subscriber.onNext(userEntityJsonMapper.transformUserEntity(responseUserDetails));
                        subscriber.onCompleted();
                    } else {
                        subscriber.onError(new NetworkConnectionException());
                    }
                } catch (Exception e) {
                    subscriber.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                subscriber.onError(new NetworkConnectionException());
            }
        });
    }

   /* private String getUserEntitiesFromApi() throws MalformedURLException {
        return ApiConnection.createGET(API_URL_GET_USER_LIST).requestSyncCall();
    }

    private String getUserDetailsFromApi(int userId) throws MalformedURLException {
        String apiUrl = API_URL_GET_USER_DETAILS + userId + ".json";
        return ApiConnection.createGET(apiUrl).requestSyncCall();
    }*/

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
