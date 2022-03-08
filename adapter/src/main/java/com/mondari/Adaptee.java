package com.mondari;

/**
 * 被适配的接口：需要将其适配成目标接口，否则客户端无法使用该接口
 */
public interface Adaptee {

    void adapteeMethod();
}