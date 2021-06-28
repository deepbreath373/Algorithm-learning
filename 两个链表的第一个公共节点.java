import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * 1->2->3\
 *        6->7
 *   4->5/
 * <p>
 * 在节点 6 开始相交。
 */
public class 两个链表的第一个公共节点 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //双栈
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            stack1.add(curA);
            curA = curA.next;
        }
        while (curB != null) {
            stack2.add(curB);
            curB = curB.next;
        }
        ListNode ans = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            ans = stack1.pop();
            stack2.pop();
        }
        return ans;
    }

    //双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        int lenA = getLenth(headA);
        int lenB = getLenth(headB);
        int ab = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        if (lenA > lenB){
            ab = lenA - lenB;
            while (ab != 0){
                curA = curA.next;
                ab--;
            }
        } else {
            ab = lenB - lenA;
            while (ab != 0){
                curB = curB.next;
                ab--;
            }
        }
        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    private int getLenth(ListNode headA) {
        int len = 0;
        ListNode cur = headA;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int count = 0;
        if(curA==null||curB==null){
            return null;
        }
            while (curA != curB){
                if(count > 3){
                    curA = null;
                    break;
                }
                if(curA.next != null){
                    curA = curA.next;
                }else{
                    curA = headB;
                    count++;
                }
                if(curB.next != null){
                    curB = curB.next;
                }else{
                    curB = headA;
                    count++;
                }
            }

        return curA;
    }
}
