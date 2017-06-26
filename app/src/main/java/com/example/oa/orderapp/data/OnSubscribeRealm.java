//package com.example.oa.orderapp.data;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//
//import org.reactivestreams.Subscriber;
//import org.reactivestreams.Subscription;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//import io.reactivex.Observable;
//import io.realm.Realm;
//import io.realm.exceptions.RealmException;
//
//
///**
// * Created by Ikorn Solutions Ltd,.. on 12/6/2016.
// */
//
//public abstract class OnSubscribeRealm<T> implements OnS<T> {
//    private final Context context;
//    private final String fileName;
//
//    private final List<Subscriber<? super T>> subscribers = new ArrayList<>();
//    private final AtomicBoolean canceled = new AtomicBoolean();
//    private final Object lock = new Object();
//
//    public OnSubscribeRealm(Context context) {
//        this(context, null);
//    }
//
//    public OnSubscribeRealm(Context context, String fileName) {
//        this.context = context.getApplicationContext();
//        this.fileName = fileName;
//    }
//
//    @Override
//    public void call(final Subscriber<? super T> subscriber) {
//        synchronized (lock) {
//            boolean canceled = this.canceled.get();
//            if (!canceled && !subscribers.isEmpty()) {
//                subscriber.add(newUnsubscribeAction(subscriber));
//                subscribers.add(subscriber);
//                return;
//            } else if (canceled) {
//                return;
//            }
//        }
//        subscriber.add(newUnsubscribeAction(subscriber));
//        subscribers.add(subscriber);
//
////        RealmConfiguration.Builder builder = new RealmConfiguration.Builder(context);
////        if (fileName != null) {
////            builder.name(fileName);
////        }
////        Realm realm = Realm.getInstance(builder.build());
//        Realm realm = Realm.getDefaultInstance();
//
//        boolean withError = false;
//
//        T object = null;
//        try {
//            if (!this.canceled.get()) {
//                realm.beginTransaction();
//                object = get(realm);
//                if (object != null && !this.canceled.get()) {
//                    realm.commitTransaction();
//                } else {
//                    realm.cancelTransaction();
//                }
//            }
//        } catch (RuntimeException e) {
//            realm.cancelTransaction();
//            sendOnError(new RealmException("Error during transaction.", e));
//            withError = true;
//        } catch (Error e) {
//            realm.cancelTransaction();
//            sendOnError(e);
//            withError = true;
//        }
//        if (object != null && !this.canceled.get() && !withError) {
//            sendOnNext(object);
//        }
//
//        try {
//            realm.close();
//        } catch (RealmException ex) {
//            sendOnError(ex);
//            withError = true;
//        }
//        if (!withError) {
//            sendOnCompleted();
//        }
//        this.canceled.set(false);
//    }
//
//    private void sendOnNext(T object) {
//        for (int i = 0; i < subscribers.size(); i++) {
//            Subscriber<? super T> subscriber = subscribers.get(i);
//            subscriber.onNext(object);
//        }
//    }
//
//    private void sendOnError(Throwable e) {
//        for (int i = 0; i < subscribers.size(); i++) {
//            Subscriber<? super T> subscriber = subscribers.get(i);
//            subscriber.onError(e);
//        }
//    }
//
//    private void sendOnCompleted() {
//        for (int i = 0; i < subscribers.size(); i++) {
//            Subscriber<? super T> subscriber = subscribers.get(i);
//            subscriber.onComplete();
//        }
//    }
//
//    @NonNull
//    private Subscription newUnsubscribeAction(final Subscriber<? super T> subscriber) {
//        return Subscriptions.create(() -> {
//            synchronized (lock) {
//                subscribers.remove(subscriber);
//                if (subscribers.isEmpty()) {
//                    canceled.set(true);
//                }
//            }
//        });
//    }
//
//    public abstract T get(Realm realm);
//}
