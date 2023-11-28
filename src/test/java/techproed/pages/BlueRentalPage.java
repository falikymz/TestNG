package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {
    public BlueRentalPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li//a[@role='button']")
    public WebElement loginButton;

    @FindBy (id = "formBasicEmail")
    public WebElement emailBox;

    @FindBy  (id = "formBasicPassword")
    public WebElement passwordBox;

    @FindBy  (id = "dropdown-basic-button")
    public WebElement loginverify;

    @FindBy(xpath = "//*[contains(text(),'User with email fake@bluerentalcars.com not found')]")
    public WebElement negativeLoginVerify;

}
