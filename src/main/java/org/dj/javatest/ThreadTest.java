package org.dj.javatest;

class ThreadTest {
	public static void main(String[] args) {
//		Integer a = 127;
//		Integer b = 127;
//		System.out.println(a == b);
		
		
		
		final Object o1 = new Object();
		final Object o2 = new Object();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName() + ",o2 suo.");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (o1) {
						System.out.println(Thread.currentThread().getName() + ",o1 suo.");
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName() + ",o1 suo.");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (o2) {
						System.out.println(Thread.currentThread().getName() + ",o2 suo.");
					}
				}
			}
		}).start();
		
		
		

	}
}
