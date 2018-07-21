package com.fiberhome.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class FutureTest {
	
	private final ExecutorService executor = Executors.newCachedThreadPool();
	
	void renderPage(CharSequence source){
		final List<Object> imagesInfs = new ArrayList<Object>();
		Callable<List<String>> task = new Callable<List<String>>() {
			@Override
			public List<String> call() throws Exception {
				List<String> result = new ArrayList<String>();
				return result;
			}
		};
		
		Future<List<String>> future = executor.submit(task);
		
		try {
			List<String> imageData = future.get();
		} catch (InterruptedException e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();
			future.cancel(true);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
