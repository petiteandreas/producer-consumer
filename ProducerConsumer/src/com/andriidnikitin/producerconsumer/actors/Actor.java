package com.andriidnikitin.producerconsumer.actors;

import com.andriidnikitin.producerconsumer.ElementQueue;

public interface Actor {
	void act(ElementQueue q) throws InterruptedException;
}
