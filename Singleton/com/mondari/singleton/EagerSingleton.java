package com.mondari.singleton;

/**
 * 饿汉
 *
 * 类加载时初始化，所以类加载较慢，但获取单例的速度快，同时也避免了线程同步的问题
 */
class EagerSingleton {

    /**
     * 类加载时就初始化实例，从而保证线程安全
     */
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * 私有化构造方法防止被别人调用
     */
    private EagerSingleton() {
    }

    /**
     * 静态方法获取单例
     *
     * @return
     */
    public static EagerSingleton getInstance() {
        return EagerSingleton.instance;
    }
}
