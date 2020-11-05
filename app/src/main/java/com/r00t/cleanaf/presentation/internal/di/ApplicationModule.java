package com.r00t.cleanaf.presentation.internal.di;

import com.r00t.cleanaf.data.executor.JobExecutor;
import com.r00t.cleanaf.domain.executor.PostExecutionThread;
import com.r00t.cleanaf.domain.executor.ThreadExecutor;
import com.r00t.cleanaf.presentation.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class ApplicationModule {

    @Singleton
    @Provides
    public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Singleton
    @Provides
    public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
