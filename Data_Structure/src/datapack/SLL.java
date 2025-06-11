package datapack;
import java.util.*;
public class SLL {

	public static void main(String[] args) {
		
		ListNode head= new ListNode(2);
		head.next=new ListNode(4);
		head.next.next=new ListNode(6);
		
		printSqr(head);
		head=sqrList(head);
		printList(head);
	}
	public static void printList(ListNode head)
	{
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

	public static void printSqr(ListNode head)
	{
		ListNode temp=head;
		while(temp!=null)
		{
			System.out.printf("% .0f \n",Math.pow(temp.val, 2));
			temp=temp.next;
		}
	}
	public static ListNode sqrList(ListNode head)
	{
		ListNode temp=head;
		ListNode tt=null;
		ListNode t;
		while(temp!=null)
		{
			int vale=(int) Math.pow(temp.val, 2);
			 t=new ListNode(vale);
			tt=t;
			temp=temp.next;
			t=t.next;
			break;
		}
		while(temp!=null)
		{
			int vale=(int) Math.pow(temp.val, 2);
			 t=new ListNode(vale);
			
			temp=temp.next;
			t=t.next;
		}
		return tt;
	}
}
 class ListNode
 {
	 int val;
	 ListNode next;
	 ListNode(int val)
	 {
		 this.val=val;
	 }
 }
