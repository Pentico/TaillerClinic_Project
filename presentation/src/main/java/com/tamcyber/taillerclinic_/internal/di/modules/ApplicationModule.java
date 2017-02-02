package com.tamcyber.taillerclinic_.internal.di.modules;

import android.content.Context;

import com.data.executor.JobExecutor;
import com.domain.executor.PostExecutorThread;
import com.domain.executor.ThreadExecutor;
import com.tamcyber.taillerclinic_.AndroidApplication;
import com.tamcyber.taillerclinic_.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tuane on 2016/12/14.
 */

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutorThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

//    @Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
//        return userCache;
//    }
//
//    @Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
//        return userDataRepository;
//    }
}