package datapack;

public class Singly_Linked_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head = new Node(1);
		head.next=new Node(2);  //head.next==head2
		//head.next=new Node(22);
		head.next.next=new Node(3); //head.next.next=head3
		head.next.next.next=new Node(4);
		
		System.out.println("Original Linked List");
		
		
		//head=insertAtFront(head, 0);
		//head=insertAtEnd(head, 112);
		 head =insertAtPos(head, 4,9);
		
	
		Linked_list lst= new Linked_list();
		lst.printList(head);
		System.out.println("-------------------------------------");
		
		//Find position
		int key=3;
		 System.out.println("User Input Key is: "+key);
		 if(searchKey(head,key))
		 {
			 System.out.println("YES");
			 int pos = findPos(head,key);
			 System.out.println("Present at the position: "+pos);
		 }
		 else
		 {
			 System.out.println("NO");
		 }
		 System.out.println("-------------------------------------");
		
		//Insert after the particular data
		 int key1=3;
		 if(searchKey(head,key1))
		 {
			
			 int pos = findPos(head,key1);
			
			 head = insertAtPos(head, pos+1, 99);
			 System.out.println("Modified Linked List");
			 lst.printList(head);
		 }
		 else
		 {
			 System.out.println("NO Data Found");
		 }
		 System.out.println("-------------------------------------");
		 //Deleting node
		 System.out.println("After deltetion:");
		 int position=4;
		 head=deleteNode(head, position);
		 lst.printList(head);
		 System.out.println("Deleted at position of "+position);
		 
		 System.out.println("-------------------------------------");
		 System.out.println("After Reversing the list");
		 head=reverseList(head);
		 lst.printList(head);
		 
		
	}
	public static Node reverseList(Node head)
	{
		Node temp=head;
		Node prev= null;
		Node front;
		while(temp!=null)
		{
			front=temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		return prev;
	}
	public static Node deleteNode(Node head, int pos)
	{
		Node temp=head;
		Node prev=null;
		
		//Base case if linked list is empty
		if(temp==null)
		{
			return head;
		}
		//case 1: Head is to be deleted
		if(pos==1)
		{
			head=temp.next;
			return head;
		}
		//case 2: Node to be deleted is in middle
		// Traverse till given position
		for(int i=1;temp!=null&&i<pos;i++)
		{
			prev=temp;
			temp=temp.next;
		}
		//if given position is found , delete nod
		if(temp!=null)
		{
			prev.next=temp.next;
		}
		else
		{
			System.out.println("Position not found");
		}
		return head;
	}
	public static int findPos(Node head, int key)
	{
		 Node curr= head;
	      int count=0;
	      while(curr!=null)
	      {
	    	  count++;
	    	  if(curr.data==key)
	    	  {
	    		return count;
	    		 
	    	  }
	    	  curr=curr.next;
	    	  
	      }
	      return 0;
	     
	}
	public static boolean searchKey(Node head, int key)
	{
	      Node curr= head;
	      int count=0;
	      while(curr!=null)
	      {
	    	  if(curr.data==key)
	    	  {
	    		
	    		  return true;
	    	  }
	    	  curr=curr.next;
	    	  count++;
	      }
	      return false;
	}
	public static Node insertAtFront(Node head, int fresh_data)
	{
		//Create a new node with the given data
		Node fresh_node= new Node(fresh_data);
		
		//Make the next of the new node point to the
		//current head
		fresh_node.next=head;
		
		//Return the new node as the new head of the list
		return fresh_node;
	}
	
	// Function that appends a new node at he end of SLL and returns
	public static Node insertAtEnd(Node head,int newdata)
	{
		Node newNode= new Node(newdata);
		
		//If the linked list is empty, make the new node as the head and return
		if(head==null)
		{
			return newNode;
		}
		
		//Store the head reference in a temporary variable
		Node last=head;
		//Traverse till the last node
		while(last.next!=null)
		{
			last=last.next;
		}
		
		//Change the next pointer of the last node to point to the new node
		
		last.next= newNode;
		return head;
	}
	public static Node insertAtPos(Node head, int pos,int data)
	{
         
		Node  freshnode= new Node(data);
		
		if(pos==1)
		{
			freshnode.next=head;
			head= freshnode;
			return head;
		}
		Node current=head;
        
		for(int i=1;i<pos-1&&current!=null;++i)
		{
			current=current.next;
		}
		
		if(current == null)
		{
			System.out.println("Position is out of bounds");
			return head;
		}
		freshnode.next=current.next;
		current.next= freshnode;
		
		
          return head;
		
		
		//Return the new node as the new head of the list
	
	}
	

}
class Node
{
	int data;// instance variable
	Node next;// this the reference obj that stores the memory address
	//next is called the instance obj reference of same class
	
	Node(int a)
	{
		this.data=a;
		this.next=null;
	}
}
 class Linked_list
{
	public void printList(Node head)
	{
		//iteration OR traversal means going through one by one
		int c=0;
		Node current=head;
		while(current!=null)
		{
			System.out.print(" "+current.data);
			current=current.next;
			c++;
		}
		System.out.println();
		System.out.println("Total Elements in the SLL: "+c);
	}
}
