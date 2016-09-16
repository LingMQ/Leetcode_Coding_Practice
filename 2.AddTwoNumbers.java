/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**
  * Case 1: L1, L2 both null or either null
  * Case 2: node dierct add
  * Case 3: more than 9, increment the one before by 1
  */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;

        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        int adder = 0;
        ListNode returnList = null;
        ListNode returnListPointer = null;

        while(l1 != null && l2 != null){
        	int currentSum = l1.val + l2.val + adder;
        	ListNode currentSumDigit = new ListNode(currentSum % 10);
        	if(returnList == null){
        		returnList = currentSumDigit;
        		returnListPointer = currentSumDigit;
        	}else{
        		returnListPointer.next = currentSumDigit;
        		returnListPointer = returnListPointer.next;
        	}

        	if(currentSum > 9)
        		adder = 1;
        	else
        		adder = 0;
        	
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        while(l1 != null){
            returnListPointer.next = new ListNode((l1.val + adder)%10);
            returnListPointer = returnListPointer.next;
            if(l1.val + adder > 9)
        		adder = 1;
        	else
        		adder = 0;
            l1 = l1.next;
        }
    
        while(l2 != null){
            returnListPointer.next = new ListNode((l2.val + adder)%10);
            returnListPointer = returnListPointer.next;
            if(l2.val + adder > 9)
        		adder = 1;
        	else
        		adder = 0;
            l2 = l2.next;
        }
        
        if(adder != 0){
            returnListPointer.next = new ListNode(1);
        }
        return returnList;
    }
}