package com.skytale.service;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import com.skytale.service.algoservice.AESService;
import com.skytale.service.algoservice.IAlgorithm;
import com.skytale.util.ToastUtil;

public class DecrypterService {
    public void handleDecryption(String encryptedText,
                                 String algorithm,
                                 Context context,
                                 TextView resultText) throws Exception
    {
        int n = encryptedText.length();
        String message;
        if(n != 0)
        {
            String plainText = decryptEncryptedText(encryptedText, algorithm);
            Log.i("decryptedText", plainText);
            resultText.setText(plainText);
            message = "Text Decrypted";
        }
        else{
            message = "Nothing To Decrypt!";
        }
        ToastUtil.createToast(context, message);
    }

    private String decryptEncryptedText(String encryptedText, String algorithm) throws Exception{
        String decryptedText = "";
        IAlgorithm algo;
        switch (algorithm)
        {
            case "AES":
                algo = new AESService();
                decryptedText = algo.decrypt(encryptedText);
                break;

            case "DES":
                break;
        }
        return decryptedText;
    }
}
