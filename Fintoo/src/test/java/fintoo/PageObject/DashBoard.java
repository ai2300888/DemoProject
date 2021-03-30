package fintoo.PageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	public WebDriver driver;
	By startPlan = By.xpath("//a[text()='Start a Plan']");
	By applyCombo =By.id("applyOffer_110");
	By applyFintoo =By.id("applyOffer_111");
	By viewOffer = By.xpath("//a[text()='View Offers']");
	By addToCart_FPButton= By.xpath("(//div[@class='col-md-4']/following::button[text()='Add to cart'])[1]");
	By addToCart_RPButton= By.xpath("(//div[@class='col-md-4']/following::button[text()='Add to cart'])[3]");
	By startMyPlanCombo =By.xpath("//button[text()='Start my plan']");
	By startMyPlanSingle =By.xpath("//a[text()='Start my plan']");
	public By deleteItem_Cart=By.xpath("//a[@class='delete' and @ng-click='removeItemCartPlan(c)']");
	By deleteOffer_Cart=By.xpath("(//a[@class='delete'])[2]");
	By myPlan = By.xpath("//span[text()='My plans']");
	public By inVoice = By.xpath("//span[text()='Invoice']");
	public By downloadFirstInvoicePdf =By.xpath("(//img[@class='download-icon'])[1]");
	public By firstContinueButton = new By.ByXPath("(//a[text()='Continue'])[1]");
		
	
	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public boolean genericClick(WebDriver driver, By elementToBeClicked)
	{

	    try{

	     driver.findElement(elementToBeClicked).click();

	     return true;
	}
	catch(Exception e){

	     return false;
	}

	}

	
	public void clickStartPlan() {
		driver.findElement(startPlan).click();
	}
	
	public void clickFP_AddCart() {
		driver.findElement(addToCart_FPButton).click();;
	}
	
	public void clickRP_AddCart() {
		driver.findElement(addToCart_RPButton).click();;
	}
	
	public void clickApplyFintooOffer() {
		driver.findElement(applyFintoo).click();
	}
	
	public void clickApplyComboOffer() {
		driver.findElement(applyCombo).click();
	}
	
	public void clickStartMyPlan() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		while(!(driver.findElement(startMyPlanCombo).isDisplayed() ||driver.findElement(startMyPlanSingle).isDisplayed())) {
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);}
		Thread.sleep(2000);
		if(driver.findElement(startMyPlanCombo).isDisplayed()) {
		driver.findElement(startMyPlanCombo).click();}
		
		if(driver.findElement(startMyPlanSingle).isDisplayed()) {
		driver.findElement(startMyPlanSingle).click();}
	}
	
	
	
}
