package com.mondari.dynamic.jdk;

import com.mondari.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理 - 需要实现 InvocationHandler接口
 */
public class MyInvocationHandler implements InvocationHandler {

    Target target;

    public MyInvocationHandler(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==== before jdk dynamic proxy ====");
        target.action();
        System.out.println("==== after jdk dynamic proxy  ====");
        return null;
    }
}
