package Studying;

public class Study02 {
	public static void main(String[] args) {
//		Parent p = new Child();
//		p.display();
//		char c = 'a';
//		System.out.println((int)c);
//		System.out.println(true);
		int a = 0;
		if (a == 0) {
			System.out.println("a is null");
		} else {
			System.out.println("a is not null");
		}
	}
}

class Parent {
	static void display() {
		System.out.println("Parent static display");
	}
}

class Child extends Parent {
	static void display() {
		System.out.println("Child static display");
	}
}