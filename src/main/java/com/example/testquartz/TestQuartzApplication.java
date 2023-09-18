package com.example.testquartz;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TestQuartzApplication {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		SpringApplication.run(TestQuartzApplication.class, args);
//		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//		scheduler.start();
//
//		JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class)
//				.withIdentity("my-first-job")
//				.storeDurably(true)
//				.usingJobData("who", "My name is Hieu!!!")
//				.build();
//		Trigger trigger = TriggerBuilder.newTrigger()
//				.withIdentity("my-first-trigger")
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
//						.withIntervalInSeconds(10).withRepeatCount(3))
//				.build();
//
//		scheduler.scheduleJob(jobDetail,trigger);
//		Thread.sleep(5000);
//		scheduler.standby();
//		scheduler.shutdown();
		Send s = new Send();

		s.doSend(args);
	}

}
