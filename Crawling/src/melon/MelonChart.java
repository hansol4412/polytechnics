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

public class MelonChart {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		try {
			MelonChart melonChart = new MelonChart();
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

	public MelonChart() throws InterruptedException ,ClassNotFoundException, SQLException{
		super();
		
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement stmt = conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		stmt.execute("drop table if exists melon;"); //테이블 삭제
		
		//테이블 생성
		stmt.execute("create table melon("
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

        base_url = "https://www.melon.com/index.htm";
        
        driver.get(base_url);
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/ul[1]/li[1]/a")).click();
        Thread.sleep(1000);
        
        for(int i =1; i<=100; i++) {
        	String title = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr["+i+"]/td[4]/div/div/div[1]")).getText();
        	if (title.contains(",")) {
				title = title.replaceAll(",", "/");
			}
        	if (title.contains("'")) {
				title = title.replaceAll("'", "");
			}
        	String artist = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr["+i+"]/td[4]/div/div/div[2]")).getText();
        	if (artist.contains(",")) {
        		artist = artist.replaceAll(",", "/");
			}
        	if (artist.contains("'")) {
        		artist = artist.replaceAll("'", "");
			}
        	String album = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr["+i+"]/td[5]/div/div/div ")).getText();
        	if (album.contains(",")) {
        		album = album.replaceAll(",", "/");
			}
        	if (album.contains("'")) {
        		album = album.replaceAll("'", "");
			}
        	String str = i+","+title +","+artist+","+album+"\n";
        	
        	String queryTxt;
        	queryTxt = String.format("insert into melon("
					+ "ranking, title, artist, album)"
					+ "values ("
					+ "'%d', '%s', '%s', '%s');",
					i,title, artist, album); //데이터를 삽입하는 쿼리문

			stmt.execute(queryTxt); //저장한 문자열을 이용해 쿼리를 적용한다.
			System.out.println(str);

        }
        stmt.close(); //Statement닫기
		conn.close(); //Connection 연결 끊기

	}

}
