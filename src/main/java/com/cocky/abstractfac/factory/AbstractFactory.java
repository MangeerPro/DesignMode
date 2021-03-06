package com.cocky.abstractfac.factory;

import com.cocky.abstarctfac.product.AbstractProductA;
import com.cocky.abstarctfac.product.AbstractProductB;

/**
 * 抽象工厂接口、声明创建抽象产品对象的操作
 */
public interface AbstractFactory {
    /**
     * 实例方法，创建抽象产品A的对象
     * @return 抽象产品A的对象
     */
    public AbstractProductA createProductA();

    /**
     * 实例方法，创建抽象产品B的对象
     * @return 抽象产品B的对象
     */

     public AbstractProductB createProductB();

}