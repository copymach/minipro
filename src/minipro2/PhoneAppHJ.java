package minipro2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneAppHJ {


	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new FileReader("C:\\javaStudy\\workspace\\minipro\\PhoneDBHJ.txt"));
		PhoneAppHJ.makeList(br);
		
		Scanner sc= new Scanner(System.in);
		boolean action= true;

		PhoneAppHJ.opening();
		
		while(action) {
			PhoneAppHJ.menu();
			int order= sc.nextInt();
			
			switch(order) {
				case 1: 
					PhoneAppHJ.showList();
					break;
	
				case 2:
					PhoneAppHJ.enroll();
					PhoneAppHJ.reWrite();
					break;
					
				case 3:
					PhoneAppHJ.delete();
					PhoneAppHJ.reWrite();
					break;
					
				case 4:
					PhoneAppHJ.search();
					break;
					
				case 5: 
					PhoneAppHJ.closing();
					action= false;
					break;
					
				default :
					System.out.println("[다시 입력해 주세요.]");
					break;
			}
		}
		
		sc.close();
	}
	
	static List<Person> pList= new ArrayList<Person>();
	
	public static void opening() {
		System.out.println("*********************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("*********************************");		
	}
	
	public static void menu() {
		System.out.println("");
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("---------------------------------");
		System.out.print(">메뉴번호: ");
	}
	
	public static void closing() {
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("*            감사합니다            *");
		System.out.println("*********************************");
	}
	
	public static void makeList(BufferedReader br) throws IOException {		
		while(true) {
			String line= br.readLine();
			if(line==null) {
				break;
			}
			String[] info= line.split(",");
			pList.add(new Person(info[0], info[1], info[2]));	
		}
	}
	
	public static void showList() {
		System.out.println("<1.리스트>");
		for(Person p: pList) {
			System.out.print(pList.indexOf(p)+1+".  ");
			p.showInfo();
		}
	}
	
	public static void enroll() {	
		Scanner ent= new Scanner(System.in); // ent 스캐너를 여기서 닫으면 오류발생
		String name, hp, company;
		
		System.out.println("<2.등록>");
		System.out.print(">이름: ");
		name= ent.nextLine();
		System.out.print(">휴대전화: ");
		hp= ent.nextLine();
		System.out.print(">회사전화: ");
		company= ent.nextLine();
		System.out.println("[등록되었습니다.]");
		
		pList.add(new Person(name, hp, company));
	}
	
	public static void reWrite() throws IOException {
		BufferedWriter bw= new BufferedWriter(new FileWriter("C:\\javaStudy\\workspace\\minipro\\PhoneDBHJ.txt"));
		for(Person p: pList) {
			bw.write(p.save());
			bw.newLine();
		}
		bw.close();
	}
	
	public static void delete() {
		Scanner ent= new Scanner(System.in);
		
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		int index= ent.nextInt();
		pList.remove(index-1);
		System.out.println("[삭제되었습니다.]");
	}
	
	public static void search() {
		Scanner ent= new Scanner(System.in);
		System.out.println("<4.검색>");
		System.out.print(">이름: ");
		String search= ent.nextLine();
		
		for(Person p: pList) {
			if(p.getName().contains(search)) {
				System.out.print(pList.indexOf(p)+1+".  ");
				p.showInfo();
			}
		}
	}
}
	

