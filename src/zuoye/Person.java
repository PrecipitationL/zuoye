package zuoye;

public class Person {
 
	private String name;
	private String id;
	private Long money;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", money=" + money + "]";
	}
	public Person() {
		
	}
	public Person(String name,String id,Long money) {
		this.id=id;
		this.name=name;
		this.money=money;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	
	
	}


