package N_aryTree;
import java.util.*;
class Tree
{
	private Node root;
	private Map <String , Node> nodemap;
	Tree(Node root)
	{
		this.root=root;
		nodemap=new HashMap<>();
		nodemap.put(root.id, root);
	}
	Node getnode()
	{
		return root;
	}
	void fillNodeMap(Node node)
	{
		if(node==null)
			return;
		nodemap.put(node.id, node);
		for(Node child:node.childrens)
		{
			fillNodeMap(child);
		}
	}
	boolean lock(String nodeid, int userid)
	{
		Node node=nodemap.get(nodeid);
		if(node.islocked||node.ancestorlockedcount>0||node.decendantlockedcount>0)
		{
			return false;
		}
		Node curr=node.parent;
		while(curr!=null)
		{
			curr.decendantlockedcount++;
			curr=curr.parent;
		}
		upgradedecendantlockcount(node,1);
		node.islocked=true;
		node.lockedby=userid;
		return true;
		
	}
	void upgradedecendantlockcount(Node node,int val)
	{
		for(Node child:node.childrens)
		{
			child.ancestorlockedcount+=val;
			upgradedecendantlockcount(child, val);
		}
	}
	boolean unlock(String nodeid,int userid)
	{
		Node node=nodemap.get(nodeid);
		if(!node.islocked||node.lockedby!=userid)
			return false;
		Node curr= node.parent;
		while(curr!=null)
		{
			curr.decendantlockedcount--;
			curr=curr.parent;
		}
		upgradedecendantlockcount(node, -1);
		node.islocked=false;
		//node.lockedby=0;
		return true;
	}
	boolean upgrade(String nodeid, int userid)
	{
		Node node=nodemap.get(nodeid);
		if(node.islocked||node.ancestorlockedcount>0||node.decendantlockedcount==0)
         return false;

         List <Node> lockeddecendents=new ArrayList<>();
         if(!verifydecendentslock(lockeddecendents,node,userid))
         {
        	 return false;
         }
         for(Node lckdes:lockeddecendents)
         {
        	 unlock(lckdes.id,userid);
         }
         lock(nodeid,userid);
         return true;
	}
	boolean verifydecendentslock(List <Node> lockeddecendents,Node node,int uid)
	{
		if(node.islocked)
		{
			if(node.lockedby!=uid)return false;
			lockeddecendents.add(node);
		}
		if(node.decendantlockedcount==0)return true;
		for(Node nod:node.childrens)
		{
			if(!verifydecendentslock(lockeddecendents, nod, uid))
			{
				return false;
			}
		}
		return true;
	}
}
public class Main
{ public static List <Boolean> rst=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q=sc.nextInt();
		sc.nextLine();
	//	String q=  "'3 India 1', '1 World 9'";
		List <String> nodes = new ArrayList<>();
		int i;
		for(i=0;i<n;i++)
		{
			nodes.add(sc.nextLine());
		}
		Node root = new Node(nodes.get(0),null);
		buildTree(root,m,nodes);
		Tree tree=new Tree(root);
		tree.fillNodeMap(tree.getnode());
		//String arr[]=q.split("'");
		
		for(i=0;i<q;i++)
			
		{
			/*String arr2[]=arr[i].split(" ");
			int op=Integer.parseInt(arr2[0]);
			String nodeid=arr2[1];
			int userid=Integer.parseInt(arr2[2]);*/
			int op=sc.nextInt();
			String nodeid=sc.next();
			int userid=sc.nextInt();
			sc. nextLine();
			boolean result =false;
			switch(op)
			{
			case 1:
				rst.add( tree.lock(nodeid,userid));
				break;
			case 2:
				rst.add( tree.unlock(nodeid,userid));
				break;
			case 3:
				rst.add( tree.upgrade(nodeid,userid));
				break;
			}
					
		}
		System.out.println(rst);
		
	}
	public static void buildTree(Node root,int m,List <String>nodes)
	{
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int start=1;
		while(!q.isEmpty())
		
		{
			Node curr=q.poll();
			if(start>=nodes.size())continue;
			
			List <String> childid=new ArrayList<>();
			for(int i=start;i<start+m&&i<nodes.size();i++)
			{
				childid.add(nodes.get(i));
			}
			curr.addchild(childid,curr);
			start=start+m;
			q.addAll(curr.childrens);
			
		}
	}
}
class Node
{
	String id;
	Node parent;
	int ancestorlockedcount,decendantlockedcount,lockedby;
	boolean islocked;
	List<Node>childrens;
	Node(String id,Node parent)
	{
		this.id=id;
		this.parent=parent;
		this.ancestorlockedcount=0;
		this.decendantlockedcount=0;
		this.lockedby=0;
		this.islocked=false;
		this.childrens=new ArrayList<>();
	}
	void addchild(List<String> childid,Node parent)
	{
		for(String cid:childid)
		{
			Node child= new Node(cid,parent);
			childrens.add(child);
			//nodemap.put(cid, child);
		}
	}
	
}