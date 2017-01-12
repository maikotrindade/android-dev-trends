package br.com.monitoratec.app.util;

import android.util.Log;

import rx.Subscriber;

/**
 * Created by trindade on 12/01/17.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private static final String TAG = BaseSubscriber.class.getSimpleName();

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, e.getMessage(), e);
        onError(e.getMessage());
    }

    public abstract void onError(String message);
}
