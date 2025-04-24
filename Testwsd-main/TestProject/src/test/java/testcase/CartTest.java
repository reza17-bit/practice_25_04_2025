package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {
    @Test()
    public static void AddRemoveitemsCart() throws InterruptedException {
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        // Navigate to a product page
        WebElement searchBar = driver.findElement(By.xpath(loc.getProperty("search_bar")));
        searchBar.sendKeys("Orestes Fitness Short");
        searchBar.submit();

        // Select product options (e.g., size, color)
        WebElement sizeOption = driver.findElement(By.xpath(loc.getProperty("size")));
        sizeOption.click();
        WebElement colorOption = driver.findElement(By.xpath(loc.getProperty("color")));
        colorOption.click();

        // Add the product to the cart
        driver.findElement(By.xpath(loc.getProperty("addtocart"))).click();
        Thread.sleep(3000);
        // Verify the product appears in the cart
        WebElement cart = driver.findElement(By.xpath(loc.getProperty("cart")));
        cart.click();
        WebElement cartItem = driver.findElement(By.xpath(loc.getProperty("cartitem")));
        Thread.sleep(2000);
        if (cartItem.getText().contains("Orestes Fitness Short")) {
            System.out.println("Product successfully added to the cart.");
        } else {
            System.out.println("Product not added to the cart.");
        }

        // Navigate to the cart page and confirm product details
        WebElement viewCartButton = driver.findElement(By.xpath(loc.getProperty("viewcart")));
        viewCartButton.click();
        WebElement cartDetails = driver.findElement(By.xpath(loc.getProperty("cartdetails")));
        WebElement cartSize = driver.findElement(By.xpath(loc.getProperty("cartsize")));
        WebElement cartColor = driver.findElement(By.xpath(loc.getProperty("cartcolor")));
        WebElement itemValue = driver.findElement(By.xpath(loc.getProperty("itemvalue")));
        if (cartDetails.getText().contains("Orestes Fitness Short") && cartSize.getText().contains("34") && cartColor.getText().contains("Blue") && itemValue.getText().contains("$35.00")) {
            System.out.println("Product details are correct in the cart.");
        } else {
            System.out.println("Product details are incorrect in the cart.");
        }
    }
    }