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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr=head;
        ListNode last=head;
        int size=this.count(head);
        
        if(head==null||head.next==null||k==0) {
            return head;
        }
        k=k%size;
        while(k>0) {
        
            while(curr.next!=null) {
            last=curr;
            curr=curr.next;
            }

            last.next=null;
            curr.next=head;
            head=curr;

            k--;

        }
        return head;
    }
    public int count(ListNode head) {
        ListNode dummyHead=head;
        int count=0;
        while(dummyHead!=null) {
            dummyHead=dummyHead.next;
            count++;
        }
        return count;
    }
}