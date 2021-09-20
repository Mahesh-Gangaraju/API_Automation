package Reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Managers.ConfigFileReader;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReport {
    public void generateReport() {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
               // Uncomment Below Line and Comment Lines 22-26 To Save Results In Target Folder
               // String resultsFolder=System.getProperty("user.dir")+"/target";
                //***** Creating Unique Folder Name for Storing Results Locally ****************************************************
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
                Date date  = new Date();
                ConfigFileReader config = new ConfigFileReader("src/main/java/Config/Generic.properties");
                String baseResultsFolder = config.properties.getProperty("ResultsLocation");
                String resultsFolder = baseResultsFolder + "\\Results_" + dateFormat.format(date);
                //*****************************************************************************************************
                File reportOutputDirectory = new File(resultsFolder);
                List<String> jsonFiles = new ArrayList<String>();
                jsonFiles.add(baseResultsFolder+"/cucumber.json");
                String buildNumber = "1";
                String projectName = "API Automation";
                boolean runWithJenkins = false;
                boolean parallelTesting = false;
                Configuration configuration = new Configuration(reportOutputDirectory,projectName);
                configuration.setBuildNumber(buildNumber);
                ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
                reportBuilder.generateReports();
                System.out.println("*********************************************************************************************************************************************************");
                System.out.println("Results are Located at This Location: " + resultsFolder);
                System.out.println("*********************************************************************************************************************************************************");
            }
        });
    }
}
