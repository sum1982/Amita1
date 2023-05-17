/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kohli
 */
public class AmitaTest {

    WebDriver driver;

    public AmitaTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://healthcare.ascension.org/");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void amita() throws Exception {

        driver.findElement(By.xpath("//a[@title='Find a Location']")).click();
//        String title = driver.getTitle();
//        System.out.println("1st title" + title);
driver.findElement(By.xpath("//div[@class='icon']")).click();
//        Thread.sleep(2000);
        
//        driver.findElement(By.xpath("//input[@class='location-input js-search-query']")).click();
//        driver.findElement(By.xpath("//input[@class='location-input js-search-query']")).clear();
//Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='location-input js-search-query']")).sendKeys(AmitaUtil.getData().getCitystatezip());
         Thread.sleep(2000);
//         driver.findElement(By.xpath("//button[@class='js-search-btn button-primary']"));
        driver.findElement(By.xpath("//a[contains(text(),'Physical Therapy')]")).click();

//driver.findElement(By.xpath("//*[@id=\"locationsSearchContainer\"]/div/div[2]/div[1]/div/div/div/div/div[3]/div/input")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");

//WebElement SubmitButton=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Ascension Medical Group Illinois - Heart & Vascula')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Ascension Medical Group Illinois - Heart & Vascula')]")).click();
        String title1 = driver.getTitle();
        System.out.println(title1);

    }

}
