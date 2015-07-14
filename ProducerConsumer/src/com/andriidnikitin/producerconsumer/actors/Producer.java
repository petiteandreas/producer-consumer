package com.andriidnikitin.producerconsumer.actors;

import static com.andriidnikitin.producerconsumer.util.QueueUtil.*;

import com.andriidnikitin.producerconsumer.ElementQueue;

public class Producer  extends Actor {
	
	private ElementQueue queue;
	
	private static int id = 0;

	@Override
	public ElementQueue queue() {
		return queue;
	}	
	
	
	private static volatile boolean isSleeping = false;
	
	public Producer(ElementQueue queue) {
		id++;
		this.queue = queue;
	}

	@Override
	public void act() throws InterruptedException {
		synchronized(queue){
			decideWhatToDo(queue, SIZE_OF_QUEUE_WHEN_PRODUCERS_WAKE_UP, SIZE_OF_QUEUE_WHEN_PRODUCERS_FALL_ASLEEP);
			if (isSleeping){
				Thread.sleep(PRODUCERS_SLEEP);
			}
			else {
				queue.addElement(generateElement());
				System.out.println("element was produced by" + this);
				showElements(queue.size());
			}
		}
		Thread.yield();
	}

	protected  void decideWhatToDo(ElementQueue q, int sizeOfQueueWhenWakeUp, int sizeOfQueueWhenFallAsleep){		
		int size = q.size();
		if (isSleeping) {
			if (size <= sizeOfQueueWhenWakeUp){
				isSleeping = false;
			}
		}
		else {
			if (size >= sizeOfQueueWhenFallAsleep){
				isSleeping = true;
			}
			
		}
	}	
	
	@Override
	public String toString() {		
		return "Producer #" + id;
	}

}
