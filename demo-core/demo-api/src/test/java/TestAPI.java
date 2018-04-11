import org.howtimeflies.api.HelloAPI;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:ujjboy@qq.com">GengZhang</a>
 */
public class TestAPI {
    
    @Test
    public void test() {
        HelloAPI api = new HelloAPI();
        Assert.assertNotNull(api.sayHello("111"));
    }
}
