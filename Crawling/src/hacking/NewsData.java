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

public class NewsData {
	public static void main(String[] args) {
		try {
			NewsData newsData = new NewsData();
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

	public NewsData() throws InterruptedException {
		super();

		// System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// Driver SetUp
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		
		Page pagelist = new Page();

		for (int j = 4; j < pagelist.pagelist.length; j++) {
			
			base_url = pagelist.pagelist[j][1];

			driver.get(base_url);
			Thread.sleep(1000);

			int newsPage = 0;
			
			for(int i =1; i<15; i++) {
				try {
					if(driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li["+i+"]/a")).getText().equals("대학소개")||
					   driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li["+i+"]/a")).getText().equals("교육원소개")	) {
						//System.out.println(driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li["+i+"]/a")).getText());
						newsPage=i;
					}
				} catch (org.openqa.selenium.ElementClickInterceptedException e) {
					break;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}
			}

			// System.out.println(driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li["+(newsPage-1)+"]/a")).getText());

			driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li[" + newsPage  + "]/a")).click();
			Thread.sleep(300);

			int newPage2 = 0;

			for (int i = 1; i < 10; i++) {
				try {
					// System.out.println(driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li["+(newsPage-1)+"]/div/ul/li[4]/ul/li["+i+"]/a")).getText());
					if (driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li["+ newsPage + "]/div/ul/li[4]/ul/li[" + i + "]/a")).getText().equals("언론보도")) {
						newPage2 = i;
					}
				} catch (org.openqa.selenium.ElementClickInterceptedException e) {
					break;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}
			}

			// System.out.println(newPage2);

			driver.findElement(By.xpath("/html/body/div[2]/article/header/div[3]/form/ul/li[" + newsPage+ "]/div/ul/li[4]/ul/li[" + newPage2 + "]/a")).click();
										 ///html/body/div[2]/article/header/div[3]/form/ul/li[8]/				div/ul/li[5]/ul/li[2]/a
			Thread.sleep(300);

			String str = null;

			int page = 0;

			driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/div[2]/a[10]")).click(); // 처음페이지에서 들어가면 규칙성 안맞음 한번 다른데 찍고 넘어가기
			loop: while (true) {
				try {
					for (int p = 4; p <= 13; p++) {
						page++;
						System.out.println(page);
						driver.findElement(
								By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/div[2]/a[" + p + "]"))
								.click();
						if (page == 2 && p == 5) {
							driver.findElement(
									By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/div[2]/a[5]"))
									.click();
						}
						try {
							for (int i = 1; i <= 10; i++) {
								String title = driver.findElement(By.xpath(
										"/html/body/div[2]/article/div[1]/section[2]/div/div[3]/form/table/tbody/tr["
												+ i + "]/td[2]"))
										.getText();
								String date = driver.findElement(By.xpath(
										"/html/body/div[2]/article/div[1]/section[2]/div/div[3]/form/table/tbody/tr["
												+ i + "]/td[3]"))
										.getText();
								if (title.contains(",")) {
									title = title.replaceAll(",", "/");
								}

								str = pagelist.pagelist[j][0]+"," + title + "," + date + "\n";
								System.out.print(str);
								// writeF.write(str);
							}
						} catch (org.openqa.selenium.NoSuchElementException e) {
							break loop;
						}
						Thread.sleep(1000);
					}
					driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[3]/div[2]/a[15]"))
							.click();
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}
			}
		}

	}

}
