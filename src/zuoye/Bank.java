package zuoye;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
public class Bank {
	List<Person> ren=new ArrayList<Person>();
	ArrayList<String> id_card=new ArrayList<String>();
//	增加用户方法
	public void creatP() {
		Scanner in=new Scanner(System.in);
		System.out.println("你选择了开户业务");
		System.out.println("请输入您的帐户名");
		String name_=in.next();
		System.out.println("请输入您要创建的卡号");
		String id_=in.next();
		id_card.add(id_);
		System.out.println("请输入您要存入的金额：");
		Long money_=in.nextLong();
		Person p=new Person(name_,id_,money_);
		System.out.println(p.toString());
		ren.add(p);
	}
	
//	存钱方法
	public void savemoney() {
		System.out.println("您选择了存款业务");
		System.out.println("请输入您的卡号");
		Scanner in=new Scanner(System.in);
		String id1=in.next();
//		System.out.println(id_card);
		if(id_card.contains(id1)){
			System.out.println("用户存在");
			System.out.println(id_card.size());
			for(int i=0;i<id_card.size();i++) {
				Person obj=(Person) ren.get(i);
				
				if(id1.equals(obj.getId())) {
					System.out.println("请输入你要存的金额:");
					Long money_c = in.nextLong();
					Long monye_y = obj.getMoney();
					Long new_money = money_c + monye_y;
					obj.setMoney(new_money);
					System.out.println("你的余额为：" + new_money);
				} else {
					continue;
				}
			}
		}
		else {
			System.out.println("用户不存在");
		}
	}
	
//	取钱方法
	public void drawmoney() {System.out.println("您选择了取款业务");
	System.out.println("请输入您的卡号");
	Scanner in=new Scanner(System.in);
	String id1=in.next();
	if(id_card.contains(id1)) {
		
		for(int b=0;b<id_card.size();b++) {
			Person obj=(Person) ren.get(b);
			if(id1.equals(obj.getId())) {
				System.out.println("请输入您要取款的金额");
				Long money_q=in.nextLong();
				Long money_y=obj.getMoney();
				if(money_y<money_q) {
					System.out.println("余额不足");
				}else {
					
				
				Long newmoney=money_y-money_q;
				obj.setMoney(newmoney);
				System.out.println("你的余额为："+newmoney);
			}
				}else {
				continue;
				}
			}
		}
	else {
		System.out.println("用户不存在");
		
		}
	}
	
//	转账方法
	public void transformoney() {
		System.out.print("您选择了转账业务,");
		System.out.println("请输入您的卡号");
		Scanner in=new Scanner(System.in);
		String chu=in.next();
		System.out.println("请您输入您要转入的账号");
		String ru=in.next();
		if(id_card.contains(chu)&&id_card.contains(ru)) {
			
			Long money_zhuan=null;
			for(int b=0;b<id_card.size();b++) {
				Person obj=(Person) ren.get(b);
				if(chu.equals(obj.getId())) {
					System.out.println("请输入您要转账的金额");
					 money_zhuan=in.nextLong();
					Long money_zy=obj.getMoney();
					if(money_zy<money_zhuan) {
						System.out.println("余额不足");
					}else {
						
					Long newmoney=money_zy-money_zhuan;
					obj.setMoney(newmoney);
					System.out.println("你的余额为："+newmoney);
				}
					}else {
					continue;
					}
					
				}
//			转入人收款
			for(int j=0;j<id_card.size();j++) {
				Person obj = (Person) ren.get(j);
				if (ru.equals(obj.getId())) {
					Long money_chu = obj.getMoney();
					
					Long new_money =money_chu+money_zhuan;
					obj.setMoney(new_money);
				} else {
					continue;
				}
			}
		} else {
			System.out.println("用户不存在");
		}
	}
//	查询所有方法
	public void findall() {
		System.out.println("您选择的业务是查询");
		System.out.println(ren);
	}
//	按卡号查询用户信息
	public void findbyid() {
		System.out.println("您选择的是查询个人用户信息");
		System.out.println("请输入您的卡号");
//		System.out.println(id_card);
		Scanner in=new Scanner(System.in);
		String id2=in.next();
		if(id_card.contains(id2)){
			for(int i=0;i< id_card.size(); i++) {
				Person obj=(Person)ren.get(i);
				
				if(id2.equals(obj.getId())) {
					System.out.println(obj);
			}
				else {
					continue;
				}
			}

			
			}
		else {
			System.out.println("用户不存在");
		}
	}
	
	
	
	
	public static void main(String[]args) {
		Bank a=new Bank();
		System.out.println("欢迎来到银行系统，请选择您要办理的业务");
		while(true) {
			
			Scanner in=new Scanner(System.in);
			System.out.print("1-开户"+"2-存钱"+"3-取钱"+"4-转账"+"5-查询"+"6-查询全部");
			int i=in.nextInt();
			if(i==1) {
				a.creatP();
				}
			else if(i==2){
				a.savemoney();
			}
			else if(i==3) {
				a.drawmoney();
			}
			else if(i==4) {
				a.transformoney();
			}
			else if(i==5) {
				a.findbyid();
			}
			else if(i==6) {
				
				a.findall();
			}
			else {
				System.out.println("你的输入有误，请重新选择");
			}
		}
	
	}

}
