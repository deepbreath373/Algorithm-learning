/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 */
public class 删除链表的节点 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode cur = head;
        while (cur.next.val != val) {
            cur = cur.next;
        }
        ListNode delNode = cur.next;
        cur.next = delNode.next;
        delNode = null;
        return head;
    }

    //删除重复节点
    public ListNode deleteRepeat(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            boolean needDel = false;
            if (nextNode != null && nextNode.val == curNode.val) {
                needDel = true;
            }
            if (!needDel) {
                preNode = curNode;
                curNode = curNode.next;
            } else {
                int val = curNode.val;
                ListNode delNode = curNode;
                while (delNode != null && delNode.val == val){
                    nextNode = delNode.next;
                    delNode = null;
                    delNode = nextNode;
                }
                if(preNode == null){
                    head = nextNode;
                }else{
                    preNode.next = nextNode;
                }
                curNode = nextNode;
            }
        }
        return head;
    }
}
