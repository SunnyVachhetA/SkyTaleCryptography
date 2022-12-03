package com.skytale.service.algoservice;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class RC4Service implements IAlgorithm{

    private static SecretKeySpec secretKeySpec;
    private static final String SECRET_KEY = "SkyTaleC";
    private static final String HASHED_SECRET_KEY;
    private static Cipher cipher;

    static
    {
        try {
            HASHED_SECRET_KEY = hashedData();
            secretKeySpec = new SecretKeySpec(Hex.decode(HASHED_SECRET_KEY), "RC4" );
            cipher = Cipher.getInstance("RC4");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            Log.e("RC4 Init Error", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return Base64.getEncoder()
                .encodeToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String decrypt(String encryptedText) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, cipher.getParameters());
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }

    private static String hashedData() throws NoSuchAlgorithmException {
        String password = SECRET_KEY;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
