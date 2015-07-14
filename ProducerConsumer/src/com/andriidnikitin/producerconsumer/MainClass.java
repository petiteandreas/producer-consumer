package com.andriidnikitin.producerconsumer;
;

public class MainClass {
	
	private static final int DEFAULT_SIZE_OF_QUEUE = 200;

	public static void main(String[] args) {
		new QueueThread(DEFAULT_SIZE_OF_QUEUE).start();	
		System.out.println("Press q to quit");
		while (true){
			try {
				Thread.sleep(100);
				//if not pressed - yield
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
