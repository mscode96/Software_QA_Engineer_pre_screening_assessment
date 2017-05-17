import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PropertyfinderTest{
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setup(){

        //use FF Driver
        driver = new FirefoxDriver();
        baseUrl = "https://www.propertyfinder.ae";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void UserTest() throws InterruptedException {

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath(".//*[@id='search-form-property']/div[3]/div[2]/div/button")).click();
        driver.findElement(By.cssSelector(".selected")).click();
        driver.findElement(By.cssSelector(".typeahead.tt-input")).click();
        driver.findElement(By.cssSelector(".typeahead.tt-input")).sendKeys("marina");
        driver.findElement(By.xpath(".//*[@id='search-form-property']/div[3]/div[1]/span/div/div/div[1]")).click();
        driver.findElement(By.xpath(".//*[@id='search-form-property']/div[4]/div/div[1]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[2]")).click();
        driver.findElement(By.xpath(".//*[@id='price_group']/div[1]/div/button")).click();
        driver.findElement(By.xpath("//div[@id='price_group']/div[1]/div/div/ul/li[2]")).click();
        driver.findElement(By.cssSelector("#bedroom_group > div.pure-u-1-2 > div.ms-parent > button.ms-choice")).click();
        driver.findElement(By.xpath("//div[@id='bedroom_group']/div/div/div/ul/li[4]")).click();
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();


        WebElement ResultPage = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("serp")));

        List<WebElement> webElements = driver.findElements(By.xpath(".//*[@data-gtm-ecommerce=\"Serp\"]"));
        webElements.get(webElements.size() - 1).click();

        Assert.assertEquals("2", driver.findElement(By.xpath(".//*[@id='property-facts']/table/tbody/tr[4]/td")).getText());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
