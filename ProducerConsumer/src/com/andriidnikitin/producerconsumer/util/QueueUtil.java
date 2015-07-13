package com.andriidnikitin.producerconsumer.util;

import com.andriidnikitin.producerconsumer.Element;

public class QueueUtil {
	
	public static Element generateElement(){		
		return new Element(Math.random());
	}

}
