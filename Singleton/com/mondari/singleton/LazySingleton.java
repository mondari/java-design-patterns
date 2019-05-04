package com.mondari.singleton;

/**
 * 懒汉
 *
 * 获取单例时才初始化，一定程度上降低了资源消耗，但是第一次获取单例时速度稍慢，
 * 且每次获取单例都要同步，开销较大，不建议使用
 */
class LazySingleton {

    /**
     * 类变量
     */
    private static LazySingleton instance;

    /**
     * 私有化构造方法防止被别人调用
     */
    private LazySingleton() {

    }

    /**
     * 静态方法获取单例，synchronized 保证线程安全，
     * 但是每次获取单例都要同步，造成不必要的性能开销，所以不建议用这种模式
     *
     * @see DoubleCheckLockingSingleton
     * @see StaticInnerClassSingleton
     * @return
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
