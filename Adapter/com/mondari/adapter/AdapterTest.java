package com.mondari.adapter;

/**
 * AdapterTest
 */
public class AdapterTest {

    public static void main(String[] args) {
        // 对象适配器
        ObjectAdapter objectAdapter = new ObjectAdapter(new Adaptee());
        objectAdapter.targetMethod();
        
        // 类适配器
        ClassAdapter classAdapter = new ClassAdapter();
        classAdapter.targetMethod();
    }
}