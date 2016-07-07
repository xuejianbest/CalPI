package com.lwt.cal;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
	private final CountDownLatch done;
	private final int start;
	private final int end;
	
	Worker(int start, int end, CountDownLatch done){
		this.done = done;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		double sum = 0;
		for(int n = start; n <= end; n++){
			sum += Math.pow(-1.0, n-1) * 4.0 / (2.0 * n - 1.0);
		}
		
		CalPI.sum += sum;
		done.countDown();
	}
}
