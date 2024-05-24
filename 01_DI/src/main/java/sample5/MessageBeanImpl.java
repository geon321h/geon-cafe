package sample5;

public class MessageBeanImpl implements MessageBean{

	private String name; //������ ���� ����
	private String greeting; //setter ���� Hello
	
	public MessageBeanImpl(String name) {
		super();
		this.name = name;
	}

	@Override
	public void sayHello() {
		System.out.println(greeting+" "+name);
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	

}
