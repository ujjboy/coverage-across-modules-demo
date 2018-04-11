package org.howtimeflies.spi;

/**
 * @author <a href="mailto:ujjboy@qq.com">GengZhang</a>
 */
public class ByeSPI {
    public String sayBye(String name){
        System.out.println("bye from" + name);
        return "bye " + name;
    }
}
