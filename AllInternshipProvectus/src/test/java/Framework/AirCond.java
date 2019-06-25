package Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AirCond {
	
	private WebDriver driver;
	
	private int second = 15;
	
	private By listOfAirCond = By.xpath("//div[@name='goods_item_with_promotion']");
	
	private By buttonComp = By.xpath(".//div[@name='comparison_new_catalog']");
	
	private By checkButtonComp = By.xpath(".//span[@class='incomparison']");
	
	private By buttonMainComp = By.xpath("//div[@id='comparison']");
	
	public AirCond(WebDriver driver) {
		
		this.driver = driver;
	}
		
	private List<WebElement> listOfAirCond(){
		return Wait.waitingForVisibilityOfAllElements(driver, listOfAirCond, second);
	}
	
	public AirCond selectFirstTwoAirCond(){
		
		for(int i = 0; i < 2; i++){
			Actions actfirst = new Actions(driver);
			WebElement firstAirCond = listOfAirCond().get(i);
		
			actfirst.moveToElement(firstAirCond).build().perform();
			Wait.waitingForElementToBeClickable(driver, firstAirCond.findElement(buttonComp), second).click();
			Wait.waitingForPresenceOfNestedElementLocatedBy(driver, firstAirCond, checkButtonComp, second);
		}		
		
		return this;
	}	

	public void equalTwoAirCond(){
		Wait.waitingForVisibilityOf(driver, buttonMainComp, second).click();
	}
}
