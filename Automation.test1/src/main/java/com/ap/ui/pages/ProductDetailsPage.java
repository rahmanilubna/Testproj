package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPage extends TestBase{
	@FindBy(css="[title=T-shirts]")
	WebElement tshirts;
	
	@FindBy(css="[title='replace-2x img-responsive']")
	WebElement image;
	
	@FindBy(id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(id="group_1")
	WebElement sizeDropDown;
	
	@FindBy(css="[id='add_to_cart'] button")
	WebElement addCartButton;
	
	@FindBy(css = "[title='Proceed to checkout']")
	WebElement proceedCheckout;
	
	@FindBy(css = "[title='Add to my wishlist]")
	WebElement addToWishListButton;
	
	@FindBy(css = "[title='Add wishlist message']")
	WebElement addWishListMsg;
	
	@FindBy(css = "[class = 'fancybox-item fancybox-close']")
	WebElement addWishListMsgCloseButton;
	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	public void verifyAddWishListMsg(){
		Assert.assertEquals(addWishListMsg.getText(), "Added to your wishlist.");
		addWishListMsgCloseButton.click();
	}
	public ProductDetailsPage selectProductColor(String color){//concatinating(+)color(change value of color; dynamic)
		String locator = "[name='"+color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	public ProductDetailsPage selectQuality(CharSequence[] quantity){
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;//when there will repeatable steps in your script
		
	}
	public ProductDetailsPage selectSize(String size){
		Select select = new Select(sizeDropDown);
		select.selectByVisibleText(size);
		return this;
	}
	public ProductDetailsPage clickAddCart(){
		addCartButton.click();
		return this;
	}
	public ProductDetailsPage clickAddWishListButton(){
		addToWishListButton.click();
		return this;//goes back to main class 
		
	}
	public OrderSummaryPage proceedCheckOut(){
		proceedCheckout.click();
		return new OrderSummaryPage();
	}
	
	
	

}
