package com.skytale.service;

import android.content.ClipboardManager;
import android.content.Context;

//Singleton Class Implementation;
public class ClipboardManagerService {
    private static ClipboardManager clipboardManager;
    private ClipboardManagerService(){}

    public static ClipboardManager getClipboardInstance(Context context){
        if(clipboardManager == null)
        {
           clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        }
        return clipboardManager;
    }
}
