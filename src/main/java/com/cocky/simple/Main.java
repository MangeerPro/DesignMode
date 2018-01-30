/**
 *
 */
package com.cocky.simple;


/**
 * @author haohao
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleApi si = SimpleFactory.getSimpleMedo(2);
        System.out.println(si.get("test"));
    }

}
