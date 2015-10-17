package org.dj.javatest.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Store {
	 private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

	private List<Integer> list;

	private static final int MAX_SIZE = 50;

	public Store() {
		list = new LinkedList<>();
		queue = new ArrayBlockingQueue<>(MAX_SIZE);
	}

	public void set(Integer i) {
		try {
			 queue.put(i);
//			if(list.size() == MAX_SIZE) {
//				wait();
//			}
//			list.add(i);
//			notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer get() {
		try {
			Integer i = queue.take();
			return i;
//			if (list.size() == 0) {
//				wait();
//			}
//			notifyAll();
//			Integer val = list.get(0);
//			list.remove(0);
//			return val;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
