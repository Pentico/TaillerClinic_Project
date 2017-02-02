package com.domain.repository;

import com.domain.User;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 2016/12/14.
 */

public interface UserRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link User}.
     */
    Observable<List<User>> users();

    /**
     * Get an {@link rx.Observable} which will emit a {@link User}.
     *
     * @param userId The user id used to retrieve user data.
     */
    Observable<User> user(final int userId);
}
