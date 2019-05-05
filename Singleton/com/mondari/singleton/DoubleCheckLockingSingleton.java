package com.mondari.singleton;

/**
 * 双重检查锁（DCL）
 *
 * 懒汉单例升级版，解决开销过大的问题
 */
class DoubleCheckLockingSingleton {

    /**
     * 类变量，必须添加 volatile 关键字
     *
     * volatile 用于将变量标记为“储存于主内存中”，读取时从主内存中读取，写入时直接写入到主内存
     */
    private static volatile DoubleCheckLockingSingleton instance;

    /**
     * 私有化构造方法防止被别人调用
     */
    private DoubleCheckLockingSingleton() {

    }

    /**
     * 静态方法获取单例，synchronized 保证线程安全
     *
     * @return
     */
    public static synchronized DoubleCheckLockingSingleton getInstance() {
        if (instance == null) {
            // 初始化的时候加锁，防止其它线程也在初始化
            synchronized (DoubleCheckLockingSingleton.class) {
                // 再次检查instance是否已经被其它线程初始化
                if (instance == null) {
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }
}
