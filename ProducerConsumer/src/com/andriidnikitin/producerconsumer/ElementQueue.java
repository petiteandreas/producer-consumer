package com.andriidnikitin.producerconsumer;

import java.util.Queue;


public class ElementQueue {
	
	private Queue<Element> elements; 

	public void addElement(Element element) {
		elements.add(element); 		
	}

	public void poll() {		
		elements.poll();
		
	}
	
	public int size(){
		return elements.size();
	}

}
