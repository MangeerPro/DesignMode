/**
 *
 */
package com.cocky.serialize;

import java.io.*;

/**
 * @author haohao
 */
public class SonClaz extends ParentClaz implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private float income;
    private transient String preffsion;

    public SonClaz() {
        this.preffsion = "Programmer";
    }

    public static void main(String[] args) {
        try {

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            SonClaz son = new SonClaz();
            //son.setPreffsion("Teacher");
            System.out.println(son.getPreffsion());
            son.setIncome(100.00F);
            out.writeObject(son);
            out.close();

            ObjectInputStream oin = new ObjectInputStream(
                    new FileInputStream("result.obj"));
            son = (SonClaz) oin.readObject();
            oin.close();

            System.out.println(son.getName() + son.getAge() + son.getPreffsion() + son.getIncome());
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getPreffsion() {
        return preffsion;
    }

    public void setPreffsion(String preffsion) {
        this.preffsion = preffsion;
    }
}
