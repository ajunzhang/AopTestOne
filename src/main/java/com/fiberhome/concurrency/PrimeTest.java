package com.fiberhome.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 *
 * 測試類PrimeGenerator
 */
public class PrimeTest {
	public static void main(String[] args) {
		List<BigInteger> primeList = new ArrayList<BigInteger>();
		try {
			primeList = aSecondOfPrimes(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(primeList.toArray()));
	}

	public static List<BigInteger> aSecondOfPrimes(long seconds) throws InterruptedException {

		PrimeGenerator primeGenerator = new PrimeGenerator();
//		java.util.concurrent.ExecutorService executorService = Executors.newCachedThreadPool();
//		executorService.submit(primeGenerator);
		
		new Thread(primeGenerator).start();
		
		try {
			Thread.currentThread().sleep(seconds);
		} finally{
			primeGenerator.cancel();
		}
		return primeGenerator.get();
	}

}
