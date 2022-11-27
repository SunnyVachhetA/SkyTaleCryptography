package com.skytale.service.algoservice;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DESService implements IAlgorithm{
    private static Cipher cipher;
    private static final String SECRET_KEY = "SkyTaleC";
    private static SecretKeyFactory secretKeyFactory;
    private static DESKeySpec myMaterial;
    private static SecretKey myDESKey;
    public DESService(){}

    static {
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("DES");
            byte[] mybyte = SECRET_KEY.getBytes();
            myMaterial = new DESKeySpec(mybyte);
            myDESKey = secretKeyFactory.generateSecret(myMaterial);
            cipher = Cipher.getInstance("DES");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("initDESError", e.getMessage());
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String encrypt(String plainText) throws Exception {
        System.out.println("DESEncrypt: " + plainText);
        try {
            cipher.init(Cipher.ENCRYPT_MODE, myDESKey);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
        }catch (Exception e)
        {
            Log.e("desEncryptionError", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String decrypt(String encryptedText) throws Exception {
        try {
            cipher.init(Cipher.DECRYPT_MODE, myDESKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
        }catch (Exception e)
        {
            Log.e("desDecryptionError", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
