/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * @author infearOnTheWay
 */
public class InsertionSortListSolution {
    public ListNode insertionSortList(ListNode head) {
        ListNode vHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = null;
            ListNode idx = vHead;
            while (idx.next != null && idx.next.val <= cur.val) {
                idx = idx.next;
            }
            cur.next = idx.next;
            idx.next = cur;
            cur = tmp;
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
