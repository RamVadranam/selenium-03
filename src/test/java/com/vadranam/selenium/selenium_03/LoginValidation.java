package com.vadranam.selenium.selenium_03;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class LoginValidation {
	
	WebDriver driver;
	
	public void loadPageTest() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//form/input[@data-test='username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//form/input[@data-test=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//form/input[@value=\"LOGIN\"]")).click();
		
		Select select = new Select(driver.findElement(By.xpath("//div/select[contains(@class,'product_sort_container')]")));
		select.selectByIndex(3);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("item_4_title_link")));
		
		element.click();
		driver.findElement(By.xpath("//button[text()=\"ADD TO CART\"]")).click();
		
		driver.findElement(By.xpath("//button[text()='REMOVE']")).click();
		
		 driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		
		driver.findElement(By.linkText("All Items")).click();
		 driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		
		driver.findElement(By.linkText("About")).click();
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}

}
