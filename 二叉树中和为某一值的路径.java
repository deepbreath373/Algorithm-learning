import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树中和为某一值的路径 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<Integer> path = new Stack<>();
        int curSum = 0;
        findPath(root,target,path,curSum);
        return res;
    }

    private void findPath(TreeNode root, int target, Stack<Integer> path, int curSum) {
        curSum += root.val;
        path.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf && curSum == target){
            /*while(!path.isEmpty()){
                pathList.add(path.pop());
            }*/
            for (Integer num : path) {
                pathList.add(num);
            }
            res.add(pathList);
            pathList = new ArrayList<>();
        }
        if(root.left != null){
            findPath(root.left,target,path,curSum);
        }
        if(root.right != null){
            findPath(root.right,target,path,curSum);
        }
        if(!path.isEmpty()){
            path.pop();
        }
    }
}
