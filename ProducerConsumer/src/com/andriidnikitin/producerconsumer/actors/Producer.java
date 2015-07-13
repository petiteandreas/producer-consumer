package com.andriidnikitin.producerconsumer.actors;

import static com.andriidnikitin.producerconsumer.util.QueueUtil.generateElement;

import com.andriidnikitin.producerconsumer.ElementQueue;

public class Producer implements Actor {

	@Override
	public void act(ElementQueue q) throws InterruptedException {
		q.addElement(generateElement());

	}

}
