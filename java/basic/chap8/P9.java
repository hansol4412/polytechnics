package chapter8;

import java.util.Scanner;

public class P9 extends Thread{
	// 달리기하기
	public static void main(String[] args) throws InterruptedException {
		Scanner std = new Scanner(System.in);
		System.out.print("input n: ");
		int n = std.nextInt();
		Thread[] thread = new Thread[n];
		for(int i=0; i<n; i++) {
			thread[i] = new Runner("[ Thread "+(i+1)+" ]");
			thread[i].start();
		}
	}
}
class Runner extends Thread{
	public Runner (String threadName) {
		this.setName(threadName);
	}
	public void run() {
		try {
			int sum=0;
			int second=0;
			while(true) {
				if(sum>=50) break;
				int n = (int)(Math.random()*10);
				sum+=n;
				second++;
				System.out.println(this.getName()+"-"+sum+" ----------"+second);
				Thread.sleep(1000);
			}
			System.out.println(this.getName()+"Finished!!!  second-"+second);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}