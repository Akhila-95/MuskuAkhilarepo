package com.providio.testcases;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;



public class testScheduler {

  public static void main(String[] args) throws SchedulerException {
    SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    Scheduler scheduler = schedulerFactory.getScheduler();

    JobDetail job = JobBuilder.newJob(seleniumTestJob.class)
      .withIdentity("seleniumTestJob", "group1")
      .build();

    Trigger trigger = TriggerBuilder.newTrigger()
      .withIdentity("testTrigger", "group1")
      .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
      .build();
    System.out.println("Excuting time");
    scheduler.scheduleJob(job, trigger);
    scheduler.start();
  }
}


