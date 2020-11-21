/**
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author infearOnTheWay
 */
public class SortListSolution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode other = slow.next;
        slow.next = null;
        ListNode first = sortList(head), second = sortList(other);
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode vHead = new ListNode(-1), cur = vHead, idx1 = first, idx2 = second;
        while (idx1 != null || idx2 != null) {
            long val1 = idx1 == null ? Long.MAX_VALUE : idx1.val;
            long val2 = idx2 == null ? Long.MAX_VALUE : idx2.val;
            if (val1 < val2) {
                cur.next = idx1;
                idx1 = idx1.next;
            } else {
                cur.next = idx2;
                idx2 = idx2.next;
            }
            cur = cur.next;
        }
        return vHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
