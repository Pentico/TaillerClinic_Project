package com.tamcyber.taillerclinic_.internal.di.components;

import android.content.Context;

import com.domain.executor.PostExecutorThread;
import com.domain.executor.ThreadExecutor;
import com.tamcyber.taillerclinic_.internal.di.modules.ApplicationModule;
import com.tamcyber.taillerclinic_.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Tuane on 2016/12/14.
 */

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutorThread postExecutionThread();
//    UserRepository userRepository();
}
