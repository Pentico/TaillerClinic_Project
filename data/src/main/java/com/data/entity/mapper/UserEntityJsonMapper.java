package com.data.entity.mapper;

/**
 * Created by Tuane on 2016/12/21.
 */

import com.data.entity.UserEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing json to valid objects.
 */
public class UserEntityJsonMapper {

    private final Gson gson;

    @Inject
    public UserEntityJsonMapper(){
        this.gson = new Gson();
    }

    /**
     * Tranform from valid json string to {@link UserEntity}
     *
     * @param userJsonResponse A json rep a user data
     * @return {@link UserEntity}
     * @throws JsonSyntaxException if the json string is not a valid json format.
     */
    public UserEntity transformUserEntity(String userJsonResponse)throws JsonSyntaxException{
        try{
            Type userEntityType = new TypeToken<UserEntity>(){}.getType();
            UserEntity userEntity = this.gson.fromJson(userJsonResponse, userEntityType);

            return userEntity;
        }catch (JsonSyntaxException jsonException){
            throw jsonException;
        }
    }
}
