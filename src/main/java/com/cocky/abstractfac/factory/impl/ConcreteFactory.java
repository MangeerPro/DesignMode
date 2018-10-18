package com.cocky.abstractfac.factory.impl;

public class ConcreteFactory implements AbstractFactory {
    
    public AbstractProductA createProductA() {
        return new ProductA();
    }

    public AbstractProductB createProductB() {
        return new ProductB();
    }
    
}
