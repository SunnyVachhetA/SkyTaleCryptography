package com.skytale.util;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class ClearUtil {
    private final static int duration = Toast.LENGTH_SHORT;
    public static void clearText(Context context, String text, EditText inputText){
        String message;
        if (text != null || text.length() != 0) {
            inputText.setText(null);
            message = "Text Removed.";
        }
        else {
            message = "Nothing To Remove! Please Try Again.";
        }
        Toast.makeText(context, message, duration).show();
    }
}
