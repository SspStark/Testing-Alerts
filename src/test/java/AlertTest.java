import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    public static void main(String args[]) {
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "D:\\sspto\\Downloads1\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

            // Launch the Chrome browser
            WebDriver driver = new ChromeDriver();

            // Open the Jobby App login page
            driver.get("https://qajobbyapp.ccbp.tech/login");

            // Locate username field
            WebElement usernameEl = driver.findElement(By.cssSelector("input#userNameInput"));
            usernameEl.sendKeys("rahul");

            // Locate password field
            WebElement passwordEl = driver.findElement(By.cssSelector("input#passwordInput"));
            passwordEl.sendKeys("rahul@2021");


            // Locate submit button
            WebElement buttonEl = driver.findElement(By.cssSelector("button.login-button"));
            buttonEl.submit();

            // Define the expected URL of the home page
            String expectedUrl = "https://qajobbyapp.ccbp.tech/";

            // Wait for the expected URL to be loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            // Get the current URL after login
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Navigation to home page is successful!");
            }

            // Locating logout button
            WebElement logoutButton = driver.findElement(By.className("logout-desktop-btn"));
            logoutButton.click();

            // Switch control to alert
            Alert confirmationAlert = driver.switchTo().alert();
            // Get the alert text
            System.out.println(confirmationAlert.getText());

            //Accept the alert and logout of the application
            confirmationAlert.accept();

            String loginUrl = "https://qajobbyapp.ccbp.tech/login";
            // Wait for the expected URL to be loaded
            wait.until(ExpectedConditions.urlToBe(loginUrl));

            // Get the current URL after logout
            currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(loginUrl)) {
                System.out.println("Logout is successful and page is redirected to login page!");
            }

            //Close the browser
            driver.quit();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}