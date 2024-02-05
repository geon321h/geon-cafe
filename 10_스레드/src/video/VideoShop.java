package video;

import java.util.Vector;

public class VideoShop {

	private Vector<String>	 v = new Vector<String>();

	public VideoShop() {
		
		v.addElement("어벤져스");
		v.addElement("라이온킹");
		v.addElement("스파이더맨");
		
	}
	
	public synchronized String lendVideo() throws InterruptedException {
		
		Thread t = Thread.currentThread();
		
		if(v.size() == 0) {
			
			System.out.println(t.getName() + "번호표를 받음");
			wait();
			System.out.println(t.getName() + "다음 순서");
			
		}
		
		int size = v.size();
		String str = v.remove(size-1);
		return str;
		
	}
	
	public synchronized void returnVideo(String video) {
		
		v.addElement(video);
		notify();
		
	}
	
}
