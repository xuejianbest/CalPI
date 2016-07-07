package com.lwt.cal;

import java.util.concurrent.CountDownLatch;

public class CalPI {
	public static double sum = 0.0;
	
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		int tNum = 8;
		int step = Integer.MAX_VALUE/100;
		
		CountDownLatch done = new CountDownLatch(tNum);
		for(int i = 0; i < tNum; i++){
			int begin = 1;
			int start = begin + step * i;
			int end = begin + step * (i + 1) - 1;
			
			new Thread(new Worker(start, end, done)).start();
		}
		
		done.await();
		System.out.println(sum);
	}

	

}
