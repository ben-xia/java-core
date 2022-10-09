package com.ben.java.gof.structural_model.decorator;

public class FileReader extends Reader {

	@Override
	void close() {
		System.out.println("FileReader.close()");
	}

}
