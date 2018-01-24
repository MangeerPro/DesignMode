/**
 *
 */
package com.cocky.simple;

import java.io.Serializable;

/**
 * @author haohao
 */
public class SimpleModeImplA implements SimpleApi, Serializable {

    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see com.cocky.simple.SimpleInterface#get()
     */
    public String get(String str) {
        // TODO Auto-generated method stub
        return "Hello SimpleModeImpleA :" + str;
    }
}
