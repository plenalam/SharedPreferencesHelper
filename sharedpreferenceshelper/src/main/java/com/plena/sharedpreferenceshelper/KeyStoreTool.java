package com.plena.sharedpreferenceshelper;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Copyright © 1997 - 2018 Plena. All Rights Reserved.
 * Created by Plena on 2018/6/11.
 * Describe：
 */
public class KeyStoreTool {
    private static final String DEFAULTKEY = "abc@123#efgh4567";

    // 加密
    public static String Encrypt(String sSrc) throws Exception {
        return Encrypt(sSrc, DEFAULTKEY);
    }

    // 加密
    public static String Encrypt(String sSrc, String mKey) throws Exception {
        if (mKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (mKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = mKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return Base64.encodeToString(encrypted, Base64.DEFAULT);
    }

    // 解密
    public static String Decrypt(String sSrc) throws Exception {
        return Decrypt(sSrc, DEFAULTKEY);
    }

    // 解密
    public static String Decrypt(String sSrc, String mKey) throws Exception {
        try {
            // 判断Key是否正确
            if (mKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (mKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = mKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = Base64.decode(sSrc, Base64.DEFAULT);// 先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
