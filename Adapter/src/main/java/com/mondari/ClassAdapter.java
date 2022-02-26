package com.mondari;

/**
 * 类适配器：实现目标接口，继承或实现待适配的类或接口
 */
public class ClassAdapter implements Adaptee, Target {

    @Override
    public void targetMethod() {
        this.adapteeMethod();
    }

    @Override
    public void adapteeMethod() {
        System.out.println("adaptee method");
    }
}