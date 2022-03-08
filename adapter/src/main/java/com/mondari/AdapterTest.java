package com.mondari;

public class AdapterTest {

    public static void main(String[] args) {
        // 对象适配器
        ObjectAdapter objectAdapter = new ObjectAdapter(() -> System.out.println("adaptee method"));
        new Client(objectAdapter).execute();

        // 类适配器
        ClassAdapter classAdapter = new ClassAdapter();
        new Client(classAdapter).execute();
    }
}