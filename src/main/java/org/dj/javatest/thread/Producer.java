package org.dj.javatest.thread;

public class Producer implements Runnable {
	private Store store;

	public Producer(Store store) {
		this.store = store;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				Thread.sleep(new Double(Math.random() * 999 + 1).intValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("produce:" + i);
			store.set(i++);
		}
	}
}
