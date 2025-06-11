package datapack;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
public class Collections {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		List<Integer> lst= new LinkedList<Integer>();
		List lst2= new LinkedList();
		//List<Integer> lst3=new java.util.ArrayList<Integer>();
	
		lst2.add("akki");
		
		lst2.add(1);
		
		lst.add(4);
		lst.add(2);
		lst.add(1);
		lst.add(3);
		System.out.println(lst);
		System.out.println("After sorting");
		lst.sort(null);
		System.out.println(lst);
		System.out.println(lst2);
	
		int pos=lst2.indexOf(1);
		int pos2=lst2.indexOf("akki");
		System.out.println("Update name:----");
		lst2.set(pos2, "Jothika Mam");
		System.out.println(lst2);
		
		lst2.remove(pos);
		lst2.removeAll(lst2);
	     System.out.println(lst2.isEmpty());
	     System.out.println();
	     System.out.println("Using HashSet");
	     Set <Integer> hlst= new  HashSet<Integer>();
	     hlst.add(1);
	     hlst.add(2);
	     hlst.add(10);
	     hlst.add(4);
	     hlst.add(9);
	     hlst.add(8);
	     System.out.println(hlst.size());
	     System.out.println(hlst.contains(3));
	     System.out.println(hlst);
	     
	    hlst.removeAll(hlst);
	     System.out.println(hlst);
	     System.out.println("----------------------------------");
	     
	     TreeNode root = new TreeNode(1);
	        root.right = new TreeNode(2);
	        root.right.left = new TreeNode(3);
	        
	       
	        List<Integer> result = inorderTraversal(root);
	        
	        // Print the result
	        for (int val : result) {
	            System.out.print(val + " ");
	        }
	     
	     
	     
	     
	     
	    
		
	}
	public static List<Integer> inorderTraversal(TreeNode root)
	{
		List <Integer> list= new ArrayList();
		Stack <TreeNode> stc= new Stack<TreeNode>();
		TreeNode temp=root;
		while (temp!=null||!stc.empty())
		{
			while(temp!=null)
			{
				stc.push(temp);
				temp=temp.left;
			}
			 temp= stc.pop();
			 list.add(temp.val);
			 temp=temp.right;
			
		}
		
		return list;
	}
}
	class TreeNode
	{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x)
		{
			val=x;
			left=null;
			right=null;
			
		}
	}
	

