package com.tamcyber.taillerclinic_.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Tuane on 2016/12/14.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
