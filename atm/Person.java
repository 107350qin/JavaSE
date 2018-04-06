package atm;

public class Person {
	private int id;//
	private String name;
	private String acount;//
	private String passwd;
	private double money;
	public Person(int id, String name, String acount, String passwd, double money) {
		super();
		this.id = id;
		this.name = name;
		this.acount = acount;
		this.passwd = passwd;
		this.money = money;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcount() {
		return acount;
	}
	public void setAcount(String acount) {
		this.acount = acount;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", acount=" + acount + ", passwd=" + passwd + ", money=" + money
				+ "]";
	}
	
}
