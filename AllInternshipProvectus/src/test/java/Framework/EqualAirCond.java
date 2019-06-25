package Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class EqualAirCond {

	private WebDriver driver;

	private int second = 15;

	private By buttonComp = By.xpath("//a[@class='btn-link btn-link-gray']"); 

	@FindBy(how = How.XPATH, xpath = "//div[@name='equal']") 
	private List<WebElement> comparisons;                    

	public EqualAirCond(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, second), this); 
	}

	public EqualAirCond clickOnButtonComp() {
		Wait.waitingForVisibilityOf(driver, buttonComp, second).click();
		return this;            
	}

	public void printEqualAirCond() {

		for (WebElement out : comparisons) {
			System.out.println(out.getText().trim().replaceAll("\n|\r\n", " "));
		}
	}
}