package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PrintMenu {
	public static Scanner std = new Scanner(System.in);
	public static ArrayList<String> printDong = new ArrayList<String>();
	public static ArrayList<String> printApartMent = new ArrayList<String>();
	public static ArrayList<String> printApartMentInformation = new ArrayList<String>();
	public static Iterator<String> iterator; 
	public static LandData ld = new LandData();
	public static CriminalData cd = new CriminalData();
	public static RestaurantData rd = new RestaurantData();
	public static AttractionData ad = new AttractionData();
	public static PrintMenu print = new PrintMenu();
	public static Sort s = new Sort();
	
	//�� ���
	public static void printGu() throws IOException{
		ld.makeLandData();
		for(int i=0; i<ld.getGuA().size(); i++) {
			System.out.println(i+1+". "+ld.getGuA().get(i));
		}
		System.out.print("input name of gu that you want to find -> ");
	}
	
	// �� ���� ���
	public void printInformationGu(String gu) throws IOException{
		cd.makeCriminalData();
		rd.makeRestaurantData();
		ad.makeAttractionData();
		try {
			int guNum = Integer.parseInt(gu);
			System.out.println("# " + ld.getGuA().get(guNum-1) +" # " );
			
			//Attraction data
			for(int i =1; i<ad.getAttractionData().length; i++) {
				if(ad.getAttractionData()[i][0].equals(ld.getGuA().get(guNum-1))) {
					System.out.println("��� : "+ ad.getAttractionData()[i][1] + " , "+ ad.getAttractionData()[i][2] +" , "+ ad.getAttractionData()[i][3] 
							+" , "+ ad.getAttractionData()[i][4] + " , "+ ad.getAttractionData()[i][5]);
				}
			}
			
			//restaurant data
			for(int i =1; i<rd.getRestaurantData().length; i++) {
				if(rd.getRestaurantData()[i][0].equals(ld.getGuA().get(guNum-1))) {
					System.out.println("���� : "+ rd.getRestaurantData()[i][1] + " , "+ rd.getRestaurantData()[i][2] +" , "+ rd.getRestaurantData()[i][3] 
							+" , "+ rd.getRestaurantData()[i][4] + " , "+ rd.getRestaurantData()[i][5]);
				}
			}
			
			//criminal data
			for(int i =1; i<cd.getCriminalData().length; i++) {
				if(cd.getCriminalData()[i][0].equals(ld.getGuA().get(guNum-1))) {
					System.out.println("���� : "+ cd.getCriminalData()[i][1] + "ȸ, ���� : "+ cd.getCriminalData()[i][2] +"ȸ, ���� : "+ cd.getCriminalData()[i][3] 
							+"ȸ, ���� : "+ cd.getCriminalData()[i][4] + "ȸ, ���� : "+ cd.getCriminalData()[i][5] + "ȸ, ������ : "+ cd.getCriminalData()[i][6]+"ȸ  (�ֱ� 3�� ��, �� ��� �߻� ��� �Ǽ�)");
				}
			}
		}catch(Exception e) {
			System.out.println("# Check number of Gu #");
			//printGu();
		}
		
	}
	
	public void printDong(String gu) throws IOException{
		ld.makeLandData();
		int guNum = Integer.parseInt(gu);
		iterator = ld.getGudongA().iterator();
		int flag = 0;
		while(iterator.hasNext()) {
			String a = iterator.next();
			if(a.contains(ld.getGuA().get(guNum-1))) {
				flag =1;
				String[] selectDong = a.split(" ");
				printDong.add(selectDong[1]);
			} else {
				continue;
			}
		}
		
		if(flag==0) {
			System.out.println("please check name of Gu");
		} else {
			for(int i=0; i<printDong.size(); i++) {
				System.out.println(i+1+". "+printDong.get(i));
			}
			System.out.print("input name of dong that you want to find -> ");
		}
	}
	
	public void printApartment(String dong) throws IOException{
		ld.makeLandData();
		int dongNum = Integer.parseInt(dong);
		System.out.println("# " + printDong.get(dongNum-1) +" # " );
		System.out.println("S: if you want to sort on the basis");
		System.out.println("F: if you want to find information of apartment ");
		System.out.print("->");
		String sort = std.next();
		
		if(sort.equals("s")||sort.equals("S")) {
			System.out.println("#Criteria \r\n"
					+ "1.��ܰ� ���� �� "
					+ "2.��ܰ� ���� �� "
					+ "3.����� ���� �� "
					+ "4.����� ���� �� "
					+ "5.����ö�� ����� ��"
			);
			System.out.print("->");
			String sortNum = std.next();
			s.sort(printDong.get(dongNum-1),sortNum);
			printApartment(dong);
		} else {
			int flag = 0;
			for(int i=1; i<ld.getLandData().length; i++) {
				if(ld.getLandData()[i][0].contains(printDong.get(dongNum-1))) {
					flag=1;
				} else {
					continue;
				}
			}
			if(flag==0) {
				System.out.println("please check name of Dong");
			} else {
				System.out.print("input name of apartment that you want to find ->");
			}
		}
	}
	
	public void printInformationApart(String dong, String apart) throws IOException{
		ld.makeLandData();
		ArrayList<SortData> sd = s.getList();
		
		int flag = 0;
		int dongNum = Integer.parseInt(dong);
				
		try { // search for information of apartment by list number after sort
			
			for(int i=0; i<sd.size(); i++) {
				printApartMentInformation.add(sd.get(i).getName());
			}
			
			String apartName = sd.get(Integer.parseInt(apart)-1).getName();
				
			for(int i=1; i<ld.getLandData().length; i++) {
				if(ld.getLandData()[i][0].contains(printDong.get(dongNum-1)) && ld.getLandData()[i][1].contains(apartName)) {
					flag=1;
					System.out.println("����Ʈ ��: " + ld.getLandData()[i][1]);
					if(ld.getLandData()[i][2].equals("0") || ld.getLandData()[i][2].equals("")) {
						System.out.println("��ܰ�: ������ �����ϴ�");
					} else {
						System.out.println("��ܰ�: " + ld.getLandData()[i][2]+"����");
					}
					if(ld.getLandData()[i][3].equals("0") || ld.getLandData()[i][2].equals("")) {
						System.out.println("�����: ������ �����ϴ�");
					} else {
						System.out.println("�����: " + ld.getLandData()[i][3]+"����");
					}
					System.out.println("��������: " + ld.getLandData()[i][4]);
					
					if(ld.getLandData()[i][5].equals("0") || ld.getLandData()[i][5].equals("")) {
						System.out.println("���� ������: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("���� ������: " + ld.getLandData()[i][5]+"m");
					}
					
					if(ld.getLandData()[i][6].equals("0") || ld.getLandData()[i][6].equals("")) {
						System.out.println("����ö��: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("����ö��: " + ld.getLandData()[i][6]+"m");
					}
					
					if(ld.getLandData()[i][7].equals("0") || ld.getLandData()[i][7].equals("")) {
						System.out.println("�����: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("�����: " + ld.getLandData()[i][7]+"m");
					}
					
					if(ld.getLandData()[i][8].equals("0")|| ld.getLandData()[i][8].equals("")) {
						System.out.println("��ġ��: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("��ġ��: " + ld.getLandData()[i][8]+"m");
					}
					
					if(ld.getLandData()[i][9].equals("0") || ld.getLandData()[i][9].equals("")) {
						System.out.println("�б�: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("�б�: " + ld.getLandData()[i][9]+"m");
					}
					
					if(ld.getLandData()[i][10].equals("0") || ld.getLandData()[i][10].equals("")) {
						System.out.println("��Ʈ: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("��Ʈ: " + ld.getLandData()[i][10]+"m");
					}
					
					System.out.println("--------------------------------------------------------------------------------------------------------------------------");
					
					printApartment(dong);
					String selectapartment = std.next();
					print.printLine();
					print.printInformationApart(dong, selectapartment);
					
				} else {
					continue;
				}
			}
			
		} catch(Exception e) { // search for information of apartment by apart's name 
			
			String apartName = apart;
			for(int i=1; i<ld.getLandData().length; i++) {
				if(ld.getLandData()[i][0].contains(printDong.get(dongNum-1)) && ld.getLandData()[i][1].contains(apartName)) {
					flag=1;
					System.out.println("����Ʈ ��: " + ld.getLandData()[i][1]);
					System.out.println("��ܰ�: " + ld.getLandData()[i][2]+"����");
					if(ld.getLandData()[i][2].equals("0") || ld.getLandData()[i][2].equals("")) {
						System.out.println("��ܰ�: ������ �����ϴ�");
					} else {
						System.out.println("��ܰ�: " + ld.getLandData()[i][2]+"����");
					}
					if(ld.getLandData()[i][3].equals("0") || ld.getLandData()[i][2].equals("")) {
						System.out.println("�����: ������ �����ϴ�");
					} else {
						System.out.println("�����: " + ld.getLandData()[i][3]+"����");
					}
					System.out.println("��������: " + ld.getLandData()[i][4]);
					if(ld.getLandData()[i][5].equals("0") || ld.getLandData()[i][5].equals("")) {
						System.out.println("���� ������: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("���� ������: " + ld.getLandData()[i][5]+"m");
					}
					
					if(ld.getLandData()[i][6].equals("0")|| ld.getLandData()[i][6].equals("")) {
						System.out.println("����ö��: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("����ö��: " + ld.getLandData()[i][6]+"m");
					}
					
					if(ld.getLandData()[i][7].equals("0")|| ld.getLandData()[i][7].equals("")) {
						System.out.println("�����: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("�����: " + ld.getLandData()[i][7]+"m");
					}
					
					if(ld.getLandData()[i][8].equals("0")|| ld.getLandData()[i][8].equals("")) {
						System.out.println("��ġ��: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("��ġ��: " + ld.getLandData()[i][8]+"m");
					}
					
					if(ld.getLandData()[i][9].equals("0")|| ld.getLandData()[i][9].equals("")) {
						System.out.println("�б�: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("�б�: " + ld.getLandData()[i][9]+"m");
					}
					
					if(ld.getLandData()[i][10].equals("0")|| ld.getLandData()[i][10].equals("")) {
						System.out.println("��Ʈ: 1km�̳��� �����ϴ�.");
					} else {
						System.out.println("��Ʈ: " + ld.getLandData()[i][10]+"m");
					}
				} else {
					continue;
				}
			}
		}

		if(!(apart.equals("s")||apart.equals("S")) && flag ==0) {
			System.out.println("please check name of Apartment");
		} 
	}
	
	public void printLine() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void printDot() {
		System.out.println("..........................................................................................................................");
	}
	
}
	