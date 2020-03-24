package testswordoffer;

import com.algorithm.swordoffer.impl.BinaryTreeSearch;
import com.algorithm.swordoffer.impl.TreeNode;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/24 15:51
 */
public class TestreConstructBinaryTree {
    int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
    int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};

    @Test
    public void testreConstructBinaryTree() {
        TreeNode root = BinaryTreeSearch.reConstructBinaryTree(pre, mid);
        printTree(root);
    }
    public void printTree(TreeNode root){
        if (root != null) {
            System.out.println(root.getVal());
            printTree(root.getLeft());
            printTree(root.getRight());
        }
    }

}
