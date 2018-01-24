/**
 * 敏感字段序列化问题
 */
package com.cocky.serialize;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.util.Base64;

/**
 * @author haohao
 */
public class EncryptionSerializ implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String passwd;

    @SuppressWarnings("restriction")

    /**
     * Custom ObjectOutputStream Class defaultWriteObject Method.
     * @param out
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    private void writeObject(ObjectOutputStream out) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        try {
            PutField putFields = out.putFields();
            passwd = Base64.getEncoder().encodeToString(EncryptDES.getEncrypt().encryptor(passwd));
            putFields.put("passwd", passwd);
            out.writeFields();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


    /**
     * Custom ObjectOutputStream Class defaultReadObject Method.
     *
     * @param in
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    @SuppressWarnings("null")
    private void readObject(ObjectInputStream in) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        try {
            GetField readFields = in.readFields();
            Object obj = readFields.get("passwd", "");
            passwd = (String) obj;
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
