package member.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	private int num;
	@NotBlank(message = "�̸����� �ʼ��Դϴ�.")
	private String email;
	@NotBlank(message = "�̸��� �ʼ��Դϴ�.")
	private String name;
	@NotBlank(message = "����� �ʼ��Դϴ�.")
	private String password;
	@NotEmpty(message = "������ �������ּ���.")
	private String gender;
	@NotEmpty(message = "��̴� 1�� �̻� �����ؾ� �մϴ�.")
	private String hobby;
	private String job;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	


}  



