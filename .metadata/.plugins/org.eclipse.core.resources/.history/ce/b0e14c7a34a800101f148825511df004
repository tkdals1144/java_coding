package Studying;
import java.util.*;
import java.io.*;

class CircleDeque {
	private Deque<Integer> deque;
	private int capacity;
	private int front;
	private int rear;
	
	public CircleDeque(int capacity) {
		this.capacity = capacity;
		deque = new ArrayDeque<>(capacity);
		front = 0;
		rear = 0;
	}
	// [ front, ... , rear ]
	
	// front insert
	public boolean insertFront(int value) {
		if (isFull()) return false;
		deque.offerFirst(value);
		front = (front - 1 + capacity) % capacity;
		return true;
	}
	
	// back insert
	public boolean insertLast(int value) {
		if (isFull()) return false;
		deque.offerLast(value);
		rear = (rear + 1) % capacity;
		return true;
	}
	
	// front poll
	public int deleteFront() {
		if (isEmpty()) return -1;
		front = (front + 1) % capacity;
		return deque.pollFirst();
	}
	
	// back poll
	public int deleteLast() {
		if (isEmpty()) return -1;
		rear = (rear - 1 + capacity) % capacity;
		return deque.pollLast();
	}
	
	public boolean isEmpty() {
		return deque.isEmpty();
	}
	
	public boolean isFull() {
		return deque.size() == capacity;
	}
}

public class B2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
	}
}
