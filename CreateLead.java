package week5.day2;

import java.time.Duration;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	public ChromeDriver driver;
	@Test
	
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sandhiya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("D");
		driver.findElement(By.name("submitButton")).click();
	}
	@DataProvider
	public String[][] tesdata() throws IOException  {
		
		String[][] read = Read.read("tc001");
		return read;
	}

}
