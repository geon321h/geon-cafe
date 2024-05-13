package myPkg;

public class Person {

	private String name;
	private String gender;
	private String[] hobby;
	private int age;
	private double weight;

	public Person() {
	
	}
	
	public Person(String name,int age,double weight) {
		this.name =name;
		this.age =age;
		this.weight =weight;
	}
	
	public Person(String name,int age,String gender,String[] hobby) {
		this.name =name;
		this.age =age;
		this.gender =gender;
		this.hobby =hobby;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String toString() {
		return name+"/"+age+"/"+weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
	
	
	
	
	
}

