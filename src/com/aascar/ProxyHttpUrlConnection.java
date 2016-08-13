package com.aascar;

import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Araja Jyothi Babu on 10-Aug-16.
 */
public class ProxyHttpUrlConnection implements InvocationHandler {

    private Object obj;
    private PrintStream printer = System.out;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new ProxyHttpUrlConnection(obj));
    }

    private ProxyHttpUrlConnection(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result;
        try {
            printer.print("before method " + m.getName());
            long start = System.nanoTime();
            result = m.invoke(obj, args);
            long end = System.nanoTime();
            printer.print(String.format("%s took %d ns", m.getName(), (end-start)) );
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {
            printer.print("after method " + m.getName());
        }
        return result;
    }

}
