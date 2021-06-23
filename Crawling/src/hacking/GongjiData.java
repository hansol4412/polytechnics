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

public class GongjiData {
	public static void main(String[] args) throws IOException{
		try {
			GongjiData gongjiData = new GongjiData();
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

	public GongjiData() throws InterruptedException, IOException {
		super();
		
		File file = new File("gongji.csv");
    	BufferedWriter writeF = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gongji.csv",true), "euc-kr"));

		// System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// Driver SetUp
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		PageG pagelist = new PageG();

		for (int j = 31; j < pagelist.pagelist.length; j++) {

			base_url = pagelist.pagelist[j][1];
			driver.get(base_url);

			Thread.sleep(1000);
			
			try {
				driver.findElement(By.xpath("/html/body/div[2]/article/div[2]/div/div[2]/section/div[1]/div[1]/a")).click();
			}catch(org.openqa.selenium.NoSuchElementException e) {
				driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/div/div[2]/section/div[1]/div[1]/a")).click();
			}
			
			Thread.sleep(1000);

			String str = null;
			int page = 0;
			driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/div[2]/a[5]")).click(); // 처음페이지에서 규칙성 안맞음 다른 곳 찍고 들어가기
																															

			loop: while (true) {
				try {
					for (int p = 4; p <= 13; p++) {
						page++;
						System.out.println(page);
						driver.findElement(
								By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/div[2]/a[" + p + "]"))
								.click();
						if (page == 2 && p == 5) {
							driver.findElement(
									By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/div[2]/a[5]"))
									.click();
						}
						try {
							for (int i = 1; i <= 10; i++) {
								String title = driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/form/table/tbody/tr["+ i + "]/td[2]")).getText();
								if (title.contains(",")) {
									title = title.replaceAll(",", "/");
								}
								String writer = driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/form/table/tbody/tr["+ i + "]/td[3]")).getText();
								String date = driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/form/table/tbody/tr["+ i + "]/td[4]")).getText();
								String urlPath = driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/form/table/tbody/tr["+ i + "]/td[2]/span/a")).getAttribute("href");
								if (urlPath.contains("#")) {
									urlPath = urlPath.replace("#", "&");
								}
								String urlNum = driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/form/table/tbody/tr["+ i + "]/td[2]/span/a")).getAttribute("onclick");
								String url = urlPath+"mode=view&post="+urlNum.substring(17, 23);
								
								str = pagelist.pagelist[j][0] + "," + title + "," + writer + "," + date + "," + url + "\n";
								System.out.print(str);
								writeF.write(str);
							}
						} catch (org.openqa.selenium.NoSuchElementException e) {
							break loop;
						}
						Thread.sleep(1000);
					}
					driver.findElement(By.xpath("/html/body/div[2]/article/div[1]/section[2]/div/div[4]/div[2]/a[15]"))
							.click();
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}
			}
		}
		writeF.close();

	}

}
