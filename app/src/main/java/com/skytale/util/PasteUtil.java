package com.skytale.util;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.skytale.service.ClipboardManagerUtilService;

public class PasteUtil {

    private final static int duration = Toast.LENGTH_SHORT;
    private static ClipboardManagerUtilService clipboardService;

    public static void pasteText(Context context, EditText inputText) {
        clipboardService = new ClipboardManagerUtilService(context);
        String message = "";
        if(clipboardService.hasClipboardPrimaryClip() && clipboardService.isClipboardPlainText())
        {
            message = "Paste Success.";
            String pasteData = clipboardService.getClipboardPasteText();
            Log.i("pasteData", pasteData);
            inputText.setText(pasteData);
        }
        else message = "Unsupported Paste Operation!";
        ToastUtil.createToast(context, message);
    }
}
