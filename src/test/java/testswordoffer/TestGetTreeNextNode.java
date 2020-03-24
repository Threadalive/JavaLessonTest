package testswordoffer;

import com.algorithm.swordoffer.impl.BinaryTreeSearch;
import com.algorithm.swordoffer.impl.GetTreeNextNode;
import com.algorithm.swordoffer.impl.TreeNode;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/24 16:28
 */
public class TestGetTreeNextNode {
    @Test
    public void testGetTreeNextNode(){
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};

        TreeNode treeNode = BinaryTreeSearch.reConstructBinaryTree(pre,mid).getRight().getRight();
        System.out.println(treeNode.getVal());

        System.out.println(GetTreeNextNode.getNextNode(treeNode));
    }
}
