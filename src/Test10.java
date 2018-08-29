import java.util.ArrayList;
class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
        next = null;
    }
}

public class Test10 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 0; i < 4; i++)
        {

            ListNode tmp = new ListNode(i+2);
            cur.next = tmp;
            cur = tmp;
        }
        cur = remove(head,2);

        for(;cur != null;)
        {
            System.out.println(cur.val);
            cur = cur.next;
        }


    }
    public static ListNode remove(ListNode head, int n)
    {
        if(head == null) {
            return null;
        }
        ListNode p = head, q = head;
        for(int i = 0; i < n; i++)
        {
            q = q.next;
        }
        while(q.next != null)
        {
            p = p.next;
            q = q.next;
        }
        ListNode tmp = p.next.next;
        p.next = tmp;
        return head;
    }

}