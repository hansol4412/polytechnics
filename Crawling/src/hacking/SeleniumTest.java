package hacking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class SeleniumTest {
 
    public static void main(String[] args) {
 
        try {
         SeleniumTest selTest = new SeleniumTest();
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
    }
 
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\web\\chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest() throws InterruptedException {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        base_url = "http://192.168.23.84:8080/ch7/";
        
        driver.get(base_url);
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/div/span/button")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("/html/body/form/span/button[2]")).click();
        Thread.sleep(1000);
        
        
        driver.findElement(By.xpath("/html/body/form/span/table/tbody/tr[2]/td[2]/input")).sendKeys("하하하");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("/html/body/form/span/table/tbody/tr[4]/td[2]/textarea")).sendKeys("하하하");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("/html/body/form/span/input[1]")).click();
        Thread.sleep(1000);

        
        
    }
 
}