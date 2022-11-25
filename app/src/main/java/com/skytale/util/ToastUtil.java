package com.skytale.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static final int duration = Toast.LENGTH_SHORT;

    public static void createToast(Context context, String message){
        Toast.makeText(context, message, duration).show();
    }
}
