package demotest;

public class Test1 {
	
	void parent(String st){
		System.out.println("Parent: "+ st);
	}
	public class Test2 extends Test1{
		void parent(Object ob){
			System.out.println("Child: "+ob);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 objTest1= new Test1();
		objTest1.parent("Mayank");
//		Test1 objTest2= new Test2();
//		objTest2.parent(10);
		

	}

}
