public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder){
        return verifyPostorder2(postorder,0,postorder.length-1);
    }
    public boolean verifyPostorder2(int[] postorder,int l, int r){
        if(l>=r){
            return true;
        }
        int root = postorder[r];

        int i = l;
        while(postorder[i] < root){
            i++;
        }

        int j = i;
        while(j<r){
            if(postorder[j++]<root){
                return false;
            }
        }
        return verifyPostorder2(postorder,l,i-1) && verifyPostorder2(postorder,i,r-1);
    }
    public boolean verifyPostorder3(int[] postorder,int l, int r){
        if(l>=r){
            return true;
        }
        int root = postorder[r];
        int len = r - l + 1;
        int i = l;
        for(;i<len;i++){
            if(postorder[i]>root){
                break;
            }
        }
        int j = i;
        for(;j<len;j++){
            if(postorder[j]<root){
                return false;
            }
        }
        return verifyPostorder2(postorder,l,i-1) && verifyPostorder2(postorder,i,r-1);
    }
}
