package com.fiberhome.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author Administrator 
 * 实现一个定时器Bean
 *
 */
@Component
public class AlarmTimer {

	@PostConstruct
	public void alarmTimer() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		Task task = new Task();
		scheduledExecutorService.scheduleAtFixedRate(task, 1, 60, TimeUnit.SECONDS);
	}

	public class Task implements Runnable {
		@Override
		public void run() {
			System.out.println("Task: " + System.currentTimeMillis());
		}

	}
}
