package com.andriidnikitin.producerconsumer.actors;

import com.andriidnikitin.producerconsumer.ElementQueue;

import static com.andriidnikitin.producerconsumer.util.QueueUtil.*;

public class Consumer extends Actor {
	
	private static volatile boolean isSleeping = false;
	
	private ElementQueue queue;
	
	private static int id = 0;

	@Override
	public ElementQueue queue() {
		return queue;
	}	
	
	public Consumer(ElementQueue queue) {
		this.queue = queue;
		id++;
	}

	@Override
	public void act() throws InterruptedException {
		synchronized(queue){
			decideWhatToDo(queue, SIZE_OF_QUEUE_WHEN_CONSUMERS_WAKE_UP, SIZE_OF_QUEUE_WHEN_CONSUMERS_FALL_ASLEEP);
			if (isSleeping){
				Thread.sleep(CONSUMERS_SLEEP);
			}
			else queue.poll();
			System.out.println("element was consumed by" + this);
			showElements(queue.size());
		}
		Thread.yield();
	}
	
	protected  void decideWhatToDo(ElementQueue q, int sizeOfQueWhenWakeUp, int sizeOfQueWhenFallAsleep){		
		int size = q.size();
		if (isSleeping) {
			if (size >= sizeOfQueWhenWakeUp){
				isSleeping = false;
			}
		}
		else {
			if (size <= sizeOfQueWhenFallAsleep){
				isSleeping = true;
			}
			
		}
	}	
	@Override
	public String toString() {		
		return "Consumer #" + id;
	}

}
