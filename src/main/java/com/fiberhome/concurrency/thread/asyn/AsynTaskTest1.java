package com.fiberhome.concurrency.thread.asyn;

public class AsynTaskTest1 {
	public static void main(String[] args) {
		
		test1();
	}
	
	private static void test1(){
		Thread thread = new Thread();
		int N_CPUS = Runtime.getRuntime().availableProcessors();
		System.out.println(N_CPUS);
		
	}

}
