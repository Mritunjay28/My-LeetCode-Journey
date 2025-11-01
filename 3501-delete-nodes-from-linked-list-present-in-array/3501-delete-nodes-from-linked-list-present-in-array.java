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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) if(!set.contains(nums[i])) set.add(nums[i]); 

        ListNode prev=null , curr=head , dummyhead=null;
        while(curr!=null){
            while(curr!= null && set.contains(curr.val)){
                curr=curr.next;
            }
            if(curr==null) {
                prev.next=null;
                break;
            }
            else if(prev==null){
                prev=curr;
                dummyhead=prev;
                curr=curr.next;
            }
            else{
                prev.next =curr;
                prev=curr;
                curr=curr.next;
            }
        }
        return dummyhead;
    }
}