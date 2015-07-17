package com.andriidnikitin.producerconsumer.util;

import static com.andriidnikitin.producerconsumer.util.QueueUtil.SIZE_OF_QUEUE_WHEN_CONSUMERS_FALL_ASLEEP;
import static com.andriidnikitin.producerconsumer.util.QueueUtil.SIZE_OF_QUEUE_WHEN_CONSUMERS_WAKE_UP;

import com.andriidnikitin.producerconsumer.Element;
import com.andriidnikitin.producerconsumer.actors.Consumer;
import com.andriidnikitin.producerconsumer.actors.Producer;

public class QueueUtil {
	
	public static Element generateElement(){		
		return new Element(Math.random());
	}

	public static final int SIZE_OF_QUEUE_WHEN_PRODUCERS_FALL_ASLEEP = 100;
	
	public static final int SIZE_OF_QUEUE_WHEN_CONSUMERS_FALL_ASLEEP = 0;

	public static final int SIZE_OF_QUEUE_WHEN_PRODUCERS_WAKE_UP = 80;
	
	public static final int SIZE_OF_QUEUE_WHEN_CONSUMERS_WAKE_UP = 1;
	
	//public static final int CONSUMERS_SLEEP = 100;

	//public static final int PRODUCERS_SLEEP = 100;	

	public static final int SECOND = 1000;	
	
	public static boolean producerShouldSleep(int elementsInQueue){
		if (Producer.isSleeping) {
			if (elementsInQueue <= SIZE_OF_QUEUE_WHEN_PRODUCERS_WAKE_UP){
				Producer.isSleeping = false;
			}
		}
		else {
			if (elementsInQueue >= SIZE_OF_QUEUE_WHEN_PRODUCERS_FALL_ASLEEP){
				Producer.isSleeping = true;
			}				
		}
		return Producer.isSleeping;	
	}
	
	public static boolean consumerShouldSleep(int elementsInQueue){
		if (Consumer.isSleeping) {
			if (elementsInQueue >= SIZE_OF_QUEUE_WHEN_CONSUMERS_WAKE_UP){
				Consumer.isSleeping = false;
			}
		}
		else {
			if (elementsInQueue <= SIZE_OF_QUEUE_WHEN_CONSUMERS_FALL_ASLEEP){
				Consumer.isSleeping = true;
			}				
		}
		return Consumer.isSleeping;	
	}

	public static void showElements(int amount){
			System.out.println("Elements in queue - " + amount);
	}

}
