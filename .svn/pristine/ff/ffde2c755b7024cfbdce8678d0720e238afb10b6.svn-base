package NiuKe.sward_to_offer.tree;

/**
 * Created by wth on 2017/5/27.
 */
public class Merge {
    //Ñ­»·°æ±¾
    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = new ListNode(0);
        ListNode dump = head;
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                dump.next = list2;
                dump = dump.next;
                list2 = list2.next;
            }else {
                dump.next = list1;
                dump = dump.next;
                list1 = list1.next;
            }
        }
        if(list1 == null) dump.next = list2;
        if(list2 == null) dump.next = list1;
        return head.next;
    }
    //µİ¹é°æ±¾
    public ListNode merge2(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val > list2.val) {
            list2.next = merge2(list1,list2.next);
            return list2;
        }else {
            list1.next = merge2(list1.next,list2);
            return list1;
        }
    }
}
