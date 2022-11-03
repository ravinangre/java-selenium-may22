package com.mycompany.app;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class DPTest {
  @Test(dataProvider = "dp")
  public void f(String userid, String password) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sharayu\\May-selenium-22\\Binary\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  System.out.println(Thread.currentThread().getId());
	  driver.get("https://www.facebook.com");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  WebElement UserName = driver.findElement(By.xpath("//input[@id='email']"));
	  WebElement Password = driver.findElement(By.xpath("//input[@id='pass']"));
	  WebElement LoginBtn = driver.findElement(By.xpath("//button[@name='login']"));
	  UserName.sendKeys(userid);
	  Password.sendKeys(password);
	  LoginBtn.click();
  }

  @DataProvider(parallel = true)
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "9423111564", "123456543" },
      new Object[] { "8830158607", "5432456234" },
      new Object[] { "ravinangre@gmail.com", "5432456234" },
      new Object[] { "ravinangre", "5432456234" },
    };
  }
}
