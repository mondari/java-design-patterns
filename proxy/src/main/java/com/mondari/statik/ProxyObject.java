package com.mondari.statik;

import com.mondari.Target;

/**
 * 代理类
 */
public class ProxyObject implements Target {

    /**
     * 持有目标对象的引用
     */
    Target target;

    /**
     * 通过构造函数注入目标对象
     *
     * @param target
     */
    public ProxyObject(Target target) {
        this.target = target;
    }

    @Override
    public void action() {
        System.out.println("==== before static proxy ====");
        // 执行目标对象动作
        target.action();
        System.out.println("==== after static proxy  ====");
    }
}
