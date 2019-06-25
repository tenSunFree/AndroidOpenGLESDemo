package com.home.androidopenglesdemo.util;

import android.util.Log;

class LogUtil {

    private static final boolean LOGD_DEBUG = true;
    private static final int STACK_INDEX = 2;

    /**
     * Used for persistent log
     *
     * @param msg
     */
    static void d(String msg) {
        boolean mLogAll = true;
        if (LOGD_DEBUG && mLogAll) {
            String DEFAULT_TAG = "OpenGLTutorial";
            Log.d(DEFAULT_TAG, getInformation(msg));
        }
    }

    private static String getInformation(String msg) {
        Exception exception = new Exception();
        return exception.getStackTrace()[STACK_INDEX].getFileName() + "|"
                + exception.getStackTrace()[STACK_INDEX].getMethodName() + "|"
                + exception.getStackTrace()[STACK_INDEX].getLineNumber() + "|" + msg;
    }
}
