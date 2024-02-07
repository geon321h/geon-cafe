import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

class Ex04 extends Frame{
	
	public Ex04(String title) {

		super(title);
		super.setSize(400,300);
		super.setVisible(true);
		
		//super.setLayout(new FlowLayout()); // 사이즈가 부족하면 자동으로 위치가 세로로 배치된다.
		super.setLayout(new BorderLayout()); // 배치관리자를 적지 않으면 해당 위치로 기본세팅된다. 보더레이아웃은 위치를 적지않을시 가운데정렬된다.
		//super.setLayout(new GridLayout(2,3)); // 배열처럼 행과 열을 적은 수에 따라 공간이 설정됨
		
		Button east = new Button("동쪽");
		Button west = new Button("서쪽");
		Button south = new Button("남쪽");
		Button north = new Button("북쪽");
		Button center = new Button("중앙");
		
		this.add(east,"East"); // 상속받기 에 this를 써도됨
		super.add(west,BorderLayout.WEST);
		add(south,"South"); // this는 생략가능함
		super.add("North",north); // 위치와 버튼명의 순서는 상관없음
		super.add(center,BorderLayout.CENTER);
		
	}
	
}

public class Ex04_BorderLayout {

	public static void main(String[] args) {

		Frame ex = new Ex04("Ex04");
		
	}

}
