package com.skytale.service;

import android.content.Context;
import android.widget.TextView;
import com.skytale.util.ToastUtil;

public class EncrypterService {
    public void handleEncryption(String plainText, String algorithm, Context context, TextView resultText){
        int n = plainText.length();
        String message;
        if(n != 0)
        {
            String encryptedText = encryptPlainText(plainText, algorithm);
            message = "Text Encrypted";
        }
        else{
            message = "Nothing To Encrypt!";
        }
        ToastUtil.createToast(context, message);
    }

    private String encryptPlainText(String plainText, String algorithm) {
        String encryptedText = "";
        switch (algorithm)
        {
            case "AES":
                break;

            case "DES":
                break;
        }
        return encryptedText;
    }
}
