package com.andriidnikitin.producerconsumer.util;

import com.andriidnikitin.producerconsumer.Element;

public class QueueUtil {
	
	public static Element generateElement(){		
		return new Element(Math.random());
	}

	public static final int SIZE_OF_QUEUE_WHEN_PRODUCERS_FALL_ASLEEP = 100;
	
	public static final int SIZE_OF_QUEUE_WHEN_CONSUMERS_FALL_ASLEEP = 0;

	public static final int SIZE_OF_QUEUE_WHEN_PRODUCERS_WAKE_UP = 80;
	
	public static final int SIZE_OF_QUEUE_WHEN_CONSUMERS_WAKE_UP = 1;
	
	public static final int CONSUMERS_SLEEP = 100;

	public static final int PRODUCERS_SLEEP = 100;	

	public static final int SECOND = 1000;	

	public static void showElements(int amount){
			System.out.println("Elements in queue - " + amount);
	}

}
