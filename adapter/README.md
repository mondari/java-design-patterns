# 适配器模式

## 亦称

Adapter、Wrapper

## 作用

适配器模式是一种结构型设计模式， 它能使接口不兼容的对象正常工作。

## 现实中的例子

- 有的手机只支持Type-C接口的耳机，如果要使用3.5mm接口的耳机，需要一个3.5mm转Type-C的转接头，这个转接头就是适配器。
- 出过旅游，你会发现有些国家的插头是不一样的，有美标、英标、欧标、澳标插头，需要插头转换器才能使原来的国标插头正常使用

## 源码中的例子

- [java.io.InputStreamReader(InputStream)](https://docs.oracle.com/javase/8/docs/api/java/io/InputStreamReader.html#InputStreamReader-java.io.InputStream-)
  （返回 Reader对象）
- [java.io.OutputStreamWriter(OutputStream)](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStreamWriter.html#OutputStreamWriter-java.io.OutputStream-)
  （返回 Writer对象）

## 主要角色

| 角色    | 类型             | 说明                            |
| ------- | ---------------- |-------------------------------|
| Target  | interface        | 目标接口：客户端能正常使用的接口，非目标接口要适配才能使用 |
| Adaptee | interface或class | 被适配的接口：需要适配成目标接口，否则无法正常使用    |
| Adapter | class            | 适配器角色：把被适配的接口转换成目标接口          |

## 适配器模式分类

- 对象适配器：实现Target接口，内部持有Adaptee对象的引用
- 类适配器：实现Target接口，继承或实现Adaptee接口

## 参考

- https://refactoringguru.cn/design-patterns/adapter