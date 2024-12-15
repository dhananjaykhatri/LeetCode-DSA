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
        // Min-heap to store the smallest elements from each list
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

         // Dummy node to build the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the heap
        while (!minHeap.isEmpty()) {
            // Extract the smallest node from the heap
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // If there is a next node in the list, add it to the heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }
}