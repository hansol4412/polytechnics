package melon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GenieChart {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		try {
			GenieChart genieChart = new GenieChart();
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

	public GenieChart() throws InterruptedException ,ClassNotFoundException, SQLException{
		super();
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement stmt = conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		stmt.execute("drop table if exists genie;"); //테이블 삭제
		
		//테이블 생성
		stmt.execute("create table genie("
				+ "ranking	integer not null,"
				+ "title	text not null,"
				+ "artist	text not null,"
				+ "album	text not null"
				+ ")DEFAULT CHARSET=utf8;"); 

		 //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        base_url = "https://www.genie.co.kr/chart/top200";
        
        driver.get(base_url);
        Thread.sleep(1000);
        
        for(int i =1; i<=50; i++) {
        	String title = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/table/tbody/tr["+i+"]/td[5]/a[1]")).getText();
        	if (title.contains(",")) {
				title = title.replaceAll(",", "/");
			}
        	if (title.contains("'")) {
				title = title.replaceAll("'", "");
			}
        	String artist = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/table/tbody/tr["+i+"]/td[5]/a[2]")).getText();
        	if (artist.contains(",")) {
        		artist = artist.replaceAll(",", "/");
			}
        	if (artist.contains("'")) {
        		artist = artist.replaceAll("'", "");
			}
        	String album = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/table/tbody/tr["+i+"]/td[5]/a[3]")).getText();
        	if (album.contains(",")) {
        		album = album.replaceAll(",", "/");
			}
        	if (album.contains("'")) {
        		album = album.replaceAll("'", "");
			}
        	String str = i+","+title +","+artist+","+album+"\n";
        	String queryTxt;
        	queryTxt = String.format("insert into genie("
					+ "ranking, title, artist, album)"
					+ "values ("
					+ "'%d', '%s', '%s', '%s');",
					i,title, artist, album); //데이터를 삽입하는 쿼리문

			stmt.execute(queryTxt); //저장한 문자열을 이용해 쿼리를 적용한다.
        	System.out.println(str);
        }
        
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[7]/a[2]")).click();
        
        for(int i =1; i<=50; i++) {
        	String title = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/table/tbody/tr["+i+"]/td[5]/a[1]")).getText();
        	if (title.contains(",")) {
				title = title.replaceAll(",", "/");
			}
        	if (title.contains("'")) {
        		title = title.replaceAll("'", "");
			}
        	String artist = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/table/tbody/tr["+i+"]/td[5]/a[2]")).getText();
        	if (artist.contains(",")) {
        		artist = artist.replaceAll(",", "/");
			}
        	if (artist.contains("'")) {
        		artist = artist.replaceAll("'", "");
			}
        	String album = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/table/tbody/tr["+i+"]/td[5]/a[3]")).getText();
        	if (album.contains(",")) {
        		album = album.replaceAll(",", "/");
			}
        	if (album.contains("'")) {
        		album = album.replaceAll("'", "");
			}
        	String str = (i+50)+","+title +","+artist+","+album+"\n";
        	String queryTxt1;
        	queryTxt1 = String.format("insert into genie("
					+ "ranking, title, artist, album)"
					+ "values ("
					+ "'%d', '%s', '%s', '%s');",
					(i+50),title, artist, album); //데이터를 삽입하는 쿼리문s
        	stmt.execute(queryTxt1); //저장한 문자열을 이용해 쿼리를 적용한다.
        	System.out.println(str);
        }
        stmt.close(); //Statement닫기
		conn.close(); //Connection 연결 끊기

	}

}

