package animal.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class AnimalBean {

	private int num;
	
	@NotEmpty
	@Length(min = 4,max = 12,message = "4~8�ڸ��� �Է����ּ���.")
	private String id;
	
	@NotEmpty(message = "���� �з��� �������ּ���.")
	private String class_animal;
	
	@NotEmpty(message = "���� ������ �������ּ���.")
	private String family_animal;
	
	@NotEmpty(message = "�������� �������ּ���.")
	private String many_animal;
	
	private String prduct_animal;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClass_animal() {
		return class_animal;
	}
	public void setClass_animal(String class_animal) {
		this.class_animal = class_animal;
	}
	public String getFamily_animal() {
		return family_animal;
	}
	public void setFamily_animal(String family_animal) {
		this.family_animal = family_animal;
	}
	public String getMany_animal() {
		return many_animal;
	}
	public void setMany_animal(String many_animal) {
		this.many_animal = many_animal;
	}
	public String getPrduct_animal() {
		return prduct_animal;
	}
	public void setPrduct_animal(String prduct_animal) {
		this.prduct_animal = prduct_animal;
	}
	
	
	
	
}
