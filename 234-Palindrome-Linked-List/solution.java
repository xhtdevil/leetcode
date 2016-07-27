/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private ListNode Reverse(ListNode head){
        
        Stack<Integer> stack = new Stack<Integer>();
        
        ListNode node = head;
        
        while(node != null){
            stack.push(node.val);
            node = node.next;
        }
        
        node = head;
        
        while(!stack.isEmpty()){
            node.val = stack.pop();
            node = node.next;
        }
        
        return head;
    }
    
    public boolean isPalindrome(ListNode head) {
        
        //find the middle point of the linklist
        if(head == null || head.next == null){return true;}
        
        ListNode p1 = head, p2 = head;
        
        while(p1.next != null && p1.next.next != null){
            p2 = p2.next;
            p1 = p1.next.next;
        }
        
        ListNode head2 = p2.next;
        
        //reverse half of the linklist
        head2 = Reverse(head2);
        
        ListNode node2 = head2, node1 = head;
        
        //compare two halves of the linklist
        while(node2 != null){
            if(node2.val != node1.val){return false;}
            node2 = node2.next;
            node1 = node1.next;
        }
        
        return true;
    //     if(head == null){return true;}
    //     ArrayList<Integer> a = new ArrayList<Integer>();
    //     ArrayList<Integer> aRev = new ArrayList<Integer>();
    //     Stack<Integer> stack = new Stack<Integer>();
    //     ListNode node = head;
    
    //     while(node != null){
    //         a.add(node.val);
    //         stack.push(node.val);
    //         node = node.next;
    //     }
    //     node = head;
    //     while(node != null){
    //         aRev.add(stack.pop());
    //         node = node.next;
    //     }
    //   // if(a.get(0) == aRev.get(0) && a.get(1) == aRev.get(1))return true;
       
    //     for(int i = 0; i < a.size(); i++){
    //         if(a.get(i) == aRev.get(i)){continue;}
    //         else return false;
    //     }//if(a.size() == 2 && aRev.size() == 2){return true;}
    //     return true;
    }
}