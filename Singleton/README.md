# 单例模式

## 亦称

Singleton

## 作用

单例模式是一种创建型设计模式， 它能够保证一个类只有一个实例， 并提供一个访问该实例的全局节点。

单例模式的写法有很多种，分别适用不同的场景。

- 饿汉模式
- 懒汉模式
- 双重检查锁
- 静态内部类
- 枚举
- 容器|上下文

## 源码中的例子

- [java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime()) ：饿汉模式
- [java.awt.Desktop#getDesktop()](http://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html#getDesktop) ：懒汉模式+容器
- [java.lang.System#getSecurityManager()](http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getSecurityManager)

## 参考

- https://refactoringguru.cn/design-patterns/singleton
- [设计模式（二）单例模式的七种写法 - 刘望舒](http://blog.csdn.net/itachi85/article/details/50510124)
- 《Android 源码设计模式解析与实战》何红辉 关爱民 著