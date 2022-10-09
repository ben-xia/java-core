package com.ben.java.core.annotation;

import org.junit.Test;

public class Testable {
	public void execute() {
		System.out.println("Executing....");
	}
	
	@Test void testExecute() {
		execute();
	}

}
