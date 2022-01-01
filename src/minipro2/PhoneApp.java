package minipro2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new FileReader("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt"));
		PhoneApp.addList(br);
		PhoneApp.begin();
		Scanner sc = new Scanner(System.in);
		
		boolean loop= true;
		
		while(loop) {
			PhoneApp.menu();
			int order = sc.nextInt();
			
			switch(order) {
				case 1 : //1.리스트
					PhoneApp.printList();
					break;
					
				case 2 : //2.등록
					PhoneApp.add(); //폰번호를 입력받고
					PhoneApp.modify(); // PhoneDB파일에 저장한다
					break;
					
				case 3 : //3.삭제
					PhoneApp.delete(); //삭제할 번호를 입력받고
					PhoneApp.modify(); // PhoneDB파일에 저장한다
					break;
					
				case 4 : //4.검색
					PhoneApp.search();
					break;
					
				case 5 : //5.종료
					PhoneApp.end();
					loop = false; // 이거 안넣으면 반복 안끝남					
					break;
					
				default :
					System.out.println("다시 입력해 주세요.");
					break;
			} //switch종료
			
		} // while 종료
		
	sc.close(); // 반복이 끝나면 스캐너 종료
	
	} // main 종료
	
//	전번이 들어가는 배열
	static List<Person> pArray= new ArrayList<Person>();
	
	public static void begin() {
		System.out.println("------------------");
		System.out.println("전번 관리 프로그램");
		System.out.println("------------------");
	} //begin 종료
	
	public static void menu() {
		System.out.println("");
		System.out.println("1.리스트 \t 2.등록 \t 3.삭제 \t 4.검색 \t 5.종료");
		System.out.print("메뉴번호>");
	} // menu종료
	
	public static void end() {
		System.out.println(" 종료합니다 ");
	} // end종료
	
	public static void addList(BufferedReader br) throws IOException {
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			String[] txt = line.split(","); // 입력 정보를 ,으로 나누겠다
			pArray.add(new Person(txt[0], txt[1], txt[2]));
		}
	} //addList 종료
	
	public static void printList() {
		System.out.println("1.리스트>");
//		향상된 for문 for(대입받을 변수정의 : 배열명) -배열에만 사용가능
//		for (int i=0; i<pArray.length ;i++) {		} // for문쓰려다가 실패
		for (Person ps : pArray) {
			System.out.println(pArray.indexOf(ps)+1+". "); // 정수에 1추가
			ps.showInfo();
		}
	} //printList 종료
	
	public static void add() {
//		이하 sc 스캐너 종료시 루프 에러 조심 
		Scanner sc = new Scanner(System.in);
		String name; // 이름
		String hp;  //휴대전화
		String company;  //회사전화
		
		System.out.println("2.등록> 이름 휴대전화 회사전화 순서 입력");
		System.out.print("이름> ");
		name = sc.nextLine();
		System.out.print("휴대전화> ");
		hp = sc.nextLine();
		System.out.print("회사전화> ");
		company = sc.nextLine();
		
//		입력받은 정보를 배열에 추가
		pArray.add(new Person(name, hp, company));
	} //add 종료
	
	public static void modify() throws IOException {
		BufferedWriter bw= new BufferedWriter(new FileWriter("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt"));
		for (Person p: pArray) {
			bw.write(p.save());
			bw.newLine();
		}  // 입력받은 정보를 텍스트에 저장
		bw.close();
		System.out.println("변경사항이 저장되었습니다.");
		
	} // modify 종료
	
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("3.삭제> 지울 번호를 입력");
		System.out.print("번호>");
		int index = sc.nextInt();
		pArray.remove(index-1); // -1를 추가하여 정수입력과 숫자를 맞춤
		System.out.println(index+"번이 삭제 되었습니다.");
		
	} // delete 종료
	
	public static void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("4.검색> 번호를 알고싶은 사람의 이름을 입력");
		System.out.print("이릅> ");
		String search = sc.nextLine();
		
//		search로 입력받은 사람의 전번을 출력
		for (Person ps : pArray) {
			if (ps.getName().contains(search)) {
				System.out.println(pArray.indexOf(ps)+1+". "); //정수1을 추가한다
				ps.showInfo();
			}
		}
		
	}
}
