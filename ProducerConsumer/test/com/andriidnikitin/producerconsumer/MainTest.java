package com.andriidnikitin.producerconsumer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.andriidnikitin.producerconsumer.actors.Consumer;
import com.andriidnikitin.producerconsumer.actors.Producer;

public class MainTest {
	
	@Test
	public void createQueueTest(){
		int sizeOfQueue = 200;							  //given
		
		QueueThread thread = new QueueThread(sizeOfQueue);//when
		int size = thread.queue.size();
		
		assertEquals(sizeOfQueue, size);				  //then
	}
	
	@Test
	public void createConsumerTest(){
		int sizeOfQueue = 200;							  //given		
		QueueThread thread = new QueueThread(sizeOfQueue);
		
		Consumer consumer = new Consumer(thread.queue);	  //when
		
		assertEquals(consumer.queue(), thread.queue);	  //then
	}
	
	@Test
	public void createProducerTest(){
		int sizeOfQueue = 200;							  //given		
		QueueThread thread = new QueueThread(sizeOfQueue);
		
		Producer producer = new Producer(thread.queue);	  //when
		
		assertEquals(producer.queue(), thread.queue);	  //then
	}
	
}
