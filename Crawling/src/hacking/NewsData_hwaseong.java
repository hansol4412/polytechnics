package hacking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewsData_hwaseong {
	public static void main(String[] args) throws IOException{
		try {
			NewsData_hwaseong newsData_hwaseong = new NewsData_hwaseong();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// WebDriver
	private WebDriver driver;

	// Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\web\\chromedriver.exe";

	// 크롤링 할 URL
	private String base_url;

	public NewsData_hwaseong() throws InterruptedException , IOException{
		super();
		File file = new File("news.csv");
    	BufferedWriter writeF = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("news.csv",true), "euc-kr"));

		// System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// Driver SetUp
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		Page pagelist = new Page();
		base_url = "https://www.kopo.ac.kr/hwaseong/board.do?menu=7097";
		

		driver.get(base_url);
		Thread.sleep(1000);

		int newsPage = 0;

		Thread.sleep(300);
		String str = null;

		int page = 0;
		loop: while (true) {
			try {
				for (int p = 1; p <= 10; p++) {
					page++;
					System.out.println(page);
					if(p==3) {
						driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/div[2]/a[4]")).click();
					} else {
						driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/div[2]/a[" + p + "]")).click();
					}
					try {
						for (int i = 1; i <= 10; i++) {
							String title = driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/form/table/tbody/tr["+ i + "]/td[2]"))
									.getText();
							String date = driver.findElement(By.xpath(
									"/html/body/div[2]/article/div[1]/section[2]/div/div[3]/form/table/tbody/tr["
											+ i + "]/td[3]"))
									.getText();
							if (title.contains(",")) {
								title = title.replaceAll(",", "/");
							}
							String pageURL = driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/form/table/tbody/tr[" + i + "]/td[2]/span/a")).getAttribute("href");
							str = "화성캠퍼스"+"," + title + "," + date+ "," + pageURL + "\n";
							System.out.print(str);
							 writeF.write(str);
						}
					} catch (org.openqa.selenium.NoSuchElementException e) {
						break loop;
					}
					Thread.sleep(1000);
				}
				//driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/div[2]/a[15]")).click();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				break;
			}
		}
		writeF.close();
	}

}



