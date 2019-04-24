import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver = new ChromeDriver();
    
   /*Removed Page Obejct Model and made all three test classes look similar*/

    @Test
    public void shouldBeAbleToSearchForHotels() {
        
    	setDriverPath();
    	
        driver.get("https://www.cleartrip.com/");
        
        driver.findElement(By.linkText("Hotels")).click();
       

        driver.findElement(By.id("Tags")).sendKeys("Indiranagar, Bangalore");

        new Select(driver.findElement(By.id("travellersOnhome"))).selectByVisibleText("1 room, 2 adults");
        driver.findElement(By.id("SearchHotelsButton")).click();

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
