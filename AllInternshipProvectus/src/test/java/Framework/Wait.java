package Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	private static WebDriverWait waitFor(WebDriver driver, int second) {
		return new WebDriverWait(driver, second);
	}
		
	public static WebElement waitingForVisibilityOf(WebDriver driver, By element, int second) {
		return waitFor(driver, second).until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}
	
	public static List<WebElement> waitingForVisibilityOfAllElements(WebDriver driver, By element, int second) {
		return waitFor(driver, second).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(element)));
	}		
		
	public static WebElement waitingForElementToBeClickable(WebDriver driver, WebElement element, int second) {
		return waitFor(driver, second).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static WebElement waitingForPresenceOfNestedElementLocatedBy(WebDriver driver, WebElement element, By childLocator, int second) {
		return waitFor(driver, second).until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, childLocator));
	}

}
