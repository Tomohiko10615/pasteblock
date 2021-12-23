package com.pasteblock.pasteblock.app;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableScheduling
@EnableAsync
public class DueScheduler {
	private TaskScheduler scheduler;
	
	public static Long contratoId;

	Runnable due = new Runnable(){
	    @Override
	    public void run() {
	        System.out.println(contratoId);
	    }
	};

	@Async
	public void scheduleDue(Long dueTime, Long contratoId) {
	    ScheduledExecutorService localExecutor = Executors.newSingleThreadScheduledExecutor();
	    scheduler = new ConcurrentTaskScheduler(localExecutor);
	    
	    DueScheduler.contratoId = contratoId;
	    
	    Date date = new Date(System.currentTimeMillis() + 60000);
	    
	    scheduler.schedule(due,
	    		date);
	    
	    System.out.println(date);
	}
}
