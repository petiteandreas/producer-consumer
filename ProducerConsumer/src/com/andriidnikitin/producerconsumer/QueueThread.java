package com.andriidnikitin.producerconsumer;

import com.andriidnikitin.producerconsumer.actors.Consumer;
import com.andriidnikitin.producerconsumer.actors.Producer;

/**
 * This daemon thread represents process of consuming and producing.
 *  
 * @author Андрей
 *
 */
public class QueueThread extends Thread {
	
	private final ElementQueue queue = new ElementQueue();
	
	private boolean isStopped = false;
	
	public void stopThread() {
		this.isStopped = true;
	}
	
	public QueueThread(int sizeOfQueue) {
		initQueue(sizeOfQueue);
		setDaemon(true);
	}

	@Override
	public void run() {
		initThreads();
		while (!isStopped){
			System.out.println("Elements in queue - " + queue.size());
		}
	}
	
	private void initQueue(int size) {
		//add default elements
		
	}

	private void initThreads() {

		new Producer(queue).start();
		new Producer(queue).start();
		
		new Consumer(queue).start();
		new Consumer(queue).start();
		new Consumer(queue).start();
		
	}

}
