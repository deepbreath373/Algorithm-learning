import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 */
public class 二叉搜索树的第k大节点 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return list.get(list.size() - k);
    }

    private void midOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            midOrder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            midOrder(root.right, list);
        }
    }

    int ans = 0, count = 0;

    public int kthLargest2(TreeNode root, int k) {
        count = k;
        midOrder2(root);
        return ans;
    }

    private void midOrder2(TreeNode root) {
        if (root.right != null && count > 0) {
            midOrder2(root.right);
        }
        count--;
        if (count == 0) {
            ans = root.val;
            return;
        }
        if (root.left != null && count > 0) {
            midOrder2(root.left);
        }
    }
}
