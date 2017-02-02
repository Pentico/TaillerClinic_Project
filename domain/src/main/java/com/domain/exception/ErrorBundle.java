package com.domain.exception;

/**
 * Created by Tuane on 2016/12/14.
 */

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
