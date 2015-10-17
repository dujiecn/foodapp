package org.dj.javatest.thread;

import org.junit.Test;

public class Main {
	@Test
	public void testProducerConsumer() {
		Store s = new Store();
		Producer producer = new Producer(s);
		Consumer consumner = new Consumer(s);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumner);
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
		Store s = new Store();
		Producer producer = new Producer(s);
		Consumer consumner = new Consumer(s);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumner);
		t1.start();
		t2.start();
	}
}
