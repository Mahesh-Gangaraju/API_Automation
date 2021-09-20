package BaseClass;

import Managers.ConfigFileReader;
import Reporting.CucumberReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


public class BaseClass {

    public static Scenario scenario;

    @Before
    public void beforeHook(Scenario scenerio) throws Exception {
        System.out.println("RUNNING BEFORE HOOK");
        this.scenario = scenerio;
        System.out.println("Scenario Name: " + scenario.getName());
        killProcesses();
    }

    @After
    public void afterHook() throws Exception {
        System.out.println("RUNNING AFTER HOOK");
        CucumberReport cucumberReport = new CucumberReport();
        cucumberReport.generateReport();
        killProcesses();
    }

    //Below method is used to close unwanted processes which should be closed before/after running scenario.
    @SuppressWarnings("deprecation")
    public static void killProcesses() throws InterruptedException
    {
        String taskKillCommand = "TASKKILL /F /IM ";
        try
        {
            // Runtime.getRuntime().exec(taskKillCommand + "chrome.exe" + " /T");
            Runtime.getRuntime().exec(taskKillCommand + "EXCEL.exe" + " /T");
        }
        catch(Exception e)
        {

        }
    }

}
