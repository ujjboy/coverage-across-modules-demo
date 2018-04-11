package org.howtimeflies.api;

/**
 * @author <a href="mailto:ujjboy@qq.com">GengZhang</a>
 */
public class HelloAPI {
    
    public String sayHello(String name){
        System.out.println("hello from" + name);
        return "hello " + name;
    }

    public String sayHello(String name, int age){
        System.out.println("hello from" + name + ", age" + age);
        return "hello " + name;
    }
}
