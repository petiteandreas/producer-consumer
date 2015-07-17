package com.andriidnikitin.producerconsumer;

import static com.andriidnikitin.producerconsumer.util.QueueUtil.*;

import java.util.LinkedList;
import java.util.Queue;

public class ElementQueue {
	
	private Queue<Element> elements = new LinkedList<Element>();
	
	private boolean stopped  = false; 	


	public ElementQueue(int size) {
		for (int i=0; i<size; i++){
			elements.add(generateElement());
		}
	}

	public synchronized int addElement(Element element) {
		while (!producersAreActive()) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
	      }
		elements.add(element); 
	    notifyAll();
		return size();		
	}

	public synchronized int poll() {	
		while (!consumersAreActive()) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
	    }
	    notifyAll();
		elements.poll();
		return size();		
	}
	
	public int size(){
		return elements.size();
	}

	public void stop() {
		stopped  = true;
	}
	
	public boolean isStopped() {
		return stopped ;
	}

	private boolean producersAreActive() {		
		return !producerShouldSleep(size());
	}
	

	private boolean consumersAreActive() {
		return !consumerShouldSleep(size());
	}

}
