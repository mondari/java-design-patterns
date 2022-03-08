# 装饰器模式

## 亦称

Decorator、Wrapper、包装器模式

## 作用

装饰器模式是一种结构型设计模式， 它允许将对象放入包装对象中来为原对象增加新的行为。

## 源码中的例子

- [java.io.InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html)
  、 [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html)
  、 [Reader](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html)
  和 [Writer](https://docs.oracle.com/javase/8/docs/api/java/io/Writer.html)

- java.util.Collections； checkedXXX()、 synchronizedXXX() 和 unmodifiableXXX() 方法。

- [javax.servlet.http.HttpServletRequestWrapper](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServletRequestWrapper.html)
  和 [HttpServletResponseWrapper](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServletResponseWrapper.html)

## 与其它模式的关系

- 装饰器模式和代理模式有着相同的结构，两者之间的不同之处在于代理模式通常自行管理其服务对象的生命周期， 而装饰模式则是由客户端进行控制。

## 参考

- https://refactoringguru.cn/design-patterns/adapter