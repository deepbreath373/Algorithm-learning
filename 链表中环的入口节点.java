/**
 * 题目：
 * 如果一个链表中包含环，如何找出环的入口节点？
 * 例如，有一个链表为：
 * 1->2->3->4->5 5->3
 *
 * 则入口节点为 3
 */
public class 链表中环的入口节点 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    ListNode MeetingNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
        }
        return null;
    }

    ListNode EntryNodeOfLoop(ListNode head) {
        ListNode meetingNode = MeetingNode(head);
        if (meetingNode == null) {
            return null;
        }
        int nodeInLoop = 1;
        ListNode cur = meetingNode;
        while (cur.next != meetingNode) {
            nodeInLoop++;
            cur = cur.next;
        }
        ListNode one = head;
        ListNode two = head;
        for (int i = 0; i < nodeInLoop; i++) {
            one = one.next;
        }
        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
