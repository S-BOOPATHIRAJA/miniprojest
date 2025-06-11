package datapack;
import java.util.*;
public class Doubly_linkedlist_using_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of players");
		int num=sc.nextInt();
	
		Node2 head= null;
		int i;
		String name;
		int score;
		System.out.println("Enter "+num+" Players and their Scores:");
		
		for(i=0;i<num;i++)
		{
			name=sc.next();
			score=sc.nextInt();
			
			head=insert2(head,name,score);
			//dllPrintList2(head);
		}
		System.out.println("------------------------------");
		dllPrintList2(head);
		

	}
	public static Node2 insert2(Node2 head,String name,int score)
	{
		Node2 freshnode=new Node2(name,score);
		freshnode.next=head;
		freshnode.prev=null;
		
		if(head!=null)
		{
			head.prev=freshnode;
			
		}
		head=freshnode;
		return head;
		
	}
	public static void dllPrintList2(Node2 head)
	{
		//iteration OR traversal means going through one by one
		int c=0;
		Node2 current=head;
		while(current!=null)
		{
			System.out.println(" Name: "+current.name+"  Score: "+current.score);
			current=current.next;
			c++;
		}
		System.out.println();
		System.out.println("Total Elements in the SLL: "+c);
	}
}
	
	class Node2
	{
		String name;
		int score;
		Node2 next;
		Node2 prev;
		Node2(String name,int score)
		{
			this.name=name;
			this.score=score;
			this.next=null;
			this.prev=null;
		}
		public Node2() {
			//3super();
			// TODO Auto-generated constructor stub
		}
		
		
	}


