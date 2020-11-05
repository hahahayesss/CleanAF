package com.r00t.cleanaf.presentation.exception;

import android.content.Context;

import com.r00t.cleanaf.data.exception.NetworkConnectionException;

public class ErrorMessageFactory {

    public static String create(Context context, Exception exception) {
        String message = "There was an application error";

        if (exception instanceof NetworkConnectionException)
            message = "There is no internet connection";
        return message;
    }
}
