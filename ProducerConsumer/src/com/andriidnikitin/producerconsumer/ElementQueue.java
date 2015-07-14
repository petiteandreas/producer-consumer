package com.andriidnikitin.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;


public class ElementQueue {
	
	private Queue<Element> elements = new LinkedList<Element>();
	
	private boolean stopped  = false; 

	public void addElement(Element element) {
		elements.add(element); 		
	}

	public void poll() {		
		elements.poll();
		
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

}
