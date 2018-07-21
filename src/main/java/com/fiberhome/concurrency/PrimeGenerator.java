package com.fiberhome.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date
 * 素數生成器
 */
public class PrimeGenerator implements Runnable {

	private final List<BigInteger> primes = new ArrayList<BigInteger>();

	private volatile boolean cancelled;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BigInteger p = BigInteger.ONE;
		while (!cancelled) {
			p = p.nextProbablePrime();
			synchronized (this) {
				primes.add(p);
			}
		}
	}

	/**
	 * 设置取消为true
	 */
	public void cancel() {
		cancelled = true;
	}
	
	public synchronized List<BigInteger> get() {
		return new ArrayList<BigInteger>(primes);
	}

}
