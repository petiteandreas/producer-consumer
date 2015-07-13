package com.andriidnikitin.producerconsumer.actors;

import com.andriidnikitin.producerconsumer.ElementQueue;

import static com.andriidnikitin.producerconsumer.util.QueueUtil.*;

public class Consumer extends Thread implements Actor {
	
	private static volatile boolean isSleeping = false;

	public Consumer(ElementQueue queue) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act(ElementQueue q) throws InterruptedException {
		synchronized(q){
			decideWhatToDo(q);
			if (isSleeping){
				Thread.sleep(CONSUMERS_SLEEP);
			}
			else q.poll();
		}
	}

	private void decideWhatToDo(ElementQueue q){		
			int size = q.size();
			if (isSleeping) {
				if (size >= SIZE_OF_QUEUE_WHEN_CONSUMERS_WAKE_UP){
					isSleeping = false;
				}
			}
			else {
				if (size <= SIZE_OF_QUEUE_WHEN_CONSUMERS_FALL_ASLEEP){
					isSleeping = true;
				}
				
			}
	}
	
	@Override
	public void run() {
		/*while (!q.stop()){
			act(q);
		}*/
	}

}
