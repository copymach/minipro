package Contacts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ListContact {

	public static void main(String[] args) throws IOException {

		//ArrayList 메모리에 올리기
		List<Data> pList = new ArrayList<Data>();
		
		//phoneDB.txt 접속
		Reader fr = new FileReader("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			//한줄씩 읽는다.
			String line = br.readLine();
			if(line == null) { //마지막 끝
				break;
			}
			
			//마지막이 아니면 ,로 구분한다
			String[] dArray = line.split(",");
			String name = dArray[0];
			String hp = dArray[1];
			String company = dArray[2];
			

			//Person객체를 생성하고 값을 넣어준다
			Data p01 = new Data(name, hp, company);
			
			//*******리스트에 추가해준다*******
			pList.add(p01);
		}
		
		
		//화면출력
		
		System.out.println("<1. 리스트>");
		for(int i=0; i<pList.size(); i++) {
			System.out.println(i+". 이름:" + pList.get(i).getName()+" 핸드폰:" + pList.get(i).getHp()+" 회사:" + pList.get(i).getCompany());
		}
		System.out.println("");
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("-----------------------------");
		System.out.println(">메뉴번호 :");
		
		//테스트용 toString 
		//System.out.println(pList.toString());

		br.close();
		
	}

}
