package com.cocky.serialize;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;

/**
 * @author haohao
 */
public class EncryptDES {

    private static final EncryptDES encrypt = new EncryptDES();
    // KeyGenerator 对称加密密钥生成器
    private static KeyGenerator keygen;
    //SecretKey 负责保存对称密钥
    private static SecretKey deskey;
    //Cipher 负责完成加密或解密
    private static Cipher c;
    //该字节数组负责保存加密结果
    private byte[] cipherByte;

    /**
     * 无参构造函数
     */
    @SuppressWarnings("restriction")
    private EncryptDES() {

    }

    /**
     * @return
     */
    public static EncryptDES getEncrypt() {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        try {
            keygen = KeyGenerator.getInstance("DES");
            deskey = keygen.generateKey();
            c = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return encrypt;
    }

    /**
     * 二进制转换为十六进制
     *
     * @param by
     * @return
     */
    public static String byte2hex(byte[] by) {
        String hs = "";
        String stmp;

        for (int i = 0; i < by.length; i++) {
            stmp = (Integer.toHexString(by[i] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs += stmp;
            }
        }

        return hs.toUpperCase();
    }

    /**
     * 十六进制转换为2进制
     *
     * @param by
     * @return
     */
    public static byte[] hex2byte(byte[] by) {
        if (by.length % 2 == 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] by2 = new byte[by.length / 2];
        for (int i = 0; i < by.length; i += 2) {
            String item = new String(by, i, 2);
            by2[i / 2] = (byte) Integer.parseInt(item, 16);
        }
        return by2;
    }

    /**
     * DES加密函数
     *
     * @param passwd
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] encryptor(String passwd) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        //根据密钥，对Cipher初始化，ENCRYPT_MODE表示加密模式
        c.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] src = passwd.getBytes();
        //加密过程
        cipherByte = c.doFinal(src);
        return Base64.getEncoder().encode(cipherByte);
    }

    /**
     * 解密函数
     *
     * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] decryptor(byte[] buff) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        //根据密钥，对Cipher初始化，DECRYPT_MODE表示解密模式
        c.init(Cipher.DECRYPT_MODE, deskey);
        cipherByte = c.doFinal(Base64.getDecoder().decode(buff));
        return cipherByte;
    }

}
