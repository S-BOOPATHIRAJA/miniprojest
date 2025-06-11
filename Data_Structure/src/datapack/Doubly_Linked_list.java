package datapack;
class Node1
{
	int data;
	Node1 next;
	Node1 prev;
	
	Node1(int data)
	{
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}


public class Doubly_Linked_list {

	public static void main(String[] args) {
		
		
		Node1 head= new Node1(1);
		Node1 head1= new Node1(2);
		Node1 head2= new Node1(3);
		Node1 tail= new Node1(4);
 
		head.next=head1;
		head1.prev=head;
		head1.next=head2;
		head2.prev=head1;
		head2.next=tail;
		tail.prev=head2;
		
		System.out.println("Traversal from head");
		
		dllTraversalFromHead(head);
		System.out.println();
		

		
		System.out.println("Traversal from tail");
		
		dllTraversalFromTail(tail);
		
		int length=dllCount(head);
		int pos=3;
      /* if(pos>1&&pos<length)
       {
    	   Node1 posbef=findFirstPos(head,pos-1);
    	   Node1 posaft=findSecPos(head,pos+1);
    	   Node1 insert= new Node1(99);
    	   posbef.next=insert;
    	   insert.prev=posbef;
    	   insert.next=posaft;
    	   posaft.prev=insert;
       }*/
		System.out.println();
		System.out.println("Insert at Begin");
		//head=insertBegin(head, 9);
		insert(head, 9);
		//dllPrintList(head);
		
		System.out.println();
		System.out.println("Insert at Last");
		head=dllinsertAtLast(head, 99);
		dllPrintList(head);
		
		
		
				
		

	}
	public static Node1 dllinsertAtLast(Node1 head,int data)
	{
		Node1 temp= new Node1(data);
		if(head==null)
		{
			return temp;
		}
		Node1 curr= head;
		while(curr.next!=null)
		{
			curr=curr.next;
		}
		curr.next=temp;
		temp.prev=curr;
		
		return head;
		
	}
	
	public static Node1 insertBegin(Node1 head, int data)
	{
		Node1 temp= new Node1(data);
		temp.next=head;
		if(head!=null)
		{
			head.prev=temp;
		}
		return temp;
	}
	public static void insert(Node1 head,int data)
	{
		Node1 freshnode=new Node1(data);
		freshnode.next=head;
		freshnode.prev=null;
		
		if(head!=null)
		{
			head.prev=freshnode;
			
		}
		head=freshnode;
		dllPrintList(head);
		
	}
	
	public static void dllTraversalFromHead(Node1 head)
	{
		Node1 curr=head;
		
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
	}
	public static void  dllTraversalFromTail(Node1 tail)
	{
		Node1 curr=tail;
		
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr=curr.prev;
		}
	}
	public static void dllPrintList(Node1 head)
	{
		//iteration OR traversal means going through one by one
		int c=0;
		Node1 current=head;
		while(current!=null)
		{
			System.out.print(" "+current.data);
			current=current.next;
			c++;
		}
		System.out.println();
		System.out.println("Total Elements in the SLL: "+c);
	}
	
	public static int dllCount(Node1 head)
	{
		int c=0;
		Node1 curr=head;
		while(curr!=null)
		{
			c++;
			curr=curr.next;
		}
		return c;
	}
	

}
