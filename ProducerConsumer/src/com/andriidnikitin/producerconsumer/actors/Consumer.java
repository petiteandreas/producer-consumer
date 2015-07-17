package com.andriidnikitin.producerconsumer.actors;

import com.andriidnikitin.producerconsumer.ElementQueue;

public class Consumer extends Actor {
	
	public static volatile boolean isSleeping = false;
	
	private ElementQueue queue;
	
	@Override
	public ElementQueue queue() {
		return queue;
	}	
	
	public Consumer(ElementQueue queue) {
		this.queue = queue;
		ActorPlanner.register(this);
	}

	@Override
	public void act() throws InterruptedException {		
		System.out.println(this + " acted." + queue.poll() + " in queue.");
		ActorPlanner.inform(this);
	}	
	
	@Override
	public String toString() {		
		return "Consumer #" + this.getId()%10;
	}

}
