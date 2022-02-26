package com.mondari;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class SingletonTest<T> {

    Supplier<T> singletonInstanceMethod;

    private SingletonTest(Supplier<T> singletonInstanceMethod) {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }

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

        // 多线程测试
        SingletonTest<EagerSingleton> eagerSingletonSingletonTest = new SingletonTest<>(EagerSingleton::getInstance);
        eagerSingletonSingletonTest.multiThreadTest();
        SingletonTest<LazySingleton> lazySingletonSingletonTest = new SingletonTest<>(LazySingleton::getInstance);
        lazySingletonSingletonTest.multiThreadTest();
        SingletonTest<DoubleCheckLockingSingleton> doubleCheckLockingSingletonSingletonTest = new SingletonTest<>(DoubleCheckLockingSingleton::getInstance);
        doubleCheckLockingSingletonSingletonTest.multiThreadTest();
        SingletonTest<StaticInnerClassSingleton> staticInnerClassSingletonSingletonTest = new SingletonTest<>(StaticInnerClassSingleton::getInstance);
        staticInnerClassSingletonSingletonTest.multiThreadTest();

    }

    private void multiThreadTest() {
        System.out.println("====多线程测试====");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        List<Callable<T>> callables = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            callables.add(this.singletonInstanceMethod::get);
        }
        try {
            List<Future<T>> futures = executor.invokeAll(callables);
            for (Future<T> future : futures) {
                if (future.get() != this.singletonInstanceMethod.get()) {
                    System.out.println("false: " + this.singletonInstanceMethod.getClass());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
