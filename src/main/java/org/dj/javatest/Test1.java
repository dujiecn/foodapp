package org.dj.javatest;

/**
 * 
 * 项目名称：foodapp 类描述：子线程循环10次，接着主线程循环100次，接着子线程循环10次，接着主线程循环100次，如此往复50次
 * 类名称：org.dj.javatest.Test1 创建人：dujie 创建时间：2015年10月17日 下午11:49:38
 * 
 * @version V1.0
 */
public class Test1 {
	public static void main(String[] args) {
		final Business bus = new Business();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					bus.child(i);
				}
			}
		}).start();

		for (int i = 0; i < 50; i++) {
			bus.mian(i);
		}

	}

}

class Business {
	private boolean subRun = true;

	public synchronized void child(int i) {
		while (!subRun) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int j = 1; j <= 10; j++) {
			System.out.println("child:" + j + ",index:" + i);
		}
		subRun = false;
		notify();
	}

	public synchronized void mian(int i) {
		while (subRun) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		for (int j = 1; j <= 100; j++) {
			System.out.println("main:" + j + ",index:" + i);
		}
		subRun = true;
		notify();
	}
}
