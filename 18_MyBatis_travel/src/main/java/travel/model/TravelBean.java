package travel.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	private int num;
	
	@NotEmpty(message = "�̸��� �ʼ� �Է� �����Դϴ�.")
	private String name;
	
	@Range(min = 10, max =100, message = "10�� ~ 100��� �ۼ��ؾ� �մϴ�.")
	private int age;
	
	@NotEmpty(message = "���������� 1�� �̻� �����ؾ� �մϴ�.")
	private String area;
	
	@NotEmpty(message = "���ϴ� ���� Ÿ���� ������ �ּ���.")
	private String style;
	
	@NotEmpty(message = "���ϴ� ���ݴ븦 �����ϼ���.")
	private String price;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

}
