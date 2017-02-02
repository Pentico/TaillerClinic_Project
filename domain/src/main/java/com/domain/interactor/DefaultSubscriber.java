package com.domain.interactor;

/**
 * Created by Tuane on 2016/12/14.
 */

public class DefaultSubscriber<T> extends rx.Subscriber<T> {

    @Override public void onCompleted() {
        // no-op by default.
    }

    @Override public void onError(Throwable e) {
        // no-op by default.
    }

    @Override public void onNext(T t) {
        // no-op by default.
    }
}
