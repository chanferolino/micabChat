package org.awesomeapp.messenger.service;

import java.io.File;

import android.content.Context;

public interface ImService {
    void showToast(CharSequence text, int duration);
    Context getApplicationContext();
}
