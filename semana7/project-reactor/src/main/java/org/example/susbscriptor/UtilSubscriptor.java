package org.example.susbscriptor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class UtilSubscriptor<T> implements Subscriber<T> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription=s;

    }

    @Override
    public void onNext(T t) {
        System.out.println("on next: "+ t);

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Throwable: "+ throwable);

    }

    @Override
    public void onComplete() {
        System.out.println("se termino de emitir");

    }
}
