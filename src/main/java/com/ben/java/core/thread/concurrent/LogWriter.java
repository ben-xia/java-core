package com.ben.java.core.thread.concurrent;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 写日志
 * @author ben xia
 *
 */
public class LogWriter {
	private final BlockingQueue<String> queue;
	private final LoggerThread logger;
	
	public LogWriter(Writer writer) {
		queue = new LinkedBlockingQueue<String>(100);
		logger = new LoggerThread(writer);
	}

	public void start() {
		logger.start();
	}
	
	public void log(String msg) {
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private class LoggerThread extends Thread{
		private final Writer writer;

		public LoggerThread(Writer writer) {
			super();
			this.writer = writer;
		}
		@Override
		public void run() {
			
				try {
					while(true)
					writer.write(queue.take());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if (writer!=null)
						try {
							writer.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
		}
		
	}
	
	public static void main(String[] args) {
		Writer writer =null;
		try {
			new FileWriter("F:\\log.txt");
			LogWriter logWriter = new LogWriter(writer);
			logWriter.start();
			for (int i = 0; i < 10000; i++) {
				logWriter.log("我是中国人"+"\t");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
