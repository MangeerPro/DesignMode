/**
 * 静态变量反序列化时，不保存静态变量的值
 */
package com.cocky.serialize;

import java.io.*;

/**
 * @author haohao
 */
public class TestSerializ implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static int staticVar = 5;

    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            //初始化staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(new TestSerializ());
            out.close();

            //序列化后修改为10
            TestSerializ.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(
                    new FileInputStream("result.obj"));
            TestSerializ t = (TestSerializ) oin.readObject();
            oin.close();

            System.out.println(staticVar);
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
