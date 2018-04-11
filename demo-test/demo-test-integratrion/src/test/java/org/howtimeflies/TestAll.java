package org.howtimeflies;

import org.howtimeflies.api.HelloAPI;
import org.howtimeflies.spi.ByeSPI;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:ujjboy@qq.com">GengZhang</a>
 */
public class TestAll extends TestCommon {
    
    @Test
    public void test() {
        HelloAPI api = new HelloAPI();
        Assert.assertNotNull(api.sayHello("111"));
        Assert.assertNotNull(api.sayHello("222", 2));

        TestCommon common = new TestCommon();
        Assert.assertEquals(common, common.setAuthor("111"));
        
        ByeSPI spi = new ByeSPI();
        Assert.assertNotNull(spi.sayBye("111"));
    }
}
