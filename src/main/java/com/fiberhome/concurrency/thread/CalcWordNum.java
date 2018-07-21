package com.fiberhome.concurrency.thread;

import java.util.concurrent.Callable;

/**
 * @author Administrator 计算str中的单词个数
 */
public class CalcWordNum implements Callable<Integer> {
	private final String str;

	public CalcWordNum(String str) {
		this.str = str;
	}

	@Override
	public Integer call() throws Exception {
		int wordNum = str.split(" ").length;
		System.out.println("currentThread " + Thread.currentThread().getName() + " word num is " + wordNum);
		return wordNum;
	}

}
