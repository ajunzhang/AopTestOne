package com.fiberhome.concurrency.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Administrator 获取线程的返回值
 */
public class MainThread {

	public static void main(String[] args) {
		String str1 = "hello china";
		String str2 = "russian world cup";
		ExecutorService executorService = Executors.newCachedThreadPool();
		CalcWordNum cwn1 = new CalcWordNum(str1);
		CalcWordNum cwn2 = new CalcWordNum(str2);

		Future<Integer> future1 = executorService.submit(cwn1);
		Future<Integer> future2 = executorService.submit(cwn2);
		int num1 = 0, num2 = 0;
		try {
			num1 = future1.get();
			num2 = future2.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		System.out.printf("the num of words is %d %n", num1 + num2);

	}

}
