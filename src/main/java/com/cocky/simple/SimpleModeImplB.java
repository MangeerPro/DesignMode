/**
 *
 */
package com.cocky.simple;

import java.io.Serializable;

/**
 * @author haohao
 */
public class SimpleModeImplB implements SimpleApi, Serializable {

    private static final long serialVersionUID = 2L;

    /* (non-Javadoc)
     * @see com.cocky.simple.SimpleInterface#get()
     */
    public String get(String str) {
        // TODO Auto-generated method stub
        return "Hello SimpleModeImplB : " + str;
    }

}
