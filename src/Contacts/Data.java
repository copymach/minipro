package Contacts;

public class Data {

	
	private String name; // 이름
	private String hp;  //개인전번
	private String company;  //회사전번
	
	
	
	public Data() { }
	public Data(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Data [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	
	

}
