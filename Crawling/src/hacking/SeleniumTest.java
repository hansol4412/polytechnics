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

        base_url = "https://www.kopo.ac.kr/ctc/index.do";
        
        driver.get(base_url);
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/div[2]/article/header/div[1]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        
        
    }
 
}