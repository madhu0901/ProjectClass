package org.test.base;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
	
	//CHROME LAUNCH....1
		public static WebDriver ChromeLaunch() {
				
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			return driver;

		}
		
		public static WebDriver EdgeLaunch() {
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			return driver;
}
		//SWITCH CASE.....2
		
				public static void browserLaunch(int browser) {
					
						switch(browser)
						
						{
						
							case 1:
								WebDriverManager.chromedriver().setup();
								driver=new ChromeDriver();
								break;
							case 2:
								WebDriverManager.edgedriver().setup();
								driver=new EdgeDriver();
								break;
						}
						
					}
				
				//URL LAUNCH...3
				public static  void urlLaunch(String url) {
					driver.get(url);
				}
				
				//IMP WAIT....4
				public static void impWait() {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					}
				//SEND KEYS......5
				public static void sendKeys(WebElement e,String data) {
					e.sendKeys(data);	
				}
				public static void click(WebElement e) {
					e.click();

				}
				
				//GET CURRENT URL....6
				public static String getCurrenturl() {
					String url=driver.getCurrentUrl();
					return url;

				}
				public static void quit() {
					driver.quit();

				}
				//GET ATTRIBUTE....7
				public String getAttribute(WebElement e) {
					String s = e.getAttribute("value");
					return s;
}
				
				//ACTIONS..........8
				public static void dragandDrop(WebElement from,WebElement to) {
					Actions a=new Actions(driver);
					a.dragAndDrop(from, to).perform();
					
				}
				
				//Click...........9
				public static void actionClick(WebElement target) {
					Actions a=new Actions(driver);
					a.click(target).perform();

				}
				
				//ContextClick.............10
				public static void contextClick(WebElement right) {
					Actions a=new Actions(driver);
					a.contextClick(right).perform();

				}
				
				//DoubleClick........11
				public static void doubletClick(WebElement doub) {
					Actions a=new Actions(driver);
					a.doubleClick(doub).perform();
				}
				
				//SIMPLE ALERT.....12
				public static void simpleAlert() {
					Alert al=driver.switchTo().alert();
					al.accept();
				}
				
				//CONFIRM ALERT...........13
				public static void confirmAlert( ) {
					Alert al=driver.switchTo().alert();
					al.dismiss();
					
				}
				
				//PROMPT ALERT..............14
				public static void promptAlert(WebElement e,String edit) {
					Alert al=driver.switchTo().alert();
					e.sendKeys(edit);
					al.accept();
					
				}
				
				//SELECT DROP DOWN     SELECT BY INDEX.......15
				public static void selectByIndex(WebElement e,int index) {
					Select s=new Select(e);
					s.selectByIndex(index);
				}	
					
					//SELECT BY VALUE.......16
				public static void selectByValue(WebElement e,String value) {
					//selectByValue(e,value);
					Select s=new Select(e);
					s.selectByValue(value);

				}
				
				//SELECT BY VISIBLE TEXT..........17
				public static void selectByVisibleText(WebElement e,String text) {
					Select s=new Select(e);
					s.selectByVisibleText(text);
				}
					
				//IS MULTIPLE.......18
				 public static void isMultiple(boolean b) {
					 isMultiple(b);
				 }
				 
				 //GET FIRST SELECTED OPTION...........19
				 public static void getFirstSelectedOptions(WebElement e) {
					 Select s=new Select(e);
					 s.getFirstSelectedOption();
				 }

				 //GET ALL SELECTED OPTIONS............20
				public static void getAllSelectedOptions (WebElement e) {
					Select s=new Select(e);
					s.getAllSelectedOptions();
					
				}
				
				//DESELECT BY INDEX......21
				public static void deSelectByIndex(WebElement e,int index) {
					Select s=new Select(e);
					s.deselectByIndex(index);
				}
				
				//DESELECT BY VALUE.........22
				public static void deSelectByValue(WebElement e,String value) {
					Select s=new Select(e);
					s.deselectByValue(value);
				
				}
				//DESELECT BY VISIBLE TEXT........23
				public static void deSelectByVisibleText(WebElement e,String text) {
					Select s=new Select(e);
					s.deselectByVisibleText(text);
				}
				
				//SCREENSHOT........24
				
				public static void getScreenshotAs(String add) throws IOException {
					TakesScreenshot ts=(TakesScreenshot)driver;
					File from1 = ts.getScreenshotAs(OutputType.FILE);
					//Scanner s=new Scanner(System.in);
					//String add = s.next();
					//File to1=new File("C:\\Users\\Madhana M\\eclipse-workspace\\Maven\\Screenshot\\"+add+".png");
					File to1=new File("uesr.dir"+add+".png");
					FileUtils.copyFile(from1, to1);
					
				}
					
				//JAVASCRIPT EXECUTOR
				public static void executeScript(WebElement e,String s) {
					JavascriptExecutor js=(JavascriptExecutor) driver;
					js.executeScript("arguments[0].setAttribute('value',"+s+")",e);			

				}
				//JAVA SCRIPT-------SCROLLDOWN
				public static void scrollDown(WebElement e) {
					JavascriptExecutor js=(JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true)",e);
				}
				//JAVA SCRIPT-------SCROLLUP
				public static void scrolUp(WebElement e) {
					JavascriptExecutor js=(JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(false)",e);
				}
				
				//WINDOWS HANDLING
				public static void windowsHandle() {
					Set<String> all = driver.getWindowHandles();
					int count=1;
					for(String eachid:all) {
						if(count==2) {
							driver.switchTo().window(eachid);
						}count++;
					}
				}
}