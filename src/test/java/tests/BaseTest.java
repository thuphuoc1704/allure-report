package tests;


import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import pages.HomePage;
import utils.logs.Log;

public class BaseTest {
    public WebDriver driver;
    public HomePage  homePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests are starting!");
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
        
        driver.quit();
    }
    @BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		System.out.println("---------- START delete file in folder ----------");
		deleteAllFileInFolder();
		System.out.println("---------- END delete file in folder ----------");
	}
    @Step("{0}")
    public String logMessage(String log) {
    	return log;
    }

	public void deleteAllFileInFolder() {
		try {
			String pathFolderDownload = System.getProperty("user.dir") + "/allure-results";
			String pathLog = System.getProperty("user.dir") + "/log4j2";
			File file = new File(pathFolderDownload);
			File fileLog = new File(pathLog);
			File[] listOfFilesLog = fileLog.listFiles();
			File[] listOfFiles = file.listFiles();
			for(int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
			for(int i = 0; i < listOfFilesLog.length; i++) {
				if (listOfFilesLog[i].isFile()) {
					System.out.println(listOfFilesLog[i].getName());
					new File(listOfFilesLog[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
