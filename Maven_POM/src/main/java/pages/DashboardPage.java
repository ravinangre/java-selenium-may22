package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'Welfare Hospital')]")
	WebElement WelfareHospital;
	@FindBy(xpath="//a[text()=' Admin']")
	WebElement AdminUser;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getHomePageDashboardUserName(){

        return    AdminUser.getText();

       }
	public String getHomePageHospitalName(){

        return    WelfareHospital.getText();

       }
	
}
