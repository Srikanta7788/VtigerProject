package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;

	@FindBy(linkText = "Organizations")
	private WebElement OrganisationLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLink;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public WebElement getAdministratorLink() {
		return administratorLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOrganisationLink() {
		return OrganisationLink;

	}

}
