package com.tatcha.TatchaSelWeb.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.TatchaSelWeb.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	private Properties propInit;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 20;
	public static WebDriverWait webDriverWait;

	protected void init(String path) {
		// "/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/com/tatcha/data/LoginData.properties"

		try {
			File file = new File(path);
			FileInputStream fileInput = null;
			prop = new Properties();
			fileInput = new FileInputStream(file);
			prop.load(fileInput);

			File file2 = new File(
					"/Users/shabnam/eclipse-workspace/TatchaSelWeb/src/main/java/com/tatcha/TatchaSelWeb/config/config.properties");
			FileInputStream file2Input = null;
			propInit = new Properties();
			file2Input = new FileInputStream(file2);
			propInit.load(file2Input);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browserName = propInit.getProperty("browser");

		// properties.load(new FileInputStream("file1.properties"));

		// Properties properties2 = new Properties();
		// properties2.load(new FileInputStream("file2.properties"));

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

		webDriverWait = new WebDriverWait(driver, 10);

		driver.get(propInit.getProperty("url"));

	}

	//Close cookie popup
	public void closeCookies() {
		driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();

	}

}
