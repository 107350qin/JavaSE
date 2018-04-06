package atm;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class ATM {
	static int id=0;
	/**
	 * 这个person变量不可以初始化，必须在添加账户的时候再初始化，此person变量指当前的人
	 */
	private Person person;
	public HashMap<String,Person> atm=new HashMap<>();
	

	public Person reigster(String name,String passwd) {
		person=new Person();
		person.setId(++id);
		person.setName(name);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date=new Date();
		String acount=sdf.format(date)+id;
		person.setAcount(acount);
		person.setPasswd(passwd);
		atm.put(acount, person);
		return person;
	}
	
	public Person land(String acount,String passwd) {
		Person person=atm.get(acount);
		if(person!=null) {
			if(person.getAcount().equals(acount)) {
				if(person.getPasswd().equals(passwd)) {
					return person;
				}else {
					System.out.println("密码错误");
					return null;
				}
			}else {
				System.out.println("账号错误");
				return null;
			}
		}else {
			System.out.println("没有这个账户");
			return null;
		}
	}
	
	public boolean save(double money) {
		person.setMoney(person.getMoney()+money);
		return true;
	}
	public boolean take(double money) {
		person.setMoney(person.getMoney()-money);
		return true;
	}
	public Person query() {
		return person;
	}
	public void showAll() {
		Collection<Person> s=atm.values();
		for(Person a:s) {
			System.out.println(a);
		}
	}
	public boolean transfer(String newAcount,double addMoney) {
		double m=atm.get(newAcount).getMoney();
		atm.get(newAcount).setMoney(m+addMoney);
		double n=person.getMoney();
		person.setMoney(n-addMoney);
		return true;
	}
}
