package collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
public class C1 {

	/******************************************************************************

    Online Java Compiler.
Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


	public static void main(String[] args) {
		System.out.println("ArrayList creations and management.");
		ArrayList<String> prod=new ArrayList<String>();
		System.out.println(prod.size());
		System.out.println(prod.isEmpty());
		prod.add("Pen");
		prod.add("Note");
		System.out.println(prod);
		prod.add(0,"Pencil");
		//prod.addFirst("Eraser");// can not find symbol
		
		prod.add("pencil");
		System.out.println(prod);
		if(prod.contains("note"))
		{
		    System.out.println("yes");
		}
		else
		{
		    System.out.println("no");
		}
		prod.set(3,"Scale"); // is used to change or update the existing value
		System.out.println(prod);
		if(prod.contains("Note"))
		{
		    prod.remove("Note");
		}
			System.out.println(prod);
			
			prod.add("Rubber");
			prod.add("laptop");
			System.out.println(prod);
			
			
			// iterator interface is used to traverse or go thru th collection object one by one
		Iterator itr =prod.iterator();  // collection object converts to Iterator object
		while(itr.hasNext())
		{
		    System.out.println(itr.next());
		}
		//prod.clear();
		int id=prod.indexOf("Rubber");
		prod.add("Phone");
		prod.add("tv");
		prod.add("laptop");
		int ld=prod.lastIndexOf("laptop");
		
		System.out.println(id);
		System.out.println(ld);
		
			System.out.println(prod);
		System.out.println("before sorting..");  // sorting collection items
		Collections.sort(prod);
		System.out.println("after sorting..");
		System.out.println(prod);
		Collections.reverse(prod);
		System.out.println(prod);



	}
}

