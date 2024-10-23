import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/irene/igor/Epam/chromedriver_mac64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://pastebin.com/");

            PastebinPage pastebinPage = new PastebinPage(driver);

            pastebinPage.acceptCookies();
            pastebinPage.enterCode("Hello from WebDriver");
            pastebinPage.selectExpiration();
            pastebinPage.enterPasteName("helloweb");
            pastebinPage.submitPaste();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
