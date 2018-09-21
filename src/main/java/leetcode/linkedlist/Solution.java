package leetcode.linkedlist;

import java.util.List;

/**
 * Created by wth on 2016/12/1.
 */
public class Solution {
    /**
     * 19. Remove Nth Node From End of List
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(1);
        ListNode slow = start, fast = start;
        slow.next = head;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }


    /**
     * 21. Merge Two Sorted Lists
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode merge;
        if (l1.val >= l2.val) {
            merge = l2;
            merge.next = mergeTwoLists(l1, l2.next);
        } else {
            merge = l1;
            merge.next = mergeTwoLists(l1.next, l2);
        }
        return merge;
    }


    /**
     * 24. Swap Nodes in Pairs
     */
    public ListNode swapPairs(ListNode head) {
        ListNode temp;
        if (head == null || head.next == null) {
            return head;
        } else {
            temp = head;
            head = head.next;
            head.next = temp;
            head.next.next = swapPairs(head.next.next);
        }
        return head;
    }


    /**
     * 83. Remove Duplicates from Sorted List
     */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }

    /**
     * 141. Linked List Cycle
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null) {
            if (p2 == p1) {
                return true;
            } else {
                p2 = p2.next.next;
                p1 = p1.next;
            }
        }
        return false;
    }


    /**
     * 160. Intersection of Two Linked Lists
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null)  return null;
//        ListNode p = headB;
//        while(headA!=null)
//        {
//            while(headB!= null)
//            {
//                if(headA == headB)  return headA;
//                else headB = headB.next;
//            }
//            headA = headA.next;
//            headB = p;
//        }
//        return null;
//    }    时间超时；
        ListNode a = headA, b = headB;
        if (headA == null || headB == null) {
            return null;
        }
        while (headA != headB) {
            if (headA.next != null) {
                headA = headA.next;
            } else {
                headA.next = b;
            }
            if (headB.next != null) {
                headB = headB.next;
            } else {
                headB.next = a;
            }
        }
        return headA;
    }


    public static boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode p = head;
        ListNode copy = new ListNode(head.val);
        ListNode dummy = copy;
        while(head.next != null)
        {
            copy.next = new ListNode(head.next.val);
            head = head.next;
            copy = copy.next;
        }
        ListNode newhead = null;
        while(p != null)
        {
            ListNode next = p.next;
            p.next = newhead;
            newhead = p;
            p = next;
        }
        while(copy != null)
        {
            if(copy.val != newhead.val) {
                return false;
            }
            copy = copy.next;
            newhead = newhead.next;
        }
        return true;
    }


    /**
     * 2. Add Two Numbers
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode p = new ListNode(0);
        ListNode dummy = p;
        int digit = 0;
        int sum = 0;
        while(l1 !=null || l2 != null)
        {
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode((sum+digit)%10);
            p = p.next;
            digit = (sum+digit)/10;
            sum = 0;
        }
        if(digit == 1) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }

        /**
         * 23. Merge k Sorted Lists
         * */
        public ListNode mergeKLists(ListNode[] lists) {
            int k = lists.length;
            ListNode head = new ListNode(0);
            ListNode dummy = head;
            int min =0,indexMin = 0;
            if(k == 0) {
                return null;
            }
            for(int i =0;i<k;i++)
            {
                if(lists[i] == null) {
                    lists[i] = new ListNode(Integer.MAX_VALUE);
                }
            }
            while(dummy.val != Integer.MAX_VALUE) {
                min = lists[0].val;
                for (int i = 0; i < k; i++) {
                    min = Math.min(min,lists[i].val);
                    indexMin = min>=lists[i].val?i:indexMin;
                }
                dummy.next = lists[indexMin];
                if(dummy.next.val == Integer.MAX_VALUE){
                    dummy.next = null;
                    return head.next;
                }
                dummy = dummy.next;
                lists[indexMin] = lists[indexMin].next;
                if(lists[indexMin] == null) {
                    lists[indexMin] = new ListNode(Integer.MAX_VALUE);
                }
            }

            return head.next;
        }

    /**
     *86. Partition List
     *
     * 非常值得思考的问题   容易造成链表循环
     * */
    public ListNode partition(ListNode head, int x) {
        ListNode pone = new ListNode(0);
        ListNode p1 = pone;
        ListNode psec = new ListNode(0);
        ListNode p2 = psec;
        if(head == null) {
            return null;
        }
        while(head != null)
        {
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else{
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        if(pone.next == null) {
            return psec.next;   //可以不要~
        }
        p2.next = null;
        p1.next = psec.next;
        return pone.next;
    }


    public static void main(String args[]){
        ListNode head =new ListNode(2);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
        ListNode [] lists = new ListNode[]{null,head};
       // System.out.println(isPalindrome(head));
        //System.out.println(new Solution().mergeKLists(lists).val);
        System.out.println(new Solution().partition(head,2).val);

    }

}