package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductValidate extends BaseTest {
    @Test()
    public static void ValidateTest() throws InterruptedException {

        WebElement searchBar = driver.findElement(By.xpath(loc.getProperty("search_bar")));
        searchBar.sendKeys("Fusion");
        searchBar.submit();

        // Verify that the results page displays relevant products
        WebElement results = driver.findElement(By.cssSelector(loc.getProperty("result")));
        if (results.getText().contains("Fusion")) {
            System.out.println("Search results are relevant.");
        } else {
            System.out.println("Search results are not relevant.");
        }

    }
}
