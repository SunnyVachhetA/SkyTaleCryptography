package com.skytale.service;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import com.skytale.service.algoservice.AESService;
import com.skytale.service.algoservice.DESService;
import com.skytale.service.algoservice.IAlgorithm;
import com.skytale.service.algoservice.RC4Service;
import com.skytale.util.ToastUtil;

public class EncrypterService {
    public void handleEncryption(String plainText,
                                 String algorithm,
                                 Context context,
                                 TextView resultText) throws Exception
    {
        int n = plainText.length();
        String message;
        if(n != 0)
        {
            String encryptedText = encryptPlainText(plainText, algorithm);
            resultText.setText(encryptedText);
            Log.i("encryptedText", encryptedText);
            message = "Text Encrypted";
        }
        else{
            message = "Nothing To Encrypt!";
        }
        ToastUtil.createToast(context, message);
    }

    private String encryptPlainText(String plainText, String algorithm) throws Exception {
        String encryptedText = "";
        IAlgorithm algo;
        switch (algorithm)
        {
            case "AES":
                algo = new AESService();
                encryptedText = algo.encrypt(plainText);
                break;

            case "DES":
                algo = new DESService();
                encryptedText = algo.encrypt(plainText);
                break;


            case "RC4":
                algo = new RC4Service();
                encryptedText = algo.encrypt(plainText);
                break;
        }
        return encryptedText;
    }
}
