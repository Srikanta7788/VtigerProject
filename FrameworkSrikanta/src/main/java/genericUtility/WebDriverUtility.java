package genericUtility;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebElement element = null;

	/**
	 * this method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method is used to minimize the browser
	 * 
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * this method is used to wait the element by implicitly wait
	 * 
	 * @param driver
	 */
	public void toImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * this method is used to wait untill element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void toExplicitwaitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * this method is used to wait untill element to be selected
	 * 
	 * @param driver
	 * @param element
	 */
	public void toExplicitWaitElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));

	}

	/**
	 * this method is used to handle the drop down select by index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	/**
	 * this method is used to handle the dropdown by using select by value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * this method is used to handle the dropdown by using selected by visibletext
	 * 
	 * @param value
	 * @param element
	 */
	public void toHandleDropdown(String visibletext, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(visibletext);
	}

	/**
	 * this method is used to handle frame by using index value
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to handle frame by using id or name
	 * 
	 * @param driver
	 * @param name
	 */
	public void toHandleFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	/**
	 * this method is used to handle frame by using webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method is used to swich back the fame to main page
	 * 
	 * @param driver
	 */
	public void toHandleFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to perform mouse hover action
	 * 
	 * @param driver
	 * @param administratorlink
	 */
	public void toMouseHover(WebDriver driver, WebElement administratorlink) {
		Actions act = new Actions(driver);
		act.moveToElement(administratorlink).perform();
	}

	/**
	 * this method is used to perform double click action
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDubbleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * this method is used to perform right click action
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * this method is used to perfor drag and drop action bhyy passing driver and
	 * sorce and taget referencr
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	/**
	 * this method is used to handle alert popup by accept it (click on ok button)
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopupByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this metnhod is used to handle the popup by dismiss it()
	 * 
	 * @param driver
	 */
	public void toHandleAlertByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String toHandleAlertPopupAndCaptureText(WebDriver driver) {
		Alert alertPopp = driver.switchTo().alert();
		String popupmsg = alertPopp.getText();
		alertPopp.accept();
		return popupmsg;
	}

	/**
	 * this method is used to take screenshot of webpage
	 * 
	 * @param driver
	 * @param nameOfScreeShot
	 * @throws IOException
	 */
	public String toTakeScreenShot(WebDriver driver, String nameOfScreeShot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File per = new File("./errorShot/" + nameOfScreeShot + ".jpeg");
		FileHandler.copy(temp, per);
		return per.getAbsolutePath();
	}

	/**
	 * 
	 * @param nameOfScreeShot
	 */
	public void toTakeScreenShotOfElement(String nameOfScreeShot) {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File per = new File("./errorShot/" + nameOfScreeShot + ".png");

	}

	/**
	 * this method is used to switch to the child window
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchWindow(WebDriver driver, String partialTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String singleId : allWindows) {
			String titleOfWindow = driver.switchTo().window(singleId).getTitle();
			if (titleOfWindow.contains(partialTitle)) {
				break;
			}

		}

	}

	/**
	 * this method is used to switch back to the parent window
	 * 
	 * @param driver
	 * @param element
	 */
	public void toswitchBackWIndow(WebDriver driver, String partialTitle) {
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
	}

}
