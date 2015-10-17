package org.dj.javatest.thread;

public class Consumer implements Runnable{
	private Store store;
	public Consumer(Store store) {
		this.store = store;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(new Double(Math.random() * 999 + 1).intValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("consume:" + store.get());
		}
	}
	
}
