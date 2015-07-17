package com.andriidnikitin.producerconsumer.actors;

import static com.andriidnikitin.producerconsumer.util.QueueUtil.*;

import com.andriidnikitin.producerconsumer.ElementQueue;

public class Producer  extends Actor {
	
	private ElementQueue queue;
	
	@Override
	public ElementQueue queue() {
		return queue;
	}	
	
	
	public static volatile boolean isSleeping = false;
	
	public Producer(ElementQueue queue) {
		this.queue = queue;
		ActorPlanner.register(this);
	}

	@Override
	public void act() throws InterruptedException {
		System.out.println(this + " acted." + queue.addElement(generateElement()) + " in queue.");
		ActorPlanner.inform(this);
	}
	
	@Override
	public String toString() {		
		return "Producer #" + this.getId()%10;
	}

}
