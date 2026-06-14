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
    public int pairSum(ListNode head) {
        int max=-1;
        int n=0;
        ListNode dummy = head;
        while(dummy!=null){
            n++;
            dummy=dummy.next;
        }

        int[] value = new int[n/2];
        dummy = head;
        for(int i=0;i<=(n/2)-1;i++){
            value[i] = dummy.val;
            dummy=dummy.next;
        }
        
        for(int i=(n/2)-1;i>=0;i--){
            value[i] += dummy.val;
            dummy=dummy.next;
            max=Math.max(max,value[i]);
            
        }

        return max;
    }
}