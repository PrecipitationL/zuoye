package zuoye;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
public class Bank {
	List<Person> ren=new ArrayList<Person>();
	ArrayList<String> id_card=new ArrayList<String>();
//	�����û�����
	public void creatP() {
		Scanner in=new Scanner(System.in);
		System.out.println("��ѡ���˿���ҵ��");
		System.out.println("�����������ʻ���");
		String name_=in.next();
		System.out.println("��������Ҫ�����Ŀ���");
		String id_=in.next();
		id_card.add(id_);
		System.out.println("��������Ҫ����Ľ�");
		Long money_=in.nextLong();
		Person p=new Person(name_,id_,money_);
		System.out.println(p.toString());
		ren.add(p);
	}
	
//	��Ǯ����
	public void savemoney() {
		System.out.println("��ѡ���˴��ҵ��");
		System.out.println("���������Ŀ���");
		Scanner in=new Scanner(System.in);
		String id1=in.next();
//		System.out.println(id_card);
		if(id_card.contains(id1)){
			System.out.println("�û�����");
			System.out.println(id_card.size());
			for(int i=0;i<id_card.size();i++) {
				Person obj=(Person) ren.get(i);
				
				if(id1.equals(obj.getId())) {
					System.out.println("��������Ҫ��Ľ��:");
					Long money_c = in.nextLong();
					Long monye_y = obj.getMoney();
					Long new_money = money_c + monye_y;
					obj.setMoney(new_money);
					System.out.println("������Ϊ��" + new_money);
				} else {
					continue;
				}
			}
		}
		else {
			System.out.println("�û�������");
		}
	}
	
//	ȡǮ����
	public void drawmoney() {System.out.println("��ѡ����ȡ��ҵ��");
	System.out.println("���������Ŀ���");
	Scanner in=new Scanner(System.in);
	String id1=in.next();
	if(id_card.contains(id1)) {
		
		for(int b=0;b<id_card.size();b++) {
			Person obj=(Person) ren.get(b);
			if(id1.equals(obj.getId())) {
				System.out.println("��������Ҫȡ��Ľ��");
				Long money_q=in.nextLong();
				Long money_y=obj.getMoney();
				if(money_y<money_q) {
					System.out.println("����");
				}else {
					
				
				Long newmoney=money_y-money_q;
				obj.setMoney(newmoney);
				System.out.println("������Ϊ��"+newmoney);
			}
				}else {
				continue;
				}
			}
		}
	else {
		System.out.println("�û�������");
		
		}
	}
	
//	ת�˷���
	public void transformoney() {
		System.out.print("��ѡ����ת��ҵ��,");
		System.out.println("���������Ŀ���");
		Scanner in=new Scanner(System.in);
		String chu=in.next();
		System.out.println("����������Ҫת����˺�");
		String ru=in.next();
		if(id_card.contains(chu)&&id_card.contains(ru)) {
			
			Long money_zhuan=null;
			for(int b=0;b<id_card.size();b++) {
				Person obj=(Person) ren.get(b);
				if(chu.equals(obj.getId())) {
					System.out.println("��������Ҫת�˵Ľ��");
					 money_zhuan=in.nextLong();
					Long money_zy=obj.getMoney();
					if(money_zy<money_zhuan) {
						System.out.println("����");
					}else {
						
					Long newmoney=money_zy-money_zhuan;
					obj.setMoney(newmoney);
					System.out.println("������Ϊ��"+newmoney);
				}
					}else {
					continue;
					}
					
				}
//			ת�����տ�
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
			System.out.println("�û�������");
		}
	}
//	��ѯ���з���
	public void findall() {
		System.out.println("��ѡ���ҵ���ǲ�ѯ");
		System.out.println(ren);
	}
//	�����Ų�ѯ�û���Ϣ
	public void findbyid() {
		System.out.println("��ѡ����ǲ�ѯ�����û���Ϣ");
		System.out.println("���������Ŀ���");
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
			System.out.println("�û�������");
		}
	}
	
	
	
	
	public static void main(String[]args) {
		Bank a=new Bank();
		System.out.println("��ӭ��������ϵͳ����ѡ����Ҫ�����ҵ��");
		while(true) {
			
			Scanner in=new Scanner(System.in);
			System.out.print("1-����"+"2-��Ǯ"+"3-ȡǮ"+"4-ת��"+"5-��ѯ"+"6-��ѯȫ��");
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
				System.out.println("�����������������ѡ��");
			}
		}
	
	}

}
