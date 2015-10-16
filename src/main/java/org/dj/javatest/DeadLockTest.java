package org.dj.javatest;

/**
 * 
 * 项目名称：foodapp   
 * 类描述：死锁
 * 类名称：org.dj.javatest.DeadLockTest     
 * 创建人：dujie 
 * 创建时间：2015年10月15日 上午9:31:46
 * @version   V1.0
 */
public class DeadLockTest implements Runnable {
	private int flag;
	private static Object o1 = new Object(), o2 = new Object();

	@Override
	public void run() {
		System.err.println(flag);
		if (flag == 0) {
			synchronized (o1) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {

				}
			}
		}

		if (flag == 1) {
			synchronized (o2) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {

				}
			}
		}
	}

	public static void main(String[] args) {
		DeadLockTest test1 = new DeadLockTest();
		DeadLockTest test2 = new DeadLockTest();
		test1.flag = 1;
		test2.flag = 0;
		Thread thread1 = new Thread(test1);
		Thread thread2 = new Thread(test2);
		thread1.start();
		thread2.start();
	}

}
