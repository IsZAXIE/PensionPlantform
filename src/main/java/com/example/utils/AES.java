package com.example.utils;

import org.springframework.stereotype.Component;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AES {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final int KEY_SIZE = 16;

    private static String key = "1234567890123456";

    /**
     * plaintext msg like password...
     * return encryptedMsg
     */
    public static String encrypt(String plaintext) throws Exception {
        byte[] rawKey = getRawKey(key);
        SecretKeySpec keySpec = new SecretKeySpec(rawKey, ALGORITHM);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String ciphertext) throws Exception {
        byte[] rawKey = getRawKey(key);
        SecretKeySpec keySpec = new SecretKeySpec(rawKey, ALGORITHM);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    private static byte[] getRawKey(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] rawKey = new byte[KEY_SIZE];
        System.arraycopy(keyBytes, 0, rawKey, 0, Math.min(keyBytes.length, KEY_SIZE));
        return rawKey;
    }


}
