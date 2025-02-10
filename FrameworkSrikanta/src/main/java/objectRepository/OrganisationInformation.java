package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformation {
	public OrganisationInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement OrganisationInformationHeader;

	public WebElement getOrganisationInformationHeader() {
		return OrganisationInformationHeader;
	}

}
