package techpored.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techpored.utilities.Driver;

public class OpenSourcePage {
    public OpenSourcePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @FindBy(xpath = "//h6")
    public WebElement dashBoard;

}
