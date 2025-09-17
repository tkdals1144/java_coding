package baekjoon;

public class Problem03 {
	public static void main(String[] args) {
		A b = new B(1);
		b.paint();
		b.draw();
	}
}

class A {
	public A() {
		System.out.println("생성자 of A");
	}
	
	public A(int i) {
		System.out.println("생성자 of AA" + i);
	}
	
	public void paint() {
		System.out.print("A");
		draw();
	}
	
	public void draw() {
		System.out.print("B");
		draw();
	}
}

class B extends A {

	public B() {
		super.paint();
	}
	
	public B(int i) {
		System.out.println("생성자 of BB" + i);
	}
	
	public void paint() {
		System.out.print("C");
	}

	public void draw() {
		System.out.print("D");
	}
	
}
