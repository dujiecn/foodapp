package org.dj.javatest;

public class ThreadTest implements Runnable{
	
	private boolean flag;
	private Object o1 = new Object();
	private Object o2 = new Object();
	
	@Override
	public void run() {
		if(flag) {
			synchronized(o1) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (o2) {
					
				}
			}
		}
		
		if(!flag) {
			synchronized(o2) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (o1) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable tt = new ThreadTest();
		Thread t1 = new Thread(tt);
		Thread t2 = new Thread(tt);
		t1.start();
		t2.start();
	}
	
}
