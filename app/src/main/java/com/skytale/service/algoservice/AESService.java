package com.skytale.service.algoservice;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESService implements IAlgorithm{

    private final static String SECRET_KEY = "SkyTaleCrypto";
    private final static String SALT = "Salt!";
    private static byte[] IV;
    private static SecretKeyFactory secretKeyFactory;
    private static KeySpec keySpec;
    private static SecretKey secretKey;
    private static SecretKeySpec secretKeySpec;
    private static IvParameterSpec ivParameterSpec;

    private static Cipher cipher;
    public AESService() {}
    static{
        try{
            IV = new byte[16];
            IV = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            ivParameterSpec = new IvParameterSpec(IV);
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            keySpec = new PBEKeySpec(SECRET_KEY.toCharArray(),
                    SALT.getBytes(),
                    65536,
                    256);
            secretKey = secretKeyFactory.generateSecret(keySpec);
            secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

        }catch (Exception e)
        {
            Log.e("aesInitError", "AES INIT() Error");
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String encrypt(String plainText) throws Exception{

        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        return Base64.getEncoder()
                .encodeToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String decrypt(String encryptedData) throws Exception{
        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
}
