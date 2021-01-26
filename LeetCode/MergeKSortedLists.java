/**
https://leetcode.com/problems/merge-k-sorted-lists/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }
    
    private ListNode partition(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        if (low < high) {
            int mid = low + (high - low)/2;
            ListNode l1 = partition(lists, low, mid);
            ListNode l2 = partition(lists, mid + 1, high);
            return mergeTwoLists(l1, l2);
        }
        return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if (l1 != null) {
            ptr.next = l1;
        }
        if (l2 != null) {
            ptr.next = l2;
        }
        ptr = head;
        head = head.next;
        ptr.next = null;
        return head;
    }
}