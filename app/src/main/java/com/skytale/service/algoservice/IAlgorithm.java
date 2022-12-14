package com.skytale.service.algoservice;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface IAlgorithm {
    String encrypt(String plainText) throws Exception;
    String decrypt(String encryptedText) throws Exception;
}
