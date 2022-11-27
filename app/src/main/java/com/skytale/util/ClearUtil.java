package com.skytale.util;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClearUtil {
    private final static int duration = Toast.LENGTH_SHORT;
    public static void clearText(Context context, String text, EditText inputText){
        String message;
        if (text.length() != 0) {
            inputText.setText(null);
            message = "Text Removed.";
        }
        else {
            message = "Nothing To Remove! Please Try Again.";
        }
        ToastUtil.createToast(context, message);
    }
    public static void clearText(TextView resultText){
        resultText.setText(null);
    }
}
