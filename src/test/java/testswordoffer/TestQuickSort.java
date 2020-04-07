package testswordoffer;

import com.algorithm.swordoffer.impl.QuickSort;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/31 15:55
 */
public class TestQuickSort {

    @Test
    public void testQuickSort()throws Exception{
        int arr[] = {49,38,65,97,25,742,7,842,9,4,22,-1,54};
        QuickSort.quickSort(arr,0,arr.length-1);

        System.out.println("排序后");
        for (int i:arr){
            System.out.println(i);
        }
    }
}
