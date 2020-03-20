package testswordoffer;

import com.algorithm.swordoffer.impl.Duplicate;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/20 16:32
 */
public class TestDuplicate {
    @Test
    public void testFindDuplicate(){
        int arr[] = {6,3,5,3,5,2,1,5,3};
        System.out.println(Duplicate.findDuplicate(arr));
        System.out.println(Duplicate.findDuplicate2(arr));
    }
}
