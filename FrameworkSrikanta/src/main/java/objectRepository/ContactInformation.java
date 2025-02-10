package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	public ContactInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement contactInformationHeader;

	public WebElement getContactInformationHeader() {
		return contactInformationHeader;
	}
}
