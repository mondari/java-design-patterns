package com.mondari.adapter;

/**
 * ObjectAdapter
 *
 * 适配器角色：把要适配的接口转换成目标接口
 * 对象适配器：实现目标接口，内部持有待适配对象的引用
 */
public class ObjectAdapter implements Target{

    private Adaptee adaptee;

    ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void targetMethod() {
        adaptee.adapteeMethod();
    }
}
