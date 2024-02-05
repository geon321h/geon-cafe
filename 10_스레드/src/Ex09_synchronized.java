class Bank {

	private int money = 10000;
	
	public int getMoney() {
		
		return money;
		
	}
	
	public void setMoney(int money) {
		
		this.money = money;
		
	}
	
	public synchronized void saveMoney(int save) {
		
		money += save;
		
	}
	
	public void minusMoney(int minus) {
		
		synchronized (this) {
			
			money -= minus;

		}
		
		
	}
	
}

class Park extends Thread{
	
	public void run() {
		
		Ex09_synchronized.myBank.saveMoney(3000);
		System.out.println("park(3000):" + Ex09_synchronized.myBank.getMoney());
		
	}
	
}

class Kim extends Thread{
	
	public void run() {

		Ex09_synchronized.myBank.saveMoney(500);
		System.out.println("Kim(500):" + Ex09_synchronized.myBank.getMoney());
		
	}
	
}

public class Ex09_synchronized {
	
	static Bank myBank = new Bank();

	public static void main(String[] args) {

		Park p = new Park();
		Kim k = new Kim();
		
		p.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		k.start();
		
		
	}

}
