package com.andriidnikitin.producerconsumer;

import com.andriidnikitin.producerconsumer.actors.Consumer;
import com.andriidnikitin.producerconsumer.actors.Producer;
import static com.andriidnikitin.producerconsumer.util.QueueUtil.*;

/**
 * This daemon thread represents process of consuming and producing.
 *  
 * @author Андрей
 *
 */
public class QueueThread extends Thread {
	
	ElementQueue queue;
	
	private boolean isStopped = false;
	
	public void stopThread() {
		this.isStopped = true;
		queue.stop();
	}
	
	public QueueThread(int sizeOfQueue) {
		initQueue(sizeOfQueue);
		setDaemon(true);
	}

	@Override
	public void run() {
		initActors();
		while (!isStopped){
			try {
				Thread.sleep(SECOND);
			} catch (InterruptedException e) {
				System.out.println("Queue thread was stopped.");
			}
		}
	}
	
	private void initQueue(int size) {
		queue = new ElementQueue(size);		
	}

	private void initActors() {

		new Producer(queue).start();
		new Producer(queue).start();
		
		new Consumer(queue).start();
		new Consumer(queue).start();
		new Consumer(queue).start();
		
	}

}
