package io.blackbox_vision.datetimepickeredittext.internal.utils;


import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Utils {

    public static String format(@NonNull final Date date, @NonNull final String template) {
        return new SimpleDateFormat(template, Locale.getDefault()).format(date);
    }
}
