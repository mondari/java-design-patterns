# 单例模式有几种写法？(中海达)(名通科技)

[TOC]

常见的有饿汉模式和懒汉模式，其中懒汉模式有线程安全和线程不安全两种写法

- 懒汉模式的单例是在用户第一次调用时完成初始化，所以感觉很懒
- 饿汉模式的单例是在类加载时就完成了初始化，所以感觉很饿

## 参考

[设计模式（二）单例模式的七种写法](http://blog.csdn.net/itachi85/article/details/50510124)

## 懒汉模式

懒汉模式的单例是在用户第一次调用时完成初始化

线程不安全的写法

```java
class SingleTon {
    //类变量，并隐藏
    private static SingleTon instance;
    //隐藏构造方法
    private SingleTon(){

    }
	//类方法
    public static SingleTon getInstance() {
      	//注意是instance == null，别写错！
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }
}
```

线程安全的写法

```java
class SingleTon {
    //类变量，并隐藏
    private static SingleTon instance;
    //隐藏构造方法
    private SingleTon(){

    }
	//类方法，比非线程安全多了 synchronized 关键字
    public static synchronized SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }
}
```

## 饿汉模式

饿汉模式的单例是在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快，同时也避免了线程同步的问题

```java
class SingleTon {
    //类变量，并隐藏
    private static SingleTon instance = new SingleTon();
    //隐藏构造方法
    private SingleTon(){

    }

    public static SingleTon getInstance() {
        return instance;
    }
}
```



