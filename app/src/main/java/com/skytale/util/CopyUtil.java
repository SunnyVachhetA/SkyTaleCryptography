package com.skytale.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.skytale.service.ClipboardManagerUtilService;

public class CopyUtil {
    private final static int duration = Toast.LENGTH_SHORT;
    private static ClipboardManagerUtilService clipboardService;
    public static void copyText(Context context, String text){
        String message = "";
        if(text.length() != 0){
            Log.i("copyText", text);
            clipboardService = new ClipboardManagerUtilService(context);
            clipboardService.saveCopyTextToClipboard(text);
            message = "Text Copied To Clipboard.";
        }
        else
        {
            message = "Nothing To Copy! Please Try Again";
        }
        Toast.makeText(context, message, duration).show();
    }
}
