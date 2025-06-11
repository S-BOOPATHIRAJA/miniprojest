package N_aryTree;
import java.util.*;
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m=sc.nextInt();
		int q=sc.nextInt();
		sc.nextLine();
		List <String> nodes = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			nodes.add(sc.next());
		}
		Node1 root=new Node1(nodes.get(0),null);
		
	}

}
class Node1
{
	String id;
	Node1 parent;
	List<Node1> childrens;
	int ancestorlockedcount,decendantlockedcount,lockedbyuser;
	boolean islocked;
	Node1(String id, Node1 parent)
	{
		this.id=id;
		this.parent=parent;
		this.ancestorlockedcount=0;
		this.decendantlockedcount=0;
		this.lockedbyuser=0;
		this.childrens=new ArrayList<>();
		this.islocked=false;
		
	}
	
}
