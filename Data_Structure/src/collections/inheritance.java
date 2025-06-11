package collections;


	class Vehicle
	{
	    private int id;
	    private int weight;// members will be inside the class
	    public String model;  // RULE OF ENCAPSULATION - 
	    // ALL VARIABLE MEMBERS OF A CLASS DECLARED WITH private KEYWORD
	    Vehicle()
	    {
	    System.out.println("inside Vehicle constructor");
	    }
	    Vehicle(int id, int weight, String mod)
	    {
	        this.id=id; this.weight=weight; this.model=mod;
	    }
	    private void show()
	    {
	       
	    System.out.println("id = "+id);
	    System.out.println("weight =  "+weight);
	    }
	    public void display()
	    {
	        System.out.println("id ="+id);
	        System.out.println("weight= "+weight);
	        System.out.println("model = " + model);
	    }
	    public void display2()
	    {
	    System.out.println("super version display method from super class");
	    }
	    
	    
	}
	class Car extends Vehicle
	{
	    
	// extends keyword copies all the MEMBERS from parent, super, base- Vehicle
	// inside the child, sub, derived Car class - but not the private MEMBERS
	    // combine 2 classes together, but not private member from Vehile class
	    // display(), model, are also in Car class
	    // in inheritance always the super class constructor is executed first.
	    //
	    String owner;
	    String name;
	    Car()
	    {
	        System.out.println("from car empty constructor....");
	    }
	    Car(String owner, String name)
	    {
	        this.owner=owner; this.name=name;
	        System.out.println("from car 2 args constructor....");
	    }
	    // create the sub class constructor wtih total number arguments of bothe super and subclass
	    Car(int a, int b, String m, String o, String n)
	    {
	        super(a,b,m);// super will invoke the superclass parametrized constructor.
	        this.owner=o; this.name=n;
	        //super(a,b,m); // error message is call to super must be first statement in constructor.
	    }

	    public void carShow()
	    {
	        System.out.println(owner+",  "+name);
	    }
	    public void display2()
	    {
	        System.out.println("sub class version opf display method from sub class");
	        super.display2();
	    }
	}
	public class inheritance {

		public static void main(String[] args) {
			System.out.println("inheritance in java.");
			
			Car ob=new Car();
			ob.display();
			ob.carShow();
			Car cb=new Car("Ajay", " BMW");
			
			Car all = new Car(10, 500, "BMW-007", "Ajay", "BMW - S class");
			all.carShow();
			all.display();
			all.display2();
			//all.show();
			//int is=all.id; // id has private access in Vehicle can not b e used outside its own class
			
		}
	}

