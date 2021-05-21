import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class 之字形打印二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.remove();
                if(finalList.size() % 2 == 0){
                    //finalList中已存在偶数个List，说明当前是第奇数层
                    levelList.addLast(node.val);
                }else{
                    //finalList中已存在奇数个List，说明当前是第偶数层
                    levelList.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            finalList.add(levelList);
        }
        return finalList;
    }
}
