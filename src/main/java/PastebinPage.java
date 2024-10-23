import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//*[@id='qc-cmp2-ui']/div[2]/div/button[2])")
    private WebElement acceptButton;

    @FindBy(xpath = "(//textarea[@id='postform-text'])")
    private WebElement inputFieldCode;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement dropdownContainer;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement option10Minutes;

    @FindBy(xpath = "(//*[@id='postform-name'])")
    private WebElement pasteNameTitle;

    @FindBy(xpath = "(//*[@id='w0']/div[5]/div[1]/div[10]/button)")
    private WebElement submitButton;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
    }

    public void enterCode(String code) {
        inputFieldCode.sendKeys(code);
    }

    public void selectExpiration() {
        dropdownContainer.click();
        wait.until(ExpectedConditions.elementToBeClickable(option10Minutes)).click();
    }

    public void enterPasteName(String name) {
        pasteNameTitle.sendKeys(name);
    }

    public void submitPaste() {
        submitButton.click();
    }
}
