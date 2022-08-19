package com.faw.hongqi.util;

import android.os.Build;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA256Util {

    private static final String MAC_NAME = "HmacSHA256";
    private static final String ENCODING = "UTF-8";

    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString();
    }

    /**
     * sha256_HMAC加密
     *
     * @param encryptText 被签名的字符串
     * @param encryptKey  密钥
     * @return 加密后字符串
     */
    public static String HmacSHA256(String encryptText, String encryptKey) throws Exception {
        String hash = "";
        Mac mac = Mac.getInstance(MAC_NAME);
        SecretKeySpec secret_key = new SecretKeySpec(encryptKey.getBytes(), MAC_NAME);
        mac.init(secret_key);
        byte[] bytes = mac.doFinal(encryptText.getBytes());
        hash = byteArrayToHexString(bytes);
        return hash;
    }

    /**
     * 使用 HMAC-SHA256 签名方法对encryptText进行签名
     *
     * @param encryptText 被签名的字符串
     * @param encryptKey  密钥
     * @return
     * @throws Exception
     */
    public static byte[] HmacSHA256Encrypt(String encryptText, String encryptKey) throws Exception {
        byte[] data = encryptKey.getBytes(ENCODING);
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        // 生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        // 完成 Mac 操作
        return mac.doFinal(text);
    }

}