package com.cocky.mfactory;

public class ConcreteCreator extends Creator {
    @Override
    protected Product factoryMethod() {
        //重新定义工厂方法，返回一个具体的Product对象
        return new ConcreteProduct();
    }
}
