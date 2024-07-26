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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode myNode=new ListNode(7);
        myNode.next=head;
        ListNode p1=myNode; //p stands for pointer
        while(head!=null && head.next!=null){
            if(head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val) head=head.next;
                p1.next=head.next;
            }else{
                p1=p1.next;
            }
            head=head.next;
        }
        return myNode.next;
    }
}