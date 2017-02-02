package com.tamcyber.taillerclinic_;

import com.domain.executor.PostExecutorThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Tuane on 2016/12/14.
 */

@Singleton
public class UIThread implements PostExecutorThread {

    @Inject
    public UIThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}

