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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMiddle(head);

        ListNode firstHalf = head;
        ListNode secondHalf = mid.next;
        mid.next = null;

        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);

        head = merge(firstHalf, secondHalf);

        return head;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null){
            temp.next = l1;
        }
        else{
            temp.next = l2;
        }
        return dummy.next;
    }

    public ListNode getMiddle(ListNode head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Slow and fast pointer technique
        ListNode slow = head;
        ListNode fast = head.next;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow pointer is now at the middle of the list
        return slow;
    }
}