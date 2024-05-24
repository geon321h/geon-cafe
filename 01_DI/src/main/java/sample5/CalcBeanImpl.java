package sample5;

public class CalcBeanImpl implements CalcBean{

	private int su1; //setter ÁÖÀÔ
	private int su2; //»ı¼ºÀÚ ÁÖÀÔ
	
	public CalcBeanImpl(int su2) {
		super();
		this.su2 = su2;
	}
	
	@Override
	public void calculate() {
	
		System.out.println("µ¡¼À:"+(su1+su2));
		System.out.println("»¬¼À:"+(su1-su2));
		System.out.println("°öÇÏ±â:"+(su1*su2));
		System.out.println("³ª´©±â:"+(su1/su2));
		System.out.println("³ª¸ÓÁö:"+(su1%su2));
		
	}

	public int getSu1() {
		return su1;
	}

	public void setSu1(int su1) {
		this.su1 = su1;
	}
	
	
	
}
