import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class 分行从上到下打印二叉树 {
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
        int nextLevel = 0;
        int curLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            levelList.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                ++nextLevel;
            }
            if(node.right != null){
                queue.add(node.right);
                ++nextLevel;
            }
            --curLevel;
            if(curLevel == 0) {
                finalList.add(levelList);
                curLevel = nextLevel;
                nextLevel = 0;
                levelList = new ArrayList<>();
            }
        }
        return finalList;
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.remove();
                levelList.add(node.val);
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
