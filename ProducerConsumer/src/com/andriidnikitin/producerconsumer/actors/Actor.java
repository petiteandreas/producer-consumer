package com.andriidnikitin.producerconsumer.actors;

import com.andriidnikitin.producerconsumer.ElementQueue;

public 
//interface
abstract class
Actor extends Thread {
	
	abstract protected ElementQueue queue();
		
	abstract void act() throws InterruptedException;
	
	@Override
	public void run() {
		while (!queue().isStopped()){
			try {
				act();
			} catch (InterruptedException e) {
				System.out.println("Thread " + this + " has stopped");
			}
		}
	}
}
