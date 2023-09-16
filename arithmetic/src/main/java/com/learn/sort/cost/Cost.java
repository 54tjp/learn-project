package com.learn.sort.cost;

/**
 * 在 JDK1.7 引入了一个新的接口AutoCloseable, 通常它的实现类配合try{}使用，可在 IO 流的使用上，可自行关闭流，不用再去手动关闭流，使用起来更简洁优雅。
 *
 * 主要原因就是在try(){}执行完毕之后，会调用方法AutoCloseable#close方法；只要实现了AutoCloseable接口，都可使用try(){}语法。
 * 接下来利用这一特性，实现代码执行耗时的计算。
 * 创建Cost类实现AutoCloseable：
 *
 * @Description: 计算方法耗时
 * @Author: tjp
 * @Date: 2023/9/16 22:53
 */
public class Cost implements AutoCloseable {
    private final long start;

    public Cost() {
        start = System.currentTimeMillis();
    }

    @Override
    public void close() {
        System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
    }
}