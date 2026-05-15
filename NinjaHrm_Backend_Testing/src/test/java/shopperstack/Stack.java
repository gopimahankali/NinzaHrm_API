package shopperstack;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Stack {
@Test
public void demo() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.shoppersstack.com/");
	driver.manage().window().maximize();
	 Thread.sleep(3000);
	driver.findElement(By.id("loginBtn")).click();
	 Thread.sleep(3000);
	driver.findElement(By.id("Email")).sendKeys("dingu23@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Abcd@123");
	driver.findElement(By.id("Login")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='cartIcon']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//h3[text()='crocs']//ancestor::div[@color='white']//descendant::button")).click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//button[text()='Yes'])[2]")));
	driver.quit();
}
}
