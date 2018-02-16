package com.example.rick.mymediaplayer.utils;

import com.example.rick.mymediaplayer.utils.Time;

/**
 * Created by Rick on 2/15/2018.
 */

public final class StringTimeCreate {

    private static final String TIME_PATTERN = "%3d:%02d";

    public static String getTimeUsingMilliSecs (int milliseconds) {
        int seconds = milliseconds / Time.ONE_SECOND_IN_MILLISECONDS;
        return getTimeUsingMilliSecs(seconds);
    }

    public static String getTimeUsingSeconds (int seconds) {
        int timeMinutes = seconds / Time.ONE_MINUTE_IN_SECONDS;
        int timeSeconds = seconds % Time.ONE_MINUTE_IN_SECONDS;
        String strCurrentTime = String.format(TIME_PATTERN, timeMinutes, timeSeconds);
        return strCurrentTime;
    }

    private StringTimeCreate() {
    }

}
