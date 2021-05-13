/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class 合并两个排序的链表 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    //迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return head.next;
    }

    //递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode mergeHead = null;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next,l2);
        }else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1,l2.next);
        }
        return mergeHead;
    }
}
