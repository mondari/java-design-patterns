package com.mondari.singleton;

/**
 * 双重检查锁（DCL）
 *
 * 懒汉单例升级版，解决同步锁开销过大的问题
 */
class DoubleCheckLockingSingleton {

    /**
     * 类变量，必须添加 volatile 关键字
     *
     * volatile 除了保证变量的可见性，更重要的是禁止指令重排序（针对 instance = new DoubleCheckLockingSingleton() 这行代码）
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
    public static DoubleCheckLockingSingleton getInstance() {
    	// 第一次检查是否为空
        if (instance == null) {
            // 初始化的时候加锁，防止其它线程也在初始化
            synchronized (DoubleCheckLockingSingleton.class) {
                // 第二次检查是否为空，是否已经被其它线程初始化
                if (instance == null) {
                    /**
                     * new DoubleCheckLockingSingleton() 在 JVM 中的操作有3步：
                     * 1. 给 DoubleCheckLockingSingleton 类的实例 instance 分配内存
                     * 2. 调用构造函数初始化成员变量
                     * 3. 将 instance 指向分配的内存地址（此时 instance 就不为 null）
                     *
                     * 在指令重排的情况下，上述步骤可能变为 132 而不是 123，前者在第二步时会获得一个不为 null 的实例，
                     * 但该实例还没进行步骤 2 的操作，成员变量还没初始化，其内部状态时不可用的，就会导致异常发生。
                     * 为了避免该情况，所以单例 instance 使用 volatile 修饰。
                     */
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }
}
