/**
 *
 */
package com.cocky.serialize;

import java.io.Serializable;

/**
 * @author haohao
 */
public class Serialize implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
