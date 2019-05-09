package SampleTest;


import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Test1 {
	
	@Test
	public void test1() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumFramework\\sampleProject1\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.studytonight.com/python/operators-in-python");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String sTopics_xpath = "//div[@id='sidebar-sliding-menu']//ul/li/a[not(contains(@target,'_blank'))]";
		
		List<WebElement> lstAllLinks = driver.findElements(By.xpath(sTopics_xpath));
		String arr[] = new String[lstAllLinks.size()];
		int i =0;
		for(WebElement e:lstAllLinks){
			String sTopic = e.getText();
			System.out.println(sTopic);
			//for(int i = 0;i<lstAllLinks.size();i++){
				arr[i] = sTopic; 
				
				i=i+1;
			//}
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red');", e);
		//	Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style','');", e);
			
			
		}
		
		
		System.out.println(lstAllLinks.size());
		//int actual=0;
		//int expected=0;
				
		assertEquals(38, lstAllLinks.size());
		
		/*for(int j = 0;j<lstAllLinks.size();j++){
			String sPartialXpath = "//div[@id='sidebar-sliding-menu']//ul/li/a[contains(text(),'#DUMMY#')]";
			sPartialXpath = sPartialXpath.replace("#DUMMY#", arr[j].toString());
			
			if (!(arr[j].toString().equals("Operators")))
			{
				driver.findElement(By.xpath(sPartialXpath)).click();
			}
			driver.navigate().back();
			 
			
		}*/
		
		
	}

}
