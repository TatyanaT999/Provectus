package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage{	
	
	private WebDriver driver;
	
	private int second = 15;
	
	private By pickTown = By.xpath("//a[@class='header-cities__link link-dashed']");
	
	private By town = By.xpath("//a[@class='header-location__popular-link']");
	
	private By bitTeh = By.xpath("//ul[@class='menu-categories menu-categories_type_main']//a[@href='https://bt.rozetka.com.ua/']");
	
	private By airCond = By.xpath("//a[@href='https://bt.rozetka.com.ua/air_conditioners/c80133/']");
	
	public MainPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public MainPage getMainPage(){
		
		driver.get("https://rozetka.com.ua");
		return this;
	}
	
	public MainPage pickTown(){
		
		Wait.waitingForVisibilityOf(driver, pickTown, second).click();
		Wait.waitingForVisibilityOfAllElements(driver, town, second).get((int)(Math.random()*6)).click();
		return this;
	}
	
	public void selectMenuAirCond(){
		
		Actions actone = new Actions(driver);
		actone.moveToElement(Wait.waitingForVisibilityOf(driver, bitTeh, second)).perform();
		
		Actions actthree = new Actions(driver);
		actthree.moveToElement(Wait.waitingForVisibilityOf(driver, airCond, second)).click().perform();
		
	}
	

}
