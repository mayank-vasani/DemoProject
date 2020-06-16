package demotest;

import java.io.FileNotFoundException;

public class JavaDemo {
	static String name = "Mayank";

	static void showName() {
		System.out.println("Name: " + name);
	}

	void check() {
		try {
			int a = 0;
			int b = 10;
			System.out.println("Arithmatic error:" + a / b);
		}
//		catch(FileNotFoundException fn){
//			System.out.println("FIle not found: " +fn);
//		}
		catch (ArithmeticException ae) {
			System.out.println("Arithmatic Exception");
		} finally {
			System.out.println("Finally done...");
		}
	}

	public static void main(String[] args) {
		JavaDemo obj1 = new JavaDemo();
		JavaDemo.showName();
		obj1.check();
	}
}
