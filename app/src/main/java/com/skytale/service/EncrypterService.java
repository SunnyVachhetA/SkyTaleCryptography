package com.skytale.service;

import android.content.Context;
import com.skytale.util.ToastUtil;

public class EncrypterService {
    public void handleEncryption(String plainText, String algorithm, Context context){
        int n = plainText.length();
        String message;
        if(n != 0)
        {
            message = "Text Encrypted";
        }
        else{
            message = "Nothing To Encrypt!";
        }
        ToastUtil.createToast(context, message);
    }
}
