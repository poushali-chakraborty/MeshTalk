package com.pc.makingup.meshtalk;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static final String PREFS_NAME = "meshtalk_prefs";
    private static final String KEY_NICKNAME = "nickname";

    public static void setNickname(Context ctx, String nickname) {
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_NICKNAME, nickname).apply();
    }

    public static String getNickname(Context ctx) {
        return ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getString(KEY_NICKNAME, "MeshUser");
    }
}