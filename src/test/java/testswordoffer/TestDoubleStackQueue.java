package testswordoffer;

import com.algorithm.swordoffer.impl.DoubleStackQueue;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/24 16:47
 */
public class TestDoubleStackQueue {
    @Test
    public void TestDoubleStackQueue() throws Exception{
        DoubleStackQueue t = new DoubleStackQueue();
        t.push(1);
        t.push(2);
        t.push(3);

        System.out.println(t.pop());

    }
}
