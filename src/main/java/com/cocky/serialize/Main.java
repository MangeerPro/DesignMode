package com.cocky.serialize;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            Serialize serialize = new Serialize();
            serialize.setName("number1");
            out.writeObject(serialize);
            out.flush();
            System.out.println(new File("result.obj").length());
            serialize.setName("number2");
            out.writeObject(serialize);
            out.close();
            System.out.println(new File("result.obj").length());


            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("result.obj"));
            Serialize serialize1 = (Serialize) in.readObject();
            Serialize serialize2 = (Serialize) in.readObject();
            in.close();
            System.out.println(serialize1.getName() + "| " + serialize2.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
