package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {

	PropertyFileUtility putil = new PropertyFileUtility();
	XlFileUtility xutil = new XlFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite // (groups = {"smoke","regression"})
	public void bsConfig() {
		Reporter.log("data base conection", true);
	}

	// @Parameters("browser")
	// @BeforeTest
	@BeforeClass // (groups = {"smoke","regression"})
	public void bcConfig(/* String BROWSER */) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");

		if (BROWSER.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		}
		sDriver = driver; // listners
		Reporter.log("browser got lunched successfully", true);
		wutil.toMaximize(driver);
		wutil.toImplicitWait(driver);
		driver.get(URL);
	}

	@BeforeMethod // (groups = {"smoke","regression"})
	public void bmConfig() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextfield().sendKeys(USERNAME);
		;
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		;
		lp.getLoginButton().click();
		Reporter.log("successfully v tiger application home page navigate");
	}

	@AfterMethod // (groups = {"smoke","regression"})
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		WebElement administratorImage = hp.getAdministratorLink();
		wutil.toMouseHover(driver, administratorImage);
		hp.getSignOutLink().click();
		Reporter.log("logout vtiger application successfullly", true);

	}

	@AfterClass // (groups = {"smoke","regression"})
	public void acConfig() {
		driver.quit();
		Reporter.log("close the application successfullly", true);

	}

	@AfterSuite // (groups = {"smoke","regression"})
	public void asConfig() {
		Reporter.log("data base disconection", true);

	}

}
