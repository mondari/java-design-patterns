package com.mondari;

import com.mondari.dynamic.jdk.MyInvocationHandler;
import com.mondari.statik.ProxyObject;

import java.lang.reflect.Proxy;

/**
 * 代理模式（静态代理、动态代理）
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 目标对象
        TargetObject targetObject = new TargetObject();

        // 静态代理对象
        ProxyObject staticProxyObject = new ProxyObject(targetObject);
        // 执行代理对象的动作其实就是执行目标对象的动作，并且在目标对象的基础上做增强，不做修改
        staticProxyObject.action();

        // JDK动态代理对象
        Target jdkDynamicProxyObject = (Target) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{Target.class}, new MyInvocationHandler(targetObject));
        jdkDynamicProxyObject.action();
    }
}
