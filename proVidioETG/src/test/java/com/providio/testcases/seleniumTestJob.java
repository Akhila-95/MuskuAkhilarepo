package com.providio.testcases;

import java.util.Collections;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.testng.TestNG;

public class seleniumTestJob implements Job {

  public void execute(JobExecutionContext context) throws JobExecutionException {
    // Create an instance of TestNG
    TestNG testNG = new TestNG();

    // Set the test suite classes or packages to be executed
    
    testNG.setTestSuites(Collections.singletonList("C:\\Users\\Upendra\\git\\ETGMainRepobyUpendra\\proVidioETG\\Excutingalltestcases.xml"));
    //testNG.setTestSuites(new String[] { "" });

    // Run the test suite
    testNG.run();
  }
}

