package com.example.ankur.ChatarPatar.cardstack.bus;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by etiennelawlor on 6/20/16.
 */

public class RxBus {

    private static final PublishSubject<Object> bus = PublishSubject.create();
//    private static final BehaviorSubject<Object> bus = BehaviorSubject.create();


    // If multiple threads are going to emit events to this
    // then it must be made thread-safe like this instead
//    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    private RxBus() {
        // No instances.
    }

    public static RxBus getInstance() {
        return new RxBus();
    }

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}
