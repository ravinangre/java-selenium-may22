package tests;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;



import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginTest {
	WebDriver driver;
	LoginPage objlogin;
	DashboardPage objdash;
 
@Test(priority = 1)
  public void ValidateLoginTest() {
	  objlogin = new LoginPage(driver);
	  objlogin.loginAdminToHMS("admin@gmail.com","admin123");
	  String HMSTitle ="Hospital Management System";
	  String ActualTitle = driver.getTitle();
	  Assert.assertEquals(HMSTitle, ActualTitle);
  }
@Test(priority = 2)
public void ValidateDashboardTest() {
	objlogin = new LoginPage(driver);
	objlogin.loginAdminToHMS("admin@gmail.com","admin123");
	objdash = new DashboardPage(driver);
	String AdminUserText = objdash.getHomePageDashboardUserName(); 
	Assert.assertEquals(AdminUserText,"Admin");
	String HospitalName = objdash.getHomePageHospitalName();
	Assert.assertEquals(HospitalName, "Welfare Hospital");
}
  @BeforeMethod
  public void Setup() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Maven_POM\\Binary\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.get("https://hms.passogen.com/index.php/Hms/index");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }

  @AfterMethod
  public void afterTest() {
	//  driver.close();
  }

}
