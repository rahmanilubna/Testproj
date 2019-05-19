package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class OrderSummaryPage extends TestBase{
	@FindBy(css = "[title = 'Proceed Checkout']")
	WebElement ProceedCheckOut;
	
	@FindBy(css = "[title='Process Address']")
	WebElement processAddressButton;
	
	@FindBy(css = "[title='processCarrierButton']")
	WebElement processCarrierButton;
	
	@FindBy(css = "[title = 'Terms and conditions']")
	WebElement TermsAndConditions;
	
	@FindBy(css = "[title = 'pay by bank wire']")
	WebElement PaybyBankWire;
	
	@FindBy(css = "[title = 'Confirm order']")
	WebElement ConfirmOrder;
	
	@FindBy(css = "[title = 'Order Confirm']")
	WebElement OrderConfirm;

public OrderSummaryPage(){
	PageFactory.initElements(driver, this);
}
public OrderSummaryPage proceedCheckout(){
	ProceedCheckOut.click();
	return this;
}
public OrderSummaryPage processAddressButton(){
	processAddressButton.click();
	return this;
}
public OrderSummaryPage processCarrierButton(){
	TermsAndConditions.click();
	processCarrierButton.click();
	return this;
	
}
public OrderSummaryPage ConfirmOrder(){
	PaybyBankWire.click();
	ConfirmOrder.click();
	return this;
	
}
public String getConfirmationMessage(){
	return OrderConfirm.getText();
}


}

