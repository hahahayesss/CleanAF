package com.r00t.cleanaf.domain.interactor;

import com.r00t.cleanaf.domain.executor.PostExecutionThread;
import com.r00t.cleanaf.domain.executor.ThreadExecutor;

import dagger.hilt.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, P> {
    private ThreadExecutor threadExecutor;
    private PostExecutionThread postExecutionThread;

    private CompositeDisposable disposables;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    abstract Observable<T> buildUseCaseObservable(P p);

    public void execute(DisposableObserver<T> observer, P p) {
        Preconditions.checkNotNull(observer);
        Observable<T> observable = buildUseCaseObservable(p)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
    }

    public void dispose() {
        if (!disposables.isDisposed())
            disposables.dispose();
    }

    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }
}
