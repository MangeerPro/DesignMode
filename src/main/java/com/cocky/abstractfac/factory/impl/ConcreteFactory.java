package com.cocky.abstractfac.factory.impl;

import com.cocky.abstarctfac.product.AbstractProductA;
import com.cocky.abstarctfac.product.AbstractProductB;
import com.cocky.abstractfac.factory.AbstractFactory;
import com.cocky.abstractfac.product.impl.ProductA;
import com.cocky.abstractfac.product.impl.ProductB;

public class ConcreteFactory implements AbstractFactory {
    
    public AbstractProductA createProductA() {
        return new ProductA();
    }

    public AbstractProductB createProductB() {
        return new ProductB();
    }
    
}
