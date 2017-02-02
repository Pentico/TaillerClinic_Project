package com.domain.interactor;

/**
 * Created by Tuane on 2016/12/21.
 */

import com.domain.executor.PostExecutorThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.UserRepository;

import javax.inject.Inject;
import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an specific {@link com.domain.User}.
 */
public class GetUserDetails extends UseCase {

    private final int userId;
    private final UserRepository userRepository;

    @Inject
    public GetUserDetails(int userId, UserRepository userRepository,
                          ThreadExecutor threadExecutor, PostExecutorThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userId = userId;
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.userRepository.user(this.userId);
    }
}
