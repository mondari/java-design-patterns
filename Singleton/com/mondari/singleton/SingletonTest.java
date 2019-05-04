package com.mondari.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingletonAnother = EagerSingleton.getInstance();

        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingletonAnother = LazySingleton.getInstance();

        DoubleCheckLockingSingleton doubleCheckLockingSingleton = DoubleCheckLockingSingleton.getInstance();
        DoubleCheckLockingSingleton doubleCheckLockingSingletonAnother = DoubleCheckLockingSingleton.getInstance();

        StaticInnerClassSingleton innerClassSingleton = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton innerClassSingletonAnother = StaticInnerClassSingleton.getInstance();

        System.out.println(eagerSingleton == eagerSingletonAnother);
        System.out.println(lazySingleton == lazySingletonAnother);
        System.out.println(doubleCheckLockingSingleton == doubleCheckLockingSingletonAnother);
        System.out.println(innerClassSingleton == innerClassSingletonAnother);
    }
}
