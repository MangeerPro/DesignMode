/**
 *
 */
package com.cocky.simple;

/**
 * @author haohao
 */
public class SimpleFactory {
    public static final SimpleApi getSimpleMedo(Integer condition) {
        SimpleApi simpleApi = null;
        if (condition == 1) {
            simpleApi = new SimpleModeImplA();
        }
        return new SimpleModeImplA();
    }
}
