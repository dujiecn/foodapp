package org.dj.javatest.thread;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("1:" + Thread.currentThread().getName());
				}
			}
		};
		
		thread.start();

		while (true) {
			Thread.sleep(500);
			System.out.println("main:" + Thread.currentThread().getName());
		}

	}
}
