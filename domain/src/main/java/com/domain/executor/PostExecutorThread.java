package com.domain.executor;

import rx.Scheduler;

/**
 * Created by Tuane on 2016/12/14.
 */

public interface PostExecutorThread {
    Scheduler getScheduler();
}
