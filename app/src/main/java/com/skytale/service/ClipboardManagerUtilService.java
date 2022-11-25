package com.skytale.service;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class ClipboardManagerUtilService {
    private ClipboardManager clipboardManager;
    public ClipboardManagerUtilService(Context context){
        clipboardManager = ClipboardManagerService.getClipboardInstance(context);
    }
    public boolean hasClipboardPrimaryClip(){
        return clipboardManager.hasPrimaryClip();
    }

    public boolean isClipboardPlainText(){
        return !(clipboardManager.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN));
    }

    public void saveCopyTextToClipboard(String text){
        ClipData clipData = ClipData.newPlainText("copiedText", text);
        clipboardManager.setPrimaryClip(clipData);
    }

    public String getClipboardPasteText(){
        ClipData.Item item = clipboardManager.getPrimaryClip().getItemAt(0);
        return item.getText().toString();
    }
}
