package com.andriidnikitin.producerconsumer.actors;

import java.util.ArrayList;
import java.util.List;

public class ActorPlanner {

	private List<Producer> producersList = new ArrayList<>();
	
	private List<Consumer> consumersList = new ArrayList<>();	

	private int consumersUnprioritied = 0;

	private int producersUnprioritied = 0;

	private int producers = 0;
	
	private int consumers = 0;
	
	public static ActorPlanner getInstance(){
		return LazyHolder.INSTANCE;
	}
	
	private ActorPlanner(){		
	}

	public static void register(Consumer c){
		getInstance().consumersList.add(c);
		getInstance().consumers++;
	}
	
	public static void register(Producer p){
		getInstance().producersList.add(p);
		getInstance().producers++;
	}
	
	public static void inform(Producer p){
		p.setPriority(Thread.MIN_PRIORITY);
		calculateProducerPriorities();
	}
	
	public static void inform(Consumer c){
		c.setPriority(Thread.MIN_PRIORITY);
		calculateConsumerPriorities();
	}	
	
	private static void calculateConsumerPriorities() {
		getInstance().consumersUnprioritied++;
		if (getInstance().consumersUnprioritied == getInstance().consumers){
			getInstance().consumersUnprioritied = 0;
			for (Consumer c : getInstance().consumersList){
				c.setPriority(Thread.NORM_PRIORITY);
			}
		}
	}
	
	private static void calculateProducerPriorities() {
		getInstance().producersUnprioritied++;
		if (getInstance().producersUnprioritied == getInstance().producers){
			getInstance().producersUnprioritied = 0;
			for (Producer c : getInstance().producersList){
				c.setPriority(Thread.NORM_PRIORITY);
			}
		}
	}

	private static class LazyHolder {
	        private static final ActorPlanner INSTANCE = new ActorPlanner();
	 }
}
