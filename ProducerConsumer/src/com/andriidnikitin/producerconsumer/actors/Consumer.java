package com.andriidnikitin.producerconsumer.actors;

import com.andriidnikitin.producerconsumer.ElementQueue;

public class Consumer implements Actor {

	@Override
	public void act(ElementQueue q) throws InterruptedException {
		q.poll();

	}

}
