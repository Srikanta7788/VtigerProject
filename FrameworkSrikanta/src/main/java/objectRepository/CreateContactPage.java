package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameLink;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement crtconwthorglookupimg;

	@FindBy(xpath = "//input[@class='crmbutton small create']")
	private WebElement orgchldwndsearchbtn;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement orgchldwndsearchtxtfld;

	@FindBy(linkText = "myntra")
	private WebElement organisationname;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getOrganisationname() {
		return organisationname;
	}

	public WebElement getOrgchldwndsearchtxtfld() {
		return orgchldwndsearchtxtfld;
	}

	public WebElement getOrgchldwndsearchbtn() {
		return orgchldwndsearchbtn;
	}

	public WebElement getCrtconwthorglookupimg() {
		return crtconwthorglookupimg;
	}

	public WebElement getLastNameLink() {
		return lastNameLink;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
