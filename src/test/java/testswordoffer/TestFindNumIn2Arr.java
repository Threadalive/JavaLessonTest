package testswordoffer;

import com.algorithm.swordoffer.impl.FindNumIn2Arr;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/20 17:04
 */
public class TestFindNumIn2Arr {
    @Test
    public void testFindNumIn2Arr(){
        int arr[][] = {{1,7,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(FindNumIn2Arr.findNum(arr,7));
        System.out.println(FindNumIn2Arr.findNum2(arr,7));

    }
}
