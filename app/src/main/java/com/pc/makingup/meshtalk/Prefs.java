package com.pc.makingup.meshtalk;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static final String PREFS_NAME = "meshtalk_prefs";
    private static final String KEY_NICKNAME = "nickname";

    public static void setNickname(Context context, String nickname) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_NICKNAME, nickname).apply();
    }

    public static String getNickname(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getString(KEY_NICKNAME, "");
    }
}
