package com.example.testquartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
@Slf4j
public class HelloWorldJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String who = jobExecutionContext.getJobDetail().getJobDataMap().getString("who");
        log.info("Hello {}", who);
    }
}
