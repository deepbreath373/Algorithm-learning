public class 二叉搜索树与双向链表 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node pre, head;
    public Node treeToDoublyList(Node root){
        if(root==null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if(cur==null)return;
        dfs(cur.left);
        if(pre==null){
            head = cur;
        }else if(pre != null){
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
