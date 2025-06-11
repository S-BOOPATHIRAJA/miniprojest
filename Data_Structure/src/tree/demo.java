package tree;

import java.util.Scanner;

public class demo {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int a = 40;
		BinarySearch bst= new BinarySearch(a);
		bst.insert(20);
		bst.insert(50);
		bst.insert(45);
		bst.insert(60);
		bst.insert(5);
		bst.inOrder5(bst.root);
		if(bst.search(bst.root,500)==null)
		{
			System.out.println("Not found");
		}
		else
		System.out.println("Found");
		
		System.out.println();
		bst.root=bst.delete(bst.root,60);
		bst.inOrder5(bst.root);
		
	}
	
}
class BinarySearch
{
	TreeNode1 root;
	class TreeNode1
	{
		TreeNode1 left,right;
		int key;
		TreeNode1(int data)
		{
			key=data;
			left=right=null;
		}
	}
	BinarySearch(int data)
	{
		root=new TreeNode1(data);
	}
	public TreeNode1 delete(TreeNode1 root, int val)
	{
		if(root==null)
		{
			return root;
		}
		if(val<root.key)
		{
			root.left=delete(root.left,val);
		}
		else if(val>root.key)
		{
			root.right=delete(root.right,val);
		}
		else
		{
			if(root.left==null)
			{
				return root.right;
			}
			if(root.right==null)
			{
				return root.left;
			}
			else
			{
				 root.key=solve(root.right);
				 root.right=delete(root.right,root.key);
			}
		}
		return root;
	}
	public int solve(TreeNode1 root)
	{
		int min=root.key;
		while(root!=null)
		{
			min=root.key;
			root=root.left;
		}
		return min;
	}
	public void insert(int val)
	{
		insert(root,val);
	}
	public TreeNode1 search(TreeNode1 groot,int val)
	{
		if(groot==null||groot.key==val)
		{
			return groot;
		}
	
		if(groot.key>val)
		{
			return search(groot.left,val);
		}
		return search(groot.right,val);
	}
	public TreeNode1 insert(TreeNode1 groot,int val)
	{
		if(groot==null)
		{
			return new TreeNode1(val);
			
		}
		
		if(groot.key>val)
		{
			groot.left=insert(groot.left,val);
		}
		else
		{
			groot.right=insert(groot.right,val);
		}
		return groot;
		
		 
		
	}
	public void inOrder5(TreeNode1 root)
	{
		if(root!=null)
		{
			inOrder5(root.left);
			System.out.print(root.key+" ");
			inOrder5(root.right);
		}
	}
}
