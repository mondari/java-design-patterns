package com.mondari;

/**
 * 目标类
 */
public class TargetObject implements Target {

    @Override
    public void action() {
        System.out.println("这是目标类");
    }
}
