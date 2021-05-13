/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class 反转链表 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    //迭代
    public ListNode reverseList(ListNode head){
        ListNode reverseHead = null;
        ListNode prevNode = null;
        ListNode curNode = head;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            if(nextNode == null){
                reverseHead = curNode;
            }
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return reverseHead;
    }
    //递归
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
