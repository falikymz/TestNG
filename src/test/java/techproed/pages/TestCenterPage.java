package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterPage {

    public TestCenterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(id = "exampleInputEmail1")
   public WebElement usernameBox;

    @FindBy(id = "exampleInputPassword1")
    public WebElement passwordBox;

    @FindBy(xpath = "//button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()=' Logout']")
    public  WebElement logoutButton;
}
