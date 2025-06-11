package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Create_BinTree_inJava {

	public static void main(String[] args) {
		
	
	TreeNode root= new TreeNode(2);
	
	//   2
	
	root.left=new TreeNode(8);
	root.right=new TreeNode(4);
	//      2
	//     / \
	//    8   4
	
	TreeNode Leftroot=root.left;
	TreeNode Rightroot= root.right;
	
	Leftroot.left=new TreeNode(3);
	Leftroot.right= new TreeNode(7);
	
	//                 2
	//                /  \
  //                 8    4
	//              / \
	//             3   7

    List<Integer> result = inorderTraversal(root);
    
    // Print the result
    System.out.println(inorderTraversal(root));
    
    System.out.println(result);
    
    for (int val : result) {
        System.out.print(val + " ");
    }
    System.out.println();
 
    System.out.print(Leftroot.left.val+" ");
    System.out.print(Leftroot.val+" ");
    System.out.print(Leftroot.right.val+" ");
    System.out.print(root.val+" ");
    System.out.print(root.right.val+"");
    
    System.out.println();
    System.out.println("PreOrder:");
    preOrderTraversal(root);
    System.out.println("\n InOrder: ");
    inOrder(root);
    System.out.println("\n PostOrderTraversal");
    postOrderTraversal(root);
	}
	
	
	public static List<Integer> inorderTraversal(TreeNode root)
	{
		List <Integer> list= new ArrayList();
		Stack <TreeNode> stc= new Stack<TreeNode>();
		TreeNode temp=root;

		//                 2
		//                /  \
	  //                 8    4
		//              / \
		//             3   7
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
	public static void preOrderTraversal(TreeNode root)
	{
		if(root==null)
			return;
		System.out.print(root.val+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	public static void inOrder(TreeNode root)
	{
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}
	public static void postOrderTraversal(TreeNode root)
	{
		if(root==null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.val+" ");
	}
}
class TreeNode
{
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	TreeNode(int d)
	{
		val=d;
		left=null;
		right=null;
	}
}
