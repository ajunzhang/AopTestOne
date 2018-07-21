package com.fiberhome.concurrency;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @author Administrator
 *
 * 用阻塞队列存储生成器生成的素数
 */
public class PrimeProducer extends Thread {
	private final BlockingQueue<BigInteger> queue;

	public PrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			BigInteger p = BigInteger.ONE;
			while (!Thread.currentThread().isInterrupted()) {
				p = p.nextProbablePrime();
				queue.put(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void cancel(){
		interrupt();
	}
}
