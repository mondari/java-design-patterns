package com.mondari.singleton;

/**
 * 静态内部类单例
 *
 * 双重检查锁（DCL）升级版，解决双重检查锁某些情况失效的问题
 */
class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    /**
     * 私有静态内部类
     */
    private static class SingletonHolder{
        private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    /**
     * 第一次获取单例时，会导致虚拟机加载内部类 SingletonHolder，从而使 instance 被初始化。
     * @return
     */
    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
