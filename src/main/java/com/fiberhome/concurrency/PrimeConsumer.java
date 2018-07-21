package com.fiberhome.concurrency;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Administrator
 * 素數消費者
 */
public class PrimeConsumer {
	
	public static void main(String[] args) {
		BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(100);
		PrimeProducer primeProducer = new PrimeProducer(queue);
		
		try {
			new Thread(primeProducer).start();
			primeProducer.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			primeProducer.cancel();
		}
		
		queue.forEach(action->{
			System.out.print(action+",");
		});
		
	}

}
