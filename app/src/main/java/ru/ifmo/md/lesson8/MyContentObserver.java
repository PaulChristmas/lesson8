package ru.ifmo.md.lesson8;

import android.os.Handler;
import android.database.ContentObserver;
import android.net.Uri;

public class MyContentObserver extends ContentObserver {
    Handler mHandler;
    Callbacks mCallback = null;
    public interface Callbacks {
        public void onObserverFired();
    }
    public MyContentObserver(Callbacks callback) {
        super(null);
        mHandler = new Handler();
        mCallback = callback;
    }
    @Override
    public void onChange(boolean selfChange) {
        mCallback.onObserverFired();
    }
    @Override
    public void onChange(boolean selfChange, Uri uri) {
        onChange(selfChange);
    }
}