package atm;

import java.util.Scanner;

public class ATMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM demo=new ATM();
		System.out.println("欢迎使用火才ATM\n");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.注册     2.登陆");
			int i=sc.nextInt();
			if(i==1) {
				System.out.println("请输入名字:");
				String name=sc.next();
				System.out.println("请输入密码");
				String passwd=sc.next();
				Person person=demo.reigster(name, passwd);
				if(person!=null) {
					System.out.println("注册成功");
					System.out.println(person);
				}else {
					System.out.println("注册失败");
				}
			}
			if(i==2) {
				sc=new Scanner(System.in);
				System.out.println("请输入账号");
				String acount=sc.next();
				System.out.println("请输入密码");
				String passwd=sc.next();
				Person person=demo.land(acount, passwd);
				if(person!=null) {
					System.out.println("登陆成功\n");
					c:while(true) {
						System.out.println("1.存钱   2.取钱   3.转账   4.查询   5.返回主菜单");
						int j=sc.nextInt();
						double money=0;
						switch(j) {
						case 1:
							System.out.println("请输入存多少钱");
							money=sc.nextDouble();
							demo.save(money);
							System.out.println("存钱成功\n");
							break;
						case 2:
							System.out.println("请输入取多少钱");
							money=sc.nextDouble();
							demo.take(money);
							System.out.println("取钱成功\n");
							break;
						case 3:
							sc=new Scanner(System.in);
							System.out.println("请输入对方账号");
							String newAcount=sc.next();
							System.out.println("请输转多少钱");
							money=sc.nextDouble();
							demo.transfer(newAcount, money);
							System.out.println("转钱成功\n");
							break;
						case 4:
							System.out.println(demo.query());
							break;
						case 5:
							break c;
						case 6:
							demo.showAll();
							break;
						default:
							break;
						}
					}
					
				}else {
					System.out.println("登陆失败");
				}
			}
		}
	}

}
