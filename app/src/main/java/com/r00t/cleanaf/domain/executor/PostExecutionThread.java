package com.r00t.cleanaf.domain.executor;

import io.reactivex.Scheduler;

public interface PostExecutionThread {

    Scheduler getScheduler();
}
