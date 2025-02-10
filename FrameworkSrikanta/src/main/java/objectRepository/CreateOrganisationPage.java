package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	public CreateOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organisationNameTeaxtField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(name = "industry")
	private WebElement industryDd;

	@FindBy(name = "Chemicals")
	private WebElement chemicalType;

	@FindBy(name = "accounttype")
	private WebElement accountDd;

	@FindBy(name = "Analyst")
	private WebElement AnalystType;

	public WebElement getOrganisationNameTeaxtField() {
		return organisationNameTeaxtField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getIndustryDd() {
		return industryDd;
	}

	public WebElement getChemicalType() {
		return chemicalType;
	}

	public WebElement getAccountDd() {
		return accountDd;
	}

	public WebElement getAnalystType() {
		return AnalystType;
	}

	

	
}
